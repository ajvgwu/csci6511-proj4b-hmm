package edu.gwu.ai.codeknights.hmm.cli;

import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.HMM;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;
import edu.gwu.ai.codeknights.hmm.core.State;
import org.pmw.tinylog.Logger;
import picocli.CommandLine.Command;

import java.util.List;

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
    State[] states = hmm.evaluate(seq);
    final StringBuilder stateStr = new StringBuilder();
    for (State state : states) {
      stateStr.append(state);
    }
    List<Gene> genes = hmm.extractGenes(stateStr.toString());
    final long endTimeMs = System.currentTimeMillis();

    // Print result
    System.out.println(" Genes=" + seq.toPrimString());
    System.out.println("states=" + stateStr.toString());
    for (final Gene gene : genes) {
      System.out.println("  > gene at idx=" + String.valueOf(gene.getStartIdx()) + ", length="
        + String.valueOf(gene.getLength()) + ": " + String.valueOf(gene.getNucleotides(seq)));
    }

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
