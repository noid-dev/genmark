package dev.noid.genmark.model;

record Bold(String text) {

  @Override
  public String toString() {
    return "**" + text + "**";
  }
}
