package edu.gwu.ai.codeknights.hmm.core;

public enum State {

  NON_CODING("N"),
  CODING("G");

  private final String id;

  State(final String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return getId();
  }
}
