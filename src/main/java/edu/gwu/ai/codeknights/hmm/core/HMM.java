package edu.gwu.ai.codeknights.hmm.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HMM {

  public static final Map<Nucleotide, Map<Nucleotide, Map<Nucleotide, Double>>> PROBABILITY_TABLE;

  static {
    PROBABILITY_TABLE = new LinkedHashMap<>();

    // n1=A
    final Map<Nucleotide, Map<Nucleotide, Double>> map_a = new LinkedHashMap<>();
    PROBABILITY_TABLE.put(Nucleotide.A, map_a);

    // n1=A, n2=A
    final Map<Nucleotide, Double> map_a_a = new LinkedHashMap<>();
    map_a.put(Nucleotide.A, map_a_a);
    map_a_a.put(Nucleotide.A, 77.0 / (77.0 + 66.0 + 37.0 + 4.0));
    map_a_a.put(Nucleotide.C, 66.0 / (77.0 + 66.0 + 37.0 + 4.0));
    map_a_a.put(Nucleotide.G, 37.0 / (77.0 + 66.0 + 37.0 + 4.0));
    map_a_a.put(Nucleotide.T, 4.0 / (77.0 + 66.0 + 37.0 + 4.0));

    // n1=A, n2=C
    final Map<Nucleotide, Double> map_a_c = new LinkedHashMap<>();
    map_a.put(Nucleotide.C, map_a_c);
    map_a_c.put(Nucleotide.A, 3.0 / (3.0 + 63.0 + 13.0 + 19.0));
    map_a_c.put(Nucleotide.C, 63.0 / (3.0 + 63.0 + 13.0 + 19.0));
    map_a_c.put(Nucleotide.G, 13.0 / (3.0 + 63.0 + 13.0 + 19.0));
    map_a_c.put(Nucleotide.T, 19.0 / (3.0 + 63.0 + 13.0 + 19.0));

    // n1=A, n2=G
    final Map<Nucleotide, Double> map_a_g = new LinkedHashMap<>();
    map_a.put(Nucleotide.G, map_a_g);
    map_a_g.put(Nucleotide.A, 1.0 / (1.0 + 23.0 + 1.0 + 3.0));
    map_a_g.put(Nucleotide.C, 23.0 / (1.0 + 23.0 + 1.0 + 3.0));
    map_a_g.put(Nucleotide.G, 1.0 / (1.0 + 23.0 + 1.0 + 3.0));
    map_a_g.put(Nucleotide.T, 3.0 / (1.0 + 23.0 + 1.0 + 3.0));

    // n1=A, n2=T
    final Map<Nucleotide, Double> map_a_t = new LinkedHashMap<>();
    map_a.put(Nucleotide.T, map_a_t);
    map_a_t.put(Nucleotide.A, 1.0 / (1.0 + 98.0 + 60.0 + 29.0));
    map_a_t.put(Nucleotide.C, 98.0 / (1.0 + 98.0 + 60.0 + 29.0));
    map_a_t.put(Nucleotide.G, 60.0 / (1.0 + 98.0 + 60.0 + 29.0));
    map_a_t.put(Nucleotide.T, 29.0 / (1.0 + 98.0 + 60.0 + 29.0));

    // n1=C
    final Map<Nucleotide, Map<Nucleotide, Double>> map_c = new LinkedHashMap<>();
    PROBABILITY_TABLE.put(Nucleotide.C, map_c);

    // n1=C, n2=A
    final Map<Nucleotide, Double> map_c_a = new LinkedHashMap<>();
    map_c.put(Nucleotide.A, map_c_a);
    map_c_a.put(Nucleotide.A, 15.0 / (15.0 + 23.0 + 73.0 + 5.0));
    map_c_a.put(Nucleotide.C, 23.0 / (15.0 + 23.0 + 73.0 + 5.0));
    map_c_a.put(Nucleotide.G, 73.0 / (15.0 + 23.0 + 73.0 + 5.0));
    map_c_a.put(Nucleotide.T, 5.0 / (15.0 + 23.0 + 73.0 + 5.0));

    // n1=C, n2=C
    final Map<Nucleotide, Double> map_c_c = new LinkedHashMap<>();
    map_c.put(Nucleotide.C, map_c_c);
    map_c_c.put(Nucleotide.A, 11.0 / (11.0 + 1.0 + 55.0 + 9.0));
    map_c_c.put(Nucleotide.C, 1.0 / (11.0 + 1.0 + 55.0 + 9.0));
    map_c_c.put(Nucleotide.G, 55.0 / (11.0 + 1.0 + 55.0 + 9.0));
    map_c_c.put(Nucleotide.T, 9.0 / (11.0 + 1.0 + 55.0 + 9.0));

    // n1=C, n2=G
    final Map<Nucleotide, Double> map_c_g = new LinkedHashMap<>();
    map_c.put(Nucleotide.G, map_c_g);
    map_c_g.put(Nucleotide.A, 1.0 / (1.0 + 46.0 + 1.0 + 89.0));
    map_c_g.put(Nucleotide.C, 46.0 / (1.0 + 46.0 + 1.0 + 89.0));
    map_c_g.put(Nucleotide.G, 1.0 / (1.0 + 46.0 + 1.0 + 89.0));
    map_c_g.put(Nucleotide.T, 89.0 / (1.0 + 46.0 + 1.0 + 89.0));

    // n1=C, n2=T
    final Map<Nucleotide, Double> map_c_t = new LinkedHashMap<>();
    map_c.put(Nucleotide.T, map_c_t);
    map_c_t.put(Nucleotide.A, 1.0 / (1.0 + 18.0 + 141.0 + 11.0));
    map_c_t.put(Nucleotide.C, 18.0 / (1.0 + 18.0 + 141.0 + 11.0));
    map_c_t.put(Nucleotide.G, 141.0 / (1.0 + 18.0 + 141.0 + 11.0));
    map_c_t.put(Nucleotide.T, 11.0 / (1.0 + 18.0 + 141.0 + 11.0));

    // n1=G
    final Map<Nucleotide, Map<Nucleotide, Double>> map_g = new LinkedHashMap<>();
    PROBABILITY_TABLE.put(Nucleotide.G, map_g);

    // n1=G, n2=A
    final Map<Nucleotide, Double> map_g_a = new LinkedHashMap<>();
    map_g.put(Nucleotide.A, map_g_a);
    map_g_a.put(Nucleotide.A, 147.0 / (147.0 + 85.0 + 46.0 + 60.0));
    map_g_a.put(Nucleotide.C, 85.0 / (147.0 + 85.0 + 46.0 + 60.0));
    map_g_a.put(Nucleotide.G, 46.0 / (147.0 + 85.0 + 46.0 + 60.0));
    map_g_a.put(Nucleotide.T, 60.0 / (147.0 + 85.0 + 46.0 + 60.0));

    // n1=G, n2=C
    final Map<Nucleotide, Double> map_g_c = new LinkedHashMap<>();
    map_g.put(Nucleotide.C, map_g_c);
    map_g_c.put(Nucleotide.A, 30.0 / (39.0 + 19.0 + 49.0 + 30.0));
    map_g_c.put(Nucleotide.C, 19.0 / (39.0 + 19.0 + 49.0 + 30.0));
    map_g_c.put(Nucleotide.G, 49.0 / (39.0 + 19.0 + 49.0 + 30.0));
    map_g_c.put(Nucleotide.T, 30.0 / (39.0 + 19.0 + 49.0 + 30.0));

    // n1=G, n2=G
    final Map<Nucleotide, Double> map_g_g = new LinkedHashMap<>();
    map_g.put(Nucleotide.G, map_g_g);
    map_g_g.put(Nucleotide.A, 1.0 / (1.0 + 47.0 + 5.0 + 78.0));
    map_g_g.put(Nucleotide.C, 47.0 / (1.0 + 47.0 + 5.0 + 78.0));
    map_g_g.put(Nucleotide.G, 5.0 / (1.0 + 47.0 + 5.0 + 78.0));
    map_g_g.put(Nucleotide.T, 78.0 / (1.0 + 47.0 + 5.0 + 78.0));

    // n1=G, n2=T
    final Map<Nucleotide, Double> map_g_t = new LinkedHashMap<>();
    map_g.put(Nucleotide.T, map_g_t);
    map_g_t.put(Nucleotide.A, 34.0 / (34.0 + 21.0 + 34.0 + 55.0));
    map_g_t.put(Nucleotide.C, 21.0 / (34.0 + 21.0 + 34.0 + 55.0));
    map_g_t.put(Nucleotide.G, 34.0 / (34.0 + 21.0 + 34.0 + 55.0));
    map_g_t.put(Nucleotide.T, 55.0 / (34.0 + 21.0 + 34.0 + 55.0));

    // n1=T
    final Map<Nucleotide, Map<Nucleotide, Double>> map_t = new LinkedHashMap<>();
    PROBABILITY_TABLE.put(Nucleotide.T, map_t);

    // n1=T, n2=A
    final Map<Nucleotide, Double> map_t_a = new LinkedHashMap<>();
    map_t.put(Nucleotide.A, map_t_a);
    map_t_a.put(Nucleotide.A, 0.0 / (38.0 + 18.0));
    map_t_a.put(Nucleotide.C, 38.0 / (38.0 + 18.0));
    map_t_a.put(Nucleotide.G, 0.0 / (38.0 + 18.0));
    map_t_a.put(Nucleotide.T, 18.0 / (38.0 + 18.0));

    // n1=T, n2=C
    final Map<Nucleotide, Double> map_t_c = new LinkedHashMap<>();
    map_t.put(Nucleotide.C, map_t_c);
    map_t_c.put(Nucleotide.A, 2.0 / (2.0 + 38.0 + 5.0 + 32.0));
    map_t_c.put(Nucleotide.C, 38.0 / (2.0 + 38.0 + 5.0 + 32.0));
    map_t_c.put(Nucleotide.G, 5.0 / (2.0 + 38.0 + 5.0 + 32.0));
    map_t_c.put(Nucleotide.T, 32.0 / (2.0 + 38.0 + 5.0 + 32.0));

    // n1=T, n2=G
    final Map<Nucleotide, Double> map_t_g = new LinkedHashMap<>();
    map_t.put(Nucleotide.G, map_t_g);
    map_t_g.put(Nucleotide.A, 0.0 / (5.0 + 8.0 + 5.0));
    map_t_g.put(Nucleotide.C, 5.0 / (5.0 + 8.0 + 5.0));
    map_t_g.put(Nucleotide.G, 8.0 / (5.0 + 8.0 + 5.0));
    map_t_g.put(Nucleotide.T, 5.0 / (5.0 + 8.0 + 5.0));

    // n1=T, n2=T
    final Map<Nucleotide, Double> map_t_t = new LinkedHashMap<>();
    map_t.put(Nucleotide.T, map_t_t);
    map_t_t.put(Nucleotide.A, 2.0 / (2.0 + 44.0 + 8.0 + 15.0));
    map_t_t.put(Nucleotide.C, 44.0 / (2.0 + 44.0 + 8.0 + 15.0));
    map_t_t.put(Nucleotide.G, 8.0 / (2.0 + 44.0 + 8.0 + 15.0));
    map_t_t.put(Nucleotide.T, 15.0 / (2.0 + 44.0 + 8.0 + 15.0));
  }

  private final double pnn;
  private final double pgg;

  public HMM(final double pnn, final double pgg) {
    this.pnn = pnn;
    this.pgg = pgg;
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
    return PROBABILITY_TABLE.get(n1).get(n2).get(n3);
  }

  public double getProb(final State s, final Nucleotide n1, final Nucleotide n2, final Nucleotide n3) {
    if (State.NON_CODING.equals(s)) {
      return getProbN(n1, n2, n3);
    }
    else {
      return getProbG(n1, n2, n3);
    }
  }

  public List<State> evaluate(final FastaSequence seq) {
    final List<State> states = new ArrayList<>();

    // Always start in non-coding state for first two nucleotides
    State prevState = State.NON_CODING;
    states.add(prevState);
    states.add(prevState);
    for (int i = 2; i < seq.length(); i++) {
      final Nucleotide n1 = seq.get(i - 2);
      final Nucleotide n2 = seq.get(i - 1);
      final Nucleotide n3 = seq.get(i);
      final State curState = null;
      //TODO: finish
      states.add(curState);
      prevState = curState;
    }

    // Return result
    return states;
  }
}
