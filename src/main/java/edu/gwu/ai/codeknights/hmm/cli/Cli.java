package edu.gwu.ai.codeknights.hmm.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.RunLast;

@Command(
  name = Cli.CMD_NAME, sortOptions = false, showDefaultValues = true,
  description = "command-line interface for HMM",
  subcommands = {
    PrintSequence.class,
    ComputeProbs.class,
    FindGenes.class
  })
public class Cli extends AbstractCmd {

  public static final String CMD_NAME = "hmm";

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
    new CommandLine(this).usage(System.err);
    return null;
  }

  public static void main(final String[] args) {
    final CommandLine commandLine = new CommandLine(new Cli());
    commandLine.parseWithHandler(new RunLast(), System.err, args);
  }
}
