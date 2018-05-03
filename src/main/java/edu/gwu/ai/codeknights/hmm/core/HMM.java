package edu.gwu.ai.codeknights.hmm.core;

import java.util.ArrayList;
import java.util.List;

import edu.gwu.ai.codeknights.hmm.config.Const;

public class HMM {

  private final EmitProbTable emitProbTable;

  private final double pnn;
  private final double pgg;

  public HMM(final double pnn, final double pgg, final EmitProbTable emitProbTable) {
    this.pnn = pnn;
    this.pgg = pgg;
    this.emitProbTable = emitProbTable;
  }

  public HMM(final double pnn, final double pgg) {
    this(pnn, pgg, Const.DEFAULT_EMIT_PROB_TABLE);
  }

  public HMM() {
    this(Const.DEFAULT_PROB_N_N, Const.DEFAULT_PROB_G_G, Const.DEFAULT_EMIT_PROB_TABLE);
  }

  public double getProbNN() {
    return pnn;
  }

  public double getProbNG() {
    return 1 - pnn;
  }

  public double getProbGG() {
    return pgg;
  }

  public double getProbGN() {
    return 1 - pgg;
  }

  public double getProbN(final Nucleotide n1, final Nucleotide n2, final Nucleotide n3) {
    return 1.0 / 64.0;
  }

  public double getProbG(final Nucleotide n1, final Nucleotide n2, final Nucleotide n3) {
    return emitProbTable.getProb(n1, n2, n3);
  }

  public double getProb(final State s, final Nucleotide n1, final Nucleotide n2, final Nucleotide n3) {
    if (State.NON_CODING.equals(s)) {
      return getProbN(n1, n2, n3);
    }
    else {
      return getProbG(n1, n2, n3);
    }
  }

  public EmitProbTable getEmitProbTable() {
    return emitProbTable;
  }

  public List<State> evaluate(final FastaSequence seq) {
    final List<State> states = new ArrayList<>();

    // Always start in non-coding state
    Nucleotide n1 = null;
    Nucleotide n2 = Nucleotide.A;
    Nucleotide n3 = Nucleotide.A;
    State prevState = null;
    State curState = State.NON_CODING;
    for (int i = 0; i < seq.length(); i++) {
      n1 = n2;
      n2 = n3;
      n3 = seq.get(i);
      prevState = curState;
      curState = null;
      // TODO: use forward-algorithm to determine most likely current state
      states.add(curState);
    }

    // Return result
    return states;
  }
}
