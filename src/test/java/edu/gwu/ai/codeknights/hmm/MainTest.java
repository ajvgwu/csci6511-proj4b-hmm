package edu.gwu.ai.codeknights.hmm;

import edu.gwu.ai.codeknights.hmm.cli.FindGenes;
import edu.gwu.ai.codeknights.hmm.config.Const;
import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.HMM;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;
import edu.gwu.ai.codeknights.hmm.core.State;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/**
 * @author zhiyuan
 */
public class MainTest {

  private final static String filePath = "target/classes/1_39675.txt";
  private static String input;

  static {
    try {
      input = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (final IOException e) {
      input = "";
      e.printStackTrace();
    }
  }

  @Test
  public void print() {
    final FastaSequence seq = FastaSequence.build(input);
    System.out.println(seq.toPrimString());
  }

  @Test
  public void find() {
    final FastaSequence seq = FastaSequence.build(input);
    final HMM hmm = new HMM(Const.DEFAULT_PROB_N_N, Const.DEFAULT_PROB_G_G, Const.DEFAULT_EMIT_PROB_TABLE);
    HMM.Result result = hmm.evaluate(seq);
    State[] states = result.getStates();
    final StringBuilder stateStr = new StringBuilder();
    for (State state : states) {
      stateStr.append(state);
    }
    List<FindGenes.Gene> genes = hmm.extractGenes(stateStr.toString());
    // Print result
    System.out.println(" Genes=" + seq.toPrimString());
    System.out.println("states=" + stateStr.toString());
    for (final FindGenes.Gene gene : genes) {
      System.out.println("  > gene at idx=" + String.valueOf(gene.getStartIdx()) + ", length="
          + String.valueOf(gene.getLength()) + ": " + String.valueOf(gene.getNucleotides(seq)));
    }
  }

  @Test
  public void computeProb() {
    final String sequence = FastaSequence.build(input).toPrimString();
    // Extract nucleotides
    final Nucleotide n1 = Nucleotide.fromChar(sequence.charAt(sequence.length() - 2));
    final Nucleotide n2 = Nucleotide.fromChar(sequence.charAt(sequence.length() - 1));

    // Compute probabilities
    System.out.println("For sequence ending with '..." + n1.toString() + n2.toString() + "':");
    final HMM hmm = new HMM(Const.DEFAULT_PROB_N_N, Const.DEFAULT_PROB_G_G, Const.DEFAULT_EMIT_PROB_TABLE);
    for (final State state : EnumSet.allOf(State.class)) {
      for (final Nucleotide n3 : EnumSet.allOf(Nucleotide.class)) {
        final double prob = hmm.getProb(state, n1, n2, n3);
        System.out.println(
            "  > Prob(State=" + state.toString() + ", Nucleotide=" + n3.toString() + ") = " + String.valueOf(prob));
      }
    }
  }

  @Test
  public void findMLE() {
    final FastaSequence sequence = FastaSequence.build(input);

    // Find most likely explanation of states
    final HMM hmm = new HMM(Const.DEFAULT_PROB_N_N, Const.DEFAULT_PROB_G_G, Const.DEFAULT_EMIT_PROB_TABLE);
    final HMM.Result result = hmm.evaluate(sequence);
    final State[] states = result.getStates();

    // Print result
    System.out.println(String.valueOf(Arrays.asList(states)));
  }
}
