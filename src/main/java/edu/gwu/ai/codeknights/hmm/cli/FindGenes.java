package edu.gwu.ai.codeknights.hmm.cli;

import java.util.Arrays;
import java.util.List;

import org.pmw.tinylog.Logger;

import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.HMM;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;
import edu.gwu.ai.codeknights.hmm.core.State;
import picocli.CommandLine.Command;

@Command(
  name = FindGenes.CMD_NAME, sortOptions = false, showDefaultValues = true,
  description = "find the protein-coding genes in the given sequence")
public class FindGenes extends AbstractFindCmd {

  public static final String CMD_NAME = "find-genes";

  @Override
  protected void validateArgs() throws Exception {
    super.validateArgs();
  }

  @Override
  public String getCmdName() {
    return CMD_NAME;
  }

  @Override
  public Void call() throws Exception {
    validateArgs();

    // Create sequence
    final FastaSequence seq = createSequenceFromInput();

    // Find most likely explanation of states
    final HMM hmm = new HMM(getPnn(), getPgg());
    final long startTimeMs = System.currentTimeMillis();
    final HMM.Result result = hmm.evaluate(seq);
    final State[] states = result.getStates();
    final StringBuilder stateStr = new StringBuilder();
    for (final State state : states) {
      stateStr.append(state);
    }
    final List<Gene> genes = hmm.extractGenes(stateStr.toString());
    final long endTimeMs = System.currentTimeMillis();

    // Print result
    System.out.println("seq=" + seq.toPrimString());
    System.out.println("states=" + stateStr.toString());
    for (final Gene gene : genes) {
      final int endIdx = gene.getStartIdx() + gene.getLength() - 1;
      System.out.println("  > gene at seq[" + String.valueOf(gene.getStartIdx()) + ":" + String.valueOf(endIdx)
        + "] (length=" + String.valueOf(gene.getLength()) + "): " + String.valueOf(gene.getNucleotides(seq)));
    }
    System.out.println("numGenes=" + String.valueOf(genes.size()));
    final long numCoding = Arrays.asList(states).stream().filter(s -> State.CODING.equals(s)).count();
    System.out
      .println("percent in state " + State.CODING.name() + ": " + (double) numCoding / (double) states.length * 100.0);
    System.out.println("pathScore=" + String.valueOf(result.getPathScore()) + " (prob="
      + String.valueOf(result.getPathProbability()) + ")");

    // Log elapsed time
    final double elapsedSec = (double) (endTimeMs - startTimeMs) / 1000.0;
    Logger.debug("elapsedSec={}", elapsedSec);

    // Done.
    return null;
  }

  public static class Gene {

    private final int startIdx;
    private final int endIdx;

    public Gene(final int startIdx, final int endIdx) {
      this.startIdx = startIdx;
      this.endIdx = endIdx;
    }

    public int getStartIdx() {
      return startIdx;
    }

    public int getLength() {
      return endIdx - startIdx;
    }

    public List<Nucleotide> getNucleotides(final FastaSequence seq) {
      return seq.getNucleotides().subList(startIdx, endIdx);
    }
  }
}
