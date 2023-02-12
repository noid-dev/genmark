package dev.noid.genmark.model;

record Italic(String text) {

  @Override
  public String toString() {
    return "*" + text + "*";
  }
}
