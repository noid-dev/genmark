package dev.noid.genmark.model;

record ThematicBreak(char themeSymbol, String lineEnding) {

  @Override
  public String toString() {
    return String.valueOf(themeSymbol).repeat(3) + lineEnding;
  }
}
