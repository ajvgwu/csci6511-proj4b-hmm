package edu.gwu.ai.codeknights.hmm.core;

import java.util.ArrayList;
import java.util.List;

public class FastaSequence {

  private final List<Nucleotide> nucleotides;

  public FastaSequence(final List<Nucleotide> nucleotides) {
    this.nucleotides = new ArrayList<>();
    this.nucleotides.addAll(nucleotides);
  }

  public List<Nucleotide> getNucleotides() {
    return nucleotides;
  }

  @Override
  public String toString() {
    return String.valueOf(nucleotides);
  }
}
