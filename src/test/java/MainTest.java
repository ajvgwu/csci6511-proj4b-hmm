import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.HMM;
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
}
