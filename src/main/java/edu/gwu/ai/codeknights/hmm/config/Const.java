package edu.gwu.ai.codeknights.hmm.config;

import edu.gwu.ai.codeknights.hmm.core.EmitProbTable;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;

/**
 * @author zhiyuan
 */
public class Const {

  public static final EmitProbTable TABLE_ONE = new EmitProbTable();

  static {
    // n1 = A, n2=A
    TABLE_ONE.put(Nucleotide.A, Nucleotide.A, Nucleotide.A, 77);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.A, Nucleotide.C, 66);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.A, Nucleotide.G, 37);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.A, Nucleotide.T, 4);

    // n1=A, n2=C
    TABLE_ONE.put(Nucleotide.A, Nucleotide.C, Nucleotide.A, 3);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.C, Nucleotide.C, 63);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.C, Nucleotide.G, 13);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.C, Nucleotide.T, 19);

    // n1=A, n2=G
    TABLE_ONE.put(Nucleotide.A, Nucleotide.G, Nucleotide.A, 1);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.G, Nucleotide.C, 23);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.G, Nucleotide.G, 1);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.G, Nucleotide.T, 3);

    // n1=A, n2=T
    TABLE_ONE.put(Nucleotide.A, Nucleotide.T, Nucleotide.A, 1);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.T, Nucleotide.C, 98);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.T, Nucleotide.G, 60);
    TABLE_ONE.put(Nucleotide.A, Nucleotide.T, Nucleotide.T, 29);

    // n1=C, n2=A
    TABLE_ONE.put(Nucleotide.C, Nucleotide.A, Nucleotide.A, 15);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.A, Nucleotide.C, 23);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.A, Nucleotide.G, 73);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.A, Nucleotide.T, 5);

    // n1=C, n2=C
    TABLE_ONE.put(Nucleotide.C, Nucleotide.C, Nucleotide.A, 11);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.C, Nucleotide.C, 1);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.C, Nucleotide.G, 55);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.C, Nucleotide.T, 9);

    // n1=C, n2=G
    TABLE_ONE.put(Nucleotide.C, Nucleotide.G, Nucleotide.A, 1);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.G, Nucleotide.C, 46);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.G, Nucleotide.G, 1);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.G, Nucleotide.T, 89);

    // n1=C, n2=T
    TABLE_ONE.put(Nucleotide.C, Nucleotide.T, Nucleotide.A, 1);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.T, Nucleotide.C, 18);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.T, Nucleotide.G, 141);
    TABLE_ONE.put(Nucleotide.C, Nucleotide.T, Nucleotide.T, 11);

    // n1=G, n2=A
    TABLE_ONE.put(Nucleotide.G, Nucleotide.A, Nucleotide.A, 147);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.A, Nucleotide.C, 85);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.A, Nucleotide.G, 46);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.A, Nucleotide.T, 60);

    // n1=G, n2=C
    TABLE_ONE.put(Nucleotide.G, Nucleotide.C, Nucleotide.A, 30);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.C, Nucleotide.C, 19);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.C, Nucleotide.G, 49);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.C, Nucleotide.T, 30);

    // n1=G, n2=G
    TABLE_ONE.put(Nucleotide.G, Nucleotide.G, Nucleotide.A, 1);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.G, Nucleotide.C, 47);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.G, Nucleotide.G, 5);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.G, Nucleotide.T, 78);

    // n1=G, n2=T
    TABLE_ONE.put(Nucleotide.G, Nucleotide.T, Nucleotide.A, 34);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.T, Nucleotide.C, 21);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.T, Nucleotide.G, 34);
    TABLE_ONE.put(Nucleotide.G, Nucleotide.T, Nucleotide.T, 55);

    // n1=T, n2=A
    TABLE_ONE.put(Nucleotide.T, Nucleotide.A, Nucleotide.A, 0);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.A, Nucleotide.C, 38);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.A, Nucleotide.G, 0);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.A, Nucleotide.T, 18);

    // n1=T, n2=C
    TABLE_ONE.put(Nucleotide.T, Nucleotide.C, Nucleotide.A, 2);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.C, Nucleotide.C, 38);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.C, Nucleotide.G, 5);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.C, Nucleotide.T, 32);

    // n1=T, n2=G
    TABLE_ONE.put(Nucleotide.T, Nucleotide.G, Nucleotide.A, 0);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.G, Nucleotide.C, 5);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.G, Nucleotide.G, 8);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.G, Nucleotide.T, 5);

    // n1=T, n2=T
    TABLE_ONE.put(Nucleotide.T, Nucleotide.T, Nucleotide.A, 2);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.T, Nucleotide.C, 44);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.T, Nucleotide.G, 8);
    TABLE_ONE.put(Nucleotide.T, Nucleotide.T, Nucleotide.T, 15);
  }

}
