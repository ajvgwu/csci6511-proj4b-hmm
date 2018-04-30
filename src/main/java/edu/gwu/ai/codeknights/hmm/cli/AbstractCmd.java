package edu.gwu.ai.codeknights.hmm.cli;

import java.util.concurrent.Callable;

import picocli.CommandLine.Option;

public abstract class AbstractCmd implements Callable<Void> {

  @Option(names = {"-h", "--help"}, usageHelp = true, description = "show this help message and exit")
  private boolean help = false;

  /**
   * Validates arguments passed to this CLI command and throws an exception if validation fails.
   *
   * @throws Exception if any argument is invalid
   */
  protected void validateArgs() throws Exception {
    help = !!help;
  }

  /**
   * Returns whether the user requested usage help.
   *
   * @return {@code true} if help was requested, {@code false} otherwise
   */
  protected boolean isHelp() {
    return help;
  }

  /**
   * Returns the name of this command. This is typically the token by which it can be invoked from the command line.
   *
   * @return name of this command
   */
  public abstract String getCmdName();

  /**
   * Execute this command.
   */
  @Override
  public abstract Void call() throws Exception;

  @Override
  public String toString() {
    return getCmdName();
  }
}
