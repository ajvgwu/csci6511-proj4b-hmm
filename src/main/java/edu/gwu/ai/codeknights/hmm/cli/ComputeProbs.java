package edu.gwu.ai.codeknights.hmm.cli;

import java.util.EnumSet;

import edu.gwu.ai.codeknights.hmm.core.HMM;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;
import edu.gwu.ai.codeknights.hmm.core.State;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
  name = ComputeProbs.CMD_NAME, sortOptions = false, showDefaultValues = true,
  description = "compute probabilities of next nucleotide following a given sequence")
public class ComputeProbs extends AbstractCmd {

  public static final String CMD_NAME = "compute-probs";

  @Parameters(paramLabel = "sequence", description = "sequence of two or more nucleotides")
  private String sequence = "AA";

  @Override
  protected void validateArgs() throws Exception {
    super.validateArgs();

    sequence = (sequence != null ? sequence : "").trim();
    if (sequence.length() < 2) {
      throw new IllegalArgumentException("sequence must have at least two nucleotides: " + sequence);
    }
  }

  protected String getSequence() {
    return sequence;
  }

  @Override
  public String getCmdName() {
    return CMD_NAME;
  }

  @Override
  public Void call() throws Exception {
    validateArgs();

    // Extract nucleotides
    final Nucleotide n1 = Nucleotide.fromChar(sequence.charAt(sequence.length() - 2));
    final Nucleotide n2 = Nucleotide.fromChar(sequence.charAt(sequence.length() - 1));

    // Compute probabilities
    System.out.println("For sequence ending with '..." + n1.toString() + n2.toString() + "':");
    final HMM hmm = new HMM(1.0, 1.0);
    for (final State state : EnumSet.allOf(State.class)) {
      for (final Nucleotide n3 : EnumSet.allOf(Nucleotide.class)) {
        final double prob = hmm.getProb(state, n1, n2, n3);
        System.out.println(
          "  > Prob(State=" + state.toString() + ", Nucleotide=" + n3.toString() + ") = " + String.valueOf(prob));
      }
    }

    // Done.
    return null;
  }
}
