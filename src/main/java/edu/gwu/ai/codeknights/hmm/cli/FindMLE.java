package edu.gwu.ai.codeknights.hmm.cli;

import java.util.Arrays;

import org.pmw.tinylog.Logger;

import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.HMM;
import edu.gwu.ai.codeknights.hmm.core.State;
import picocli.CommandLine.Command;

@Command(
  name = FindMLE.CMD_NAME, sortOptions = false, showDefaultValues = true,
  description = "find the most likely explanation of states for the given sequence")
public class FindMLE extends AbstractFindCmd {

  public static final String CMD_NAME = "find-mle";

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
    final State[] states = hmm.evaluate(seq);
    final long endTimeMs = System.currentTimeMillis();

    // Print result
    System.out.println(String.valueOf(Arrays.asList(states)));

    // Log elapsed time
    final double elapsedSec = (double) (endTimeMs - startTimeMs) / 1000.0;
    Logger.debug("elapsedSec={}", elapsedSec);

    // Done.
    return null;
  }
}
