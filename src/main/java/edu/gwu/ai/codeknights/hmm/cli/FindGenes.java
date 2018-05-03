package edu.gwu.ai.codeknights.hmm.cli;

import java.util.List;

import org.pmw.tinylog.Logger;

import edu.gwu.ai.codeknights.hmm.config.Const;
import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.HMM;
import edu.gwu.ai.codeknights.hmm.core.State;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
  name = FindGenes.CMD_NAME, sortOptions = false, showDefaultValues = true,
  description = "find the protein coding genes in the given sequence")
public class FindGenes extends AbstractInputFileCmd {

  public static final String CMD_NAME = "find";

  @Option(names = {"--pnn"}, description = "probability of remaining in non-coding region")
  private double pnn = Const.DEFAULT_PROB_N_N;

  @Option(names = {"--pgg"}, description = "probability of remaining in coding region")
  private double pgg = Const.DEFAULT_PROB_G_G;

  @Override
  protected void validateArgs() throws Exception {
    super.validateArgs();

    pnn = Math.max(Math.min(pnn, 1.0), 0.0);
    pgg = Math.max(Math.min(pgg, 1.0), 0.0);
  }

  protected double getPnn() {
    return pnn;
  }

  protected double getPgg() {
    return pgg;
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

    // Find protein-coding genes
    final HMM hmm = new HMM(pnn, pgg);
    final long startTimeMs = System.currentTimeMillis();
    final List<State> states = hmm.evaluate(seq);
    final long endTimeMs = System.currentTimeMillis();

    // Print result
    System.out.println(String.valueOf(states));

    // Log elapsed time
    final double elapsedSec = (double) (endTimeMs - startTimeMs) / 1000.0;
    Logger.debug("elapsedSec={}", elapsedSec);

    // Done.
    return null;
  }
}
