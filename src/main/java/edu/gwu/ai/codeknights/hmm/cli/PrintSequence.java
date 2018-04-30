package edu.gwu.ai.codeknights.hmm.cli;

import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import picocli.CommandLine.Command;

@Command(
  name = PrintSequence.CMD_NAME, sortOptions = false, showDefaultValues = true,
  description = "print the input sequence")
public class PrintSequence extends AbstractInputFileCmd {

  public static final String CMD_NAME = "print";

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

    // Print sequence
    System.out.println(seq.toString());

    // Done.
    return null;
  }
}
