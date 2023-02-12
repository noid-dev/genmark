package dev.noid.genmark.model;

record LineBreak(String lineSeparator) {

  @Override
  public String toString() {
    return lineSeparator;
  }
}
