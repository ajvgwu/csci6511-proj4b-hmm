package edu.gwu.ai.codeknights.hmm.config;

import edu.gwu.ai.codeknights.hmm.core.EmitProbTable;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;

/**
 * @author zhiyuan
 */
public class Const {

  public static final double DEFAULT_PROB_G_G = 0.9;
  public static final double DEFAULT_PROB_N_N = 0.9;

  public static final EmitProbTable DEFAULT_EMIT_PROB_TABLE = new EmitProbTable();

  static {
    // n1 = A, n2=A
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.A, Nucleotide.A, 77);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.A, Nucleotide.C, 66);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.A, Nucleotide.G, 37);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.A, Nucleotide.T, 4);

    // n1=A, n2=C
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.C, Nucleotide.A, 3);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.C, Nucleotide.C, 63);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.C, Nucleotide.G, 13);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.C, Nucleotide.T, 19);

    // n1=A, n2=G
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.G, Nucleotide.A, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.G, Nucleotide.C, 23);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.G, Nucleotide.G, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.G, Nucleotide.T, 3);

    // n1=A, n2=T
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.T, Nucleotide.A, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.T, Nucleotide.C, 98);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.T, Nucleotide.G, 60);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.A, Nucleotide.T, Nucleotide.T, 29);

    // n1=C, n2=A
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.A, Nucleotide.A, 15);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.A, Nucleotide.C, 23);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.A, Nucleotide.G, 73);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.A, Nucleotide.T, 5);

    // n1=C, n2=C
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.C, Nucleotide.A, 11);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.C, Nucleotide.C, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.C, Nucleotide.G, 55);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.C, Nucleotide.T, 9);

    // n1=C, n2=G
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.G, Nucleotide.A, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.G, Nucleotide.C, 46);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.G, Nucleotide.G, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.G, Nucleotide.T, 89);

    // n1=C, n2=T
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.T, Nucleotide.A, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.T, Nucleotide.C, 18);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.T, Nucleotide.G, 141);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.C, Nucleotide.T, Nucleotide.T, 11);

    // n1=G, n2=A
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.A, Nucleotide.A, 147);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.A, Nucleotide.C, 85);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.A, Nucleotide.G, 46);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.A, Nucleotide.T, 60);

    // n1=G, n2=C
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.C, Nucleotide.A, 30);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.C, Nucleotide.C, 19);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.C, Nucleotide.G, 49);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.C, Nucleotide.T, 30);

    // n1=G, n2=G
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.G, Nucleotide.A, 1);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.G, Nucleotide.C, 47);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.G, Nucleotide.G, 5);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.G, Nucleotide.T, 78);

    // n1=G, n2=T
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.T, Nucleotide.A, 34);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.T, Nucleotide.C, 21);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.T, Nucleotide.G, 34);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.G, Nucleotide.T, Nucleotide.T, 55);

    // n1=T, n2=A
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.A, Nucleotide.A, 0);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.A, Nucleotide.C, 38);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.A, Nucleotide.G, 0);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.A, Nucleotide.T, 18);

    // n1=T, n2=C
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.C, Nucleotide.A, 2);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.C, Nucleotide.C, 38);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.C, Nucleotide.G, 5);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.C, Nucleotide.T, 32);

    // n1=T, n2=G
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.G, Nucleotide.A, 0);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.G, Nucleotide.C, 5);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.G, Nucleotide.G, 8);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.G, Nucleotide.T, 5);

    // n1=T, n2=T
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.T, Nucleotide.A, 2);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.T, Nucleotide.C, 44);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.T, Nucleotide.G, 8);
    DEFAULT_EMIT_PROB_TABLE.put(Nucleotide.T, Nucleotide.T, Nucleotide.T, 15);
  }
}
