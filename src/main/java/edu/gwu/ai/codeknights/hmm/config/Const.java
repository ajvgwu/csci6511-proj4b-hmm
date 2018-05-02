package edu.gwu.ai.codeknights.hmm.config;

import edu.gwu.ai.codeknights.hmm.core.EmitProbTable;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;

/**
 * @author zhiyuan
 */
public class Const {

  public static final EmitProbTable tableOne = new EmitProbTable();

  static {
    // n1 = A, n2=A
    tableOne.put(Nucleotide.A, Nucleotide.A, Nucleotide.A, 77.0 / (77.0 + 66.0 + 37.0 + 4.0));
    tableOne.put(Nucleotide.A, Nucleotide.A, Nucleotide.C, 66.0 / (77.0 + 66.0 + 37.0 + 4.0));
    tableOne.put(Nucleotide.A, Nucleotide.A, Nucleotide.G, 37.0 / (77.0 + 66.0 + 37.0 + 4.0));
    tableOne.put(Nucleotide.A, Nucleotide.A, Nucleotide.T, 4.0 / (77.0 + 66.0 + 37.0 + 4.0));

    // n1=A, n2=C
    tableOne.put(Nucleotide.A, Nucleotide.C, Nucleotide.A, 3.0 / (3.0 + 63.0 + 13.0 + 19.0));
    tableOne.put(Nucleotide.A, Nucleotide.C, Nucleotide.C, 63.0 / (3.0 + 63.0 + 13.0 + 19.0));
    tableOne.put(Nucleotide.A, Nucleotide.C, Nucleotide.G, 13.0 / (3.0 + 63.0 + 13.0 + 19.0));
    tableOne.put(Nucleotide.A, Nucleotide.C, Nucleotide.T, 19.0 / (3.0 + 63.0 + 13.0 + 19.0));

    // n1=A, n2=G
    tableOne.put(Nucleotide.A, Nucleotide.G, Nucleotide.A, 1.0 / (1.0 + 23.0 + 1.0 + 3.0));
    tableOne.put(Nucleotide.A, Nucleotide.G, Nucleotide.C, 23.0 / (1.0 + 23.0 + 1.0 + 3.0));
    tableOne.put(Nucleotide.A, Nucleotide.G, Nucleotide.G, 1.0 / (1.0 + 23.0 + 1.0 + 3.0));
    tableOne.put(Nucleotide.A, Nucleotide.G, Nucleotide.T, 3.0 / (1.0 + 23.0 + 1.0 + 3.0));

    // n1=A, n2=T
    tableOne.put(Nucleotide.A, Nucleotide.T, Nucleotide.A, 1.0 / (1.0 + 98.0 + 60.0 + 29.0));
    tableOne.put(Nucleotide.A, Nucleotide.T, Nucleotide.C, 98.0 / (1.0 + 98.0 + 60.0 + 29.0));
    tableOne.put(Nucleotide.A, Nucleotide.T, Nucleotide.G, 60.0 / (1.0 + 98.0 + 60.0 + 29.0));
    tableOne.put(Nucleotide.A, Nucleotide.T, Nucleotide.T, 29.0 / (1.0 + 98.0 + 60.0 + 29.0));

    // n1=C, n2=A
    tableOne.put(Nucleotide.C, Nucleotide.A, Nucleotide.A, 15.0 / (15.0 + 23.0 + 73.0 + 5.0));
    tableOne.put(Nucleotide.C, Nucleotide.A, Nucleotide.C, 23.0 / (15.0 + 23.0 + 73.0 + 5.0));
    tableOne.put(Nucleotide.C, Nucleotide.A, Nucleotide.G, 73.0 / (15.0 + 23.0 + 73.0 + 5.0));
    tableOne.put(Nucleotide.C, Nucleotide.A, Nucleotide.T, 5.0 / (15.0 + 23.0 + 73.0 + 5.0));

    // n1=C, n2=C
    tableOne.put(Nucleotide.C, Nucleotide.C, Nucleotide.A, 11.0 / (11.0 + 1.0 + 55.0 + 9.0));
    tableOne.put(Nucleotide.C, Nucleotide.C, Nucleotide.C, 1.0 / (11.0 + 1.0 + 55.0 + 9.0));
    tableOne.put(Nucleotide.C, Nucleotide.C, Nucleotide.G, 55.0 / (11.0 + 1.0 + 55.0 + 9.0));
    tableOne.put(Nucleotide.C, Nucleotide.C, Nucleotide.T, 9.0 / (11.0 + 1.0 + 55.0 + 9.0));

    // n1=C, n2=G
    tableOne.put(Nucleotide.C, Nucleotide.G, Nucleotide.A, 1.0 / (1.0 + 46.0 + 1.0 + 89.0));
    tableOne.put(Nucleotide.C, Nucleotide.G, Nucleotide.C, 46.0 / (1.0 + 46.0 + 1.0 + 89.0));
    tableOne.put(Nucleotide.C, Nucleotide.G, Nucleotide.G, 1.0 / (1.0 + 46.0 + 1.0 + 89.0));
    tableOne.put(Nucleotide.C, Nucleotide.G, Nucleotide.T, 89.0 / (1.0 + 46.0 + 1.0 + 89.0));

    // n1=C, n2=T
    tableOne.put(Nucleotide.C, Nucleotide.T, Nucleotide.A, 1.0 / (1.0 + 18.0 + 141.0 + 11.0));
    tableOne.put(Nucleotide.C, Nucleotide.T, Nucleotide.C, 18.0 / (1.0 + 18.0 + 141.0 + 11.0));
    tableOne.put(Nucleotide.C, Nucleotide.T, Nucleotide.G, 141.0 / (1.0 + 18.0 + 141.0 + 11.0));
    tableOne.put(Nucleotide.C, Nucleotide.T, Nucleotide.T, 11.0 / (1.0 + 18.0 + 141.0 + 11.0));

    // n1=G, n2=A
    tableOne.put(Nucleotide.G, Nucleotide.A, Nucleotide.A, 147.0 / (147.0 + 85.0 + 46.0 + 60.0));
    tableOne.put(Nucleotide.G, Nucleotide.A, Nucleotide.C, 85.0 / (147.0 + 85.0 + 46.0 + 60.0));
    tableOne.put(Nucleotide.G, Nucleotide.A, Nucleotide.G, 46.0 / (147.0 + 85.0 + 46.0 + 60.0));
    tableOne.put(Nucleotide.G, Nucleotide.A, Nucleotide.T, 60.0 / (147.0 + 85.0 + 46.0 + 60.0));

    // n1=G, n2=C
    tableOne.put(Nucleotide.G, Nucleotide.C, Nucleotide.A, 30.0 / (39.0 + 19.0 + 49.0 + 30.0));
    tableOne.put(Nucleotide.G, Nucleotide.C, Nucleotide.C, 19.0 / (39.0 + 19.0 + 49.0 + 30.0));
    tableOne.put(Nucleotide.G, Nucleotide.C, Nucleotide.G, 49.0 / (39.0 + 19.0 + 49.0 + 30.0));
    tableOne.put(Nucleotide.G, Nucleotide.C, Nucleotide.T, 30.0 / (39.0 + 19.0 + 49.0 + 30.0));

    // n1=G, n2=G
    tableOne.put(Nucleotide.G, Nucleotide.G, Nucleotide.A, 1.0 / (1.0 + 47.0 + 5.0 + 78.0));
    tableOne.put(Nucleotide.G, Nucleotide.G, Nucleotide.C, 47.0 / (1.0 + 47.0 + 5.0 + 78.0));
    tableOne.put(Nucleotide.G, Nucleotide.G, Nucleotide.G, 5.0 / (1.0 + 47.0 + 5.0 + 78.0));
    tableOne.put(Nucleotide.G, Nucleotide.G, Nucleotide.T, 78.0 / (1.0 + 47.0 + 5.0 + 78.0));

    // n1=G, n2=T
    tableOne.put(Nucleotide.G, Nucleotide.T, Nucleotide.A, 34.0 / (34.0 + 21.0 + 34.0 + 55.0));
    tableOne.put(Nucleotide.G, Nucleotide.T, Nucleotide.C, 21.0 / (34.0 + 21.0 + 34.0 + 55.0));
    tableOne.put(Nucleotide.G, Nucleotide.T, Nucleotide.G, 34.0 / (34.0 + 21.0 + 34.0 + 55.0));
    tableOne.put(Nucleotide.G, Nucleotide.T, Nucleotide.T, 55.0 / (34.0 + 21.0 + 34.0 + 55.0));

    // n1=T, n2=A
    tableOne.put(Nucleotide.T, Nucleotide.A, Nucleotide.A, 0.0 / (38.0 + 18.0));
    tableOne.put(Nucleotide.T, Nucleotide.A, Nucleotide.C, 38.0 / (38.0 + 18.0));
    tableOne.put(Nucleotide.T, Nucleotide.A, Nucleotide.G, 0.0 / (38.0 + 18.0));
    tableOne.put(Nucleotide.T, Nucleotide.A, Nucleotide.T, 18.0 / (38.0 + 18.0));

    // n1=T, n2=C
    tableOne.put(Nucleotide.T, Nucleotide.C, Nucleotide.A, 2.0 / (2.0 + 38.0 + 5.0 + 32.0));
    tableOne.put(Nucleotide.T, Nucleotide.C, Nucleotide.C, 38.0 / (2.0 + 38.0 + 5.0 + 32.0));
    tableOne.put(Nucleotide.T, Nucleotide.C, Nucleotide.G, 5.0 / (2.0 + 38.0 + 5.0 + 32.0));
    tableOne.put(Nucleotide.T, Nucleotide.C, Nucleotide.T, 32.0 / (2.0 + 38.0 + 5.0 + 32.0));

    // n1=T, n2=G
    tableOne.put(Nucleotide.T, Nucleotide.G, Nucleotide.A, 0.0 / (5.0 + 8.0 + 5.0));
    tableOne.put(Nucleotide.T, Nucleotide.G, Nucleotide.C, 5.0 / (5.0 + 8.0 + 5.0));
    tableOne.put(Nucleotide.T, Nucleotide.G, Nucleotide.G, 8.0 / (5.0 + 8.0 + 5.0));
    tableOne.put(Nucleotide.T, Nucleotide.G, Nucleotide.T, 5.0 / (5.0 + 8.0 + 5.0));

    // n1=T, n2=T
    tableOne.put(Nucleotide.T, Nucleotide.T, Nucleotide.A, 2.0 / (2.0 + 44.0 + 8.0 + 15.0));
    tableOne.put(Nucleotide.T, Nucleotide.T, Nucleotide.C, 44.0 / (2.0 + 44.0 + 8.0 + 15.0));
    tableOne.put(Nucleotide.T, Nucleotide.T, Nucleotide.G, 8.0 / (2.0 + 44.0 + 8.0 + 15.0));
    tableOne.put(Nucleotide.T, Nucleotide.T, Nucleotide.T, 15.0 / (2.0 + 44.0 + 8.0 + 15.0));
  }

}