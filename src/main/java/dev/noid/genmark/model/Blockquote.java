package dev.noid.genmark.model;

record Blockquote(String text, String lineEnding) {

  @Override
  public String toString() {
    return "> " + text;
  }
}
