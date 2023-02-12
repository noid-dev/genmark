package dev.noid.genmark.model;

record Heading(String header, int level, String lineSeparator) {

  @Override
  public String toString() {
    return lineSeparator + "#".repeat(level) + " " + header + lineSeparator + lineSeparator;
  }
}
