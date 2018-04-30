package edu.gwu.ai.codeknights.hmm.core;

import java.util.ArrayList;
import java.util.List;

public class HMM {

  private final double pnn;
  private final double pgg;

  public HMM(final double pnn, final double pgg) {
    this.pnn = pnn;
    this.pgg = pgg;
  }

  public double getPnn() {
    return pnn;
  }

  public double getPgg() {
    return pgg;
  }

  public List<State> evaluate(final FastaSequence seq) {
    final List<State> states = new ArrayList<>();
    //TODO: implement
    return states;
  }
}
