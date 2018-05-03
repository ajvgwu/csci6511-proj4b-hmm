package edu.gwu.ai.codeknights.hmm.core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhiyuan
 */
public class EmitProbTable {

  private final Map<Nucleotide, Map<Nucleotide, Map<Nucleotide, Integer>>> table;

  public EmitProbTable() {
    table = new LinkedHashMap<>();
  }

  /**
   * only the value will be put in
   *
   * the double probability will be calculated
   * */
  public double put(Nucleotide first, Nucleotide second, Nucleotide third, int value) {
    Map<Nucleotide, Map<Nucleotide, Integer>> level1 = table.computeIfAbsent(first, k -> new LinkedHashMap<>());
    Map<Nucleotide, Integer> level2 = level1.computeIfAbsent(second, k -> new LinkedHashMap<>());
    level2.put(third, value);
    return getProb(first, second, third);
  }

  public Map<Nucleotide, Map<Nucleotide, Integer>> getLevel1(Nucleotide first) {
    return table.get(first);
  }

  public Map<Nucleotide, Integer> getLevel2(Nucleotide first, Nucleotide second) {
    return getLevel1(first).get(second);
  }

  public int getValue(Nucleotide first, Nucleotide second, Nucleotide third){
    return getLevel2(first, second).get(third);
  }

  public Double getProb(Nucleotide first, Nucleotide second, Nucleotide third) {
    Map<Nucleotide, Integer> level2 = getLevel2(first, second);
    int sum = level2.values().stream().mapToInt(i -> i).sum();
    return (double) level2.get(third) / (double) sum;
  }

  public Map<Nucleotide, Map<Nucleotide, Map<Nucleotide, Integer>>> getLevel0() {
    return table;
  }
}
