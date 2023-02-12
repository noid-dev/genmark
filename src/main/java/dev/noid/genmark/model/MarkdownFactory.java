package dev.noid.genmark.model;

public class MarkdownFactory {

  private final String lineEnding;
  private final char themeSymbol;

  public MarkdownFactory(String lineEnding, char themeSymbol) {
    this.lineEnding = lineEnding;
    this.themeSymbol = themeSymbol;
  }

  public String bold(String text) {
    return new Bold(text).toString();
  }

  public String italic(String text) {
    return new Italic(text).toString();
  }

  public String heading(String text, int level) {
    return new Heading(text, level, lineEnding).toString();
  }

  public String paragraph(String text) {
    return new Paragraph(text, lineEnding).toString();
  }

  public String blockquote(String text) {
    return new Blockquote(text, lineEnding).toString();
  }

  public String inlineLink(String text, String url, String title) {
    return new InlineLink(text, url, title).toString();
  }

  public String unorderedList(Iterable<String> items) {
    return new UnorderedList(items, themeSymbol, lineEnding).toString();
  }

  public String lineBreak() {
    return new LineBreak(lineEnding).toString();
  }

  public String thematicBreak() {
    return new ThematicBreak(themeSymbol, lineEnding).toString();
  }
}
