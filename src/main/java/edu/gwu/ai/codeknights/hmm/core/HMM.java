package edu.gwu.ai.codeknights.hmm.core;

import java.util.ArrayList;
import java.util.List;

import edu.gwu.ai.codeknights.hmm.cli.FindGenes;
import edu.gwu.ai.codeknights.hmm.config.Const;

public class HMM {

  private final double pnn;
  private final double pgg;
  private final EmitProbTable emitProbTable;

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

  /**
   * Construct "Most Likely Explanation" (MLE) of states for the given sequence
   *
   * @param seq input sequence
   * @return most likely explanation of states
   */
  public Result evaluate(final FastaSequence seq) {
    // Assume 'AA' is prepended to input sequence
    Nucleotide n1 = null;
    Nucleotide n2 = Nucleotide.A;
    Nucleotide n3 = Nucleotide.A;

    // Always start in non-coding state
    final int length = seq.length();
    final double[][] logProbs = new double[2][length];

    // Compute probabilities for all possible paths using Viterbi algorithm
    for (int i = 0; i < length; i++) {
      n1 = n2;
      n2 = n3;
      n3 = seq.get(i);

      // Determine probabilities for current state based on previous most likely state
      final double prevProbN_log = i > 0 ? logProbs[State.NON_CODING.ordinal()][i - 1] : log2(1.0);
      final double prevProbG_log = i > 0 ? logProbs[State.CODING.ordinal()][i - 1] : log2(0.0);
      final State prevState = prevProbN_log > prevProbG_log ? State.NON_CODING : State.CODING;
      final double prevProb_log = Math.max(prevProbN_log, prevProbG_log);
      final double emissionProbN_log = log2(getProbN(n1, n2, n3));
      final double emissionProbG_log = log2(getProbG(n1, n2, n3));

      // Compute probability for NON_CODING state
      double probN_log = emissionProbN_log;
      if (State.NON_CODING.equals(prevState)) {
        probN_log += log2(getProbNN());
      }
      else {
        probN_log += log2(getProbGN());
      }
      logProbs[State.NON_CODING.ordinal()][i] = probN_log + prevProb_log;

      // Compute probability for CODING state
      double probG_log = emissionProbG_log;
      if (State.CODING.equals(prevState)) {
        probG_log += log2(getProbGG());
      }
      else {
        probG_log += log2(getProbNG());
      }
      logProbs[State.CODING.ordinal()][i] = probG_log + prevProb_log;
    }

    // Return most likely explanation (sequence of states)
    final State[] mle = new State[length];
    double pathScore = log2(0);
    for (int i = 0; i < length; i++) {
      final double probN_log = logProbs[State.NON_CODING.ordinal()][i];
      final double probG_log = logProbs[State.CODING.ordinal()][i];
      mle[i] = probN_log > probG_log ? State.NON_CODING : State.CODING;
      pathScore = probN_log > probG_log ? probN_log : probG_log;
    }
    return new Result(mle, pathScore);
  }

  public List<FindGenes.Gene> extractGenes(final String stateStr) {
    final String[] regions = stateStr.split(State.NON_CODING.getId());

    // Find protein-coding genes
    final List<FindGenes.Gene> genes = new ArrayList<>();
    for (int i = 0, index = 0; i < regions.length; i++) {
      final FindGenes.Gene gene = new FindGenes.Gene(index, index += regions[i].length());
      index += 1;
      if (regions[i].length() == 0) {
        continue;
      }
      genes.add(gene);
    }
    return genes;
  }

  public static double log2(final double value) {
    return Math.log(value) / Math.log(2);
  }

  public static class Result {

    private final State[] states;
    private final double pathScore;

    public Result(final State[] states, final double pathScore) {
      this.states = states;
      this.pathScore = pathScore;
    }

    public State[] getStates() {
      return states;
    }

    public double getPathScore() {
      return pathScore;
    }

    public double getPathProbability() {
      return Math.pow(2, pathScore);
    }
  }
}
