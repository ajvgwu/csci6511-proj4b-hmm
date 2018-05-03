package edu.gwu.ai.codeknights.hmm.core;

import edu.gwu.ai.codeknights.hmm.cli.FindGenes;
import edu.gwu.ai.codeknights.hmm.config.Const;

import java.util.ArrayList;
import java.util.List;

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
  public State[] evaluate(final FastaSequence seq) {
    // Assume 'AA' is prepended to input sequence
    Nucleotide n1 = null;
    Nucleotide n2 = Nucleotide.A;
    Nucleotide n3 = Nucleotide.A;

    // Always start in non-coding state
    final int length = seq.length();
    final double[][] probabilities = new double[2][length];

    // Compute probabilities for all possible paths using Viterbi algorithm
    for (int i = 0; i < length; i++) {
      n1 = n2;
      n2 = n3;
      n3 = seq.get(i);

      // Determine probabilities for current state based on previous most likely state
      final double prevProbN = i > 0 ? probabilities[State.NON_CODING.ordinal()][i - 1] : 1.0;
      final double prevProbG = i > 0 ? probabilities[State.CODING.ordinal()][i - 1] : 0.0;
      final State prevState = prevProbN > prevProbG ? State.NON_CODING : State.CODING;
      final double prevProb = Math.max(prevProbN, prevProbG);
      final double emissionProbN = getProbN(n1, n2, n3);
      final double emissionProbG = getProbG(n1, n2, n3);

      // Compute probability for NON_CODING state
      double probN = emissionProbN * prevProb; // TODO: what if prob approaches 0 ??? how to normalize?
      if (State.NON_CODING.equals(prevState)) {
        probN *= getProbNN();
      }
      else {
        probN *= getProbGN();
      }
      probabilities[State.NON_CODING.ordinal()][i] = probN;

      // Compute probability for CODING state
      double probG = emissionProbG * prevProb; // TODO: what if prob approaches 0 ??? how to normalize?
      if (State.CODING.equals(prevState)) {
        probG *= getProbGG();
      }
      else {
        probG *= getProbNG();
      }
      probabilities[State.CODING.ordinal()][i] = probG;
    }

    // Return most likely explanation (sequence of states)
    final State[] mle = new State[length];
    for (int i = 0; i < length; i++) {
      final double probN = probabilities[State.NON_CODING.ordinal()][i];
      final double probG = probabilities[State.CODING.ordinal()][i];
      mle[i] = probN > probG ? State.NON_CODING : State.CODING;
    }
    return mle;
  }

  public List<FindGenes.Gene> extractGenes(final String stateStr){
    String[] regions = stateStr.split(State.NON_CODING.getId());

    // Find protein-coding genes
    final List<FindGenes.Gene> genes = new ArrayList<>();
    for (int i = 0, index = 0; i < regions.length; i++) {
      final FindGenes.Gene gene = new FindGenes.Gene(index, index += regions[i].length());
      index += 1;
      if(regions[i].length() == 0){
        continue;
      }
      genes.add(gene);
    }
    return genes;
  }
}
