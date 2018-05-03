package edu.gwu.ai.codeknights.hmm.cli;

import edu.gwu.ai.codeknights.hmm.config.Const;
import picocli.CommandLine.Option;

public abstract class AbstractFindCmd extends AbstractInputFileCmd {

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
}
