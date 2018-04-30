package edu.gwu.ai.codeknights.hmm.core;

public enum Nucleotide {

  A,
  C,
  T,
  G;

  public static Nucleotide fromChar(final char value) {
    switch (value) {
      case 'a':
      case 'A':
        return A;
      case 'c':
      case 'C':
        return C;
      case 't':
      case 'T':
        return T;
      case 'g':
      case 'G':
        return G;
      default:
        throw new IllegalArgumentException("invalid nucleotide: " + value);
    }
  }
}
