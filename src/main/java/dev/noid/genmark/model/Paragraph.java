package dev.noid.genmark.model;

record Paragraph(String text, String lineSeparator) {

  @Override
  public String toString() {
    return text + lineSeparator;
  }
}
