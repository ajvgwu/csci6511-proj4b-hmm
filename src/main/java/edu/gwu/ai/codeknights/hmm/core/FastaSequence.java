package edu.gwu.ai.codeknights.hmm.core;

import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastaSequence {

  private final List<Nucleotide> nucleotides;

  public FastaSequence(final List<Nucleotide> nucleotides) {
    this.nucleotides = new ArrayList<>();
    this.nucleotides.addAll(nucleotides);
  }

  /**
   * build a fasta sequence directly from a string
   */
  public static FastaSequence build(String input) {
    final String trimmed = input.trim().toUpperCase();
    final List<Nucleotide> nucs = new ArrayList<>();
    final String[] lines = trimmed.split("\n");
    // Parse input file and create sequence
    Arrays.asList(lines).forEach(line -> {
      String trimmedLine = line.trim().toUpperCase();
      if (!(trimmedLine.startsWith("A") || trimmedLine.startsWith("C")
          || trimmedLine.startsWith("G") || trimmedLine.startsWith("T"))) {
        Logger.trace("skipping line: {}", line);
      } else {
        for (int i = 0; i < trimmedLine.length(); i++) {
          final Nucleotide n = Nucleotide.fromChar(trimmedLine.charAt(i));
          nucs.add(n);
        }
      }
    });

    return new FastaSequence(nucs);
  }

  public List<Nucleotide> getNucleotides() {
    return nucleotides;
  }

  @Override
  public String toString() {
    return String.valueOf(nucleotides);
  }
}
