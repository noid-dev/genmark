package dev.noid.genmark;

public class Configuration {

  private String lineEnding;
  private char bulletSymbol;

  public char getBulletSymbol() {
    return bulletSymbol;
  }

  public Configuration withBulletSymbol(char bulletSymbol) {
    this.bulletSymbol = bulletSymbol;
    return this;
  }

  public String getLineEnding() {
    return lineEnding;
  }

  public Configuration withLineEnding(String lineEnding) {
    this.lineEnding = lineEnding;
    return this;
  }
}
