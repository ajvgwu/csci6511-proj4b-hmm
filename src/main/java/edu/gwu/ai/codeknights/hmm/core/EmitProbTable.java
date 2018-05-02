package edu.gwu.ai.codeknights.hmm.core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhiyuan
 */
public class EmitProbTable {

  private final Map<Nucleotide, Map<Nucleotide, Map<Nucleotide, Double>>> table;

  public EmitProbTable() {
    table = new LinkedHashMap<>();
  }

  public void put(Nucleotide first, Nucleotide second, Nucleotide third, double prob) {
    Map<Nucleotide, Map<Nucleotide, Double>> level1 = table.computeIfAbsent(first, k -> new LinkedHashMap<>());
    Map<Nucleotide, Double> level2 = level1.computeIfAbsent(second, k -> new LinkedHashMap<>());
    level2.put(third, prob);
  }

  public Map<Nucleotide, Map<Nucleotide, Double>> getLevel1(Nucleotide first){
    return table.get(first);
  }

  public Map<Nucleotide, Double> getLevel2(Nucleotide first, Nucleotide second){
    return getLevel1(first).get(second);
  }

  public Double getProb(Nucleotide first, Nucleotide second, Nucleotide third){
    return getLevel2(first, second).get(third);
  }

  public Map<Nucleotide, Map<Nucleotide, Map<Nucleotide, Double>>> getLevel0() {
    return table;
  }
}
