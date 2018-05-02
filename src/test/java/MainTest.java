import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.HMM;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;
import edu.gwu.ai.codeknights.hmm.core.State;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author zhiyuan
 */
public class MainTest {

  private final static String filePath = "target/classes/1000_5000.txt";
  private static String input;

  static {
    try {
      input = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      input = "";
      e.printStackTrace();
    }
  }

  @Test
  public void print() {
    FastaSequence seq = FastaSequence.build(input);
    System.out.println(seq.toString());
  }

  @Test
  public void find() {
    FastaSequence seq = FastaSequence.build(input);
    double pnn = 0.9;
    double pgg = 0.9;
    HMM hmm = new HMM(pnn, pgg);
    final List<State> states = hmm.evaluate(seq);
    System.out.println(String.valueOf(states));
  }

  @Test
  public void computeProb(){
    final String sequence = "AA";
    // Extract nucleotides
    final Nucleotide n1 = Nucleotide.fromChar(sequence.charAt(sequence.length() - 2));
    final Nucleotide n2 = Nucleotide.fromChar(sequence.charAt(sequence.length() - 1));

    double pnn = 1.0;
    double pgg = 1.0;

    // Compute probabilities
    System.out.println("For sequence ending with '..." + n1.toString() + n2.toString() + "':");
    final HMM hmm = new HMM(pnn, pgg);
    for (final State state : State.values()) {
      for (final Nucleotide n3 : Nucleotide.values()) {
        final double prob = hmm.getProb(state, n1, n2, n3);
        System.out.println(
            "  > Prob(State=" + state.toString() + ", Nucleotide=" + n3.toString() + ") = " + String.valueOf(prob));
      }
    }
  }
}
