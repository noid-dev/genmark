package dev.noid.genmark;

import dev.noid.genmark.model.MarkdownFactory;
import java.util.LinkedList;
import java.util.function.Consumer;

public final class Markdown {

  public static Markdown standard() {
    Configuration config = new Configuration()
        .withBulletSymbol('-')
        .withLineEnding(System.lineSeparator());
    return custom(config);
  }

  public static Markdown custom(Configuration config) {
    MarkdownFactory factory = new MarkdownFactory(config.getLineEnding(), config.getBulletSymbol());
    return new Markdown(factory);
  }

  private final StringBuilder container = new StringBuilder();
  private final MarkdownFactory factory;

  private Markdown(MarkdownFactory factory) {
    this.factory = factory;
  }

  public Markdown text(String text) {
    container.append(text);
    return this;
  }

  public Markdown bold(String text) {
    container.append(factory.bold(text));
    return this;
  }

  public Markdown italic(String text) {
    container.append(factory.italic(text));
    return this;
  }

  public Markdown headingL1(String text) {
    container.append(factory.heading(text, 1));
    return this;
  }

  public Markdown headingL2(String text) {
    container.append(factory.heading(text, 2));
    return this;
  }

  public Markdown headingL3(String text) {
    container.append(factory.heading(text, 3));
    return this;
  }

  public Markdown paragraph(String text) {
    container.append(factory.paragraph(text));
    return this;
  }

  public Markdown blockquote(String text) {
    container.append(factory.blockquote(text));
    return this;
  }

  public Markdown link(String text, String url) {
    container.append(factory.inlineLink(text, url, ""));
    return this;
  }

  public Markdown lineBreak() {
    container.append(factory.lineBreak());
    return this;
  }

  public Markdown thematicBreak() {
    container.append(factory.thematicBreak());
    return this;
  }

  public UListBuilder unorderedList() {
    return new UListBuilder(this);
  }

  public static class UListBuilder {

    private final LinkedList<String> items = new LinkedList<>();
    private final Markdown original;

    private UListBuilder(Markdown original) {
      this.original = original;
    }

    public UListBuilder text(String text) {
      items.add(text);
      return this;
    }

    public UListBuilder link(String text, String url) {
      items.add(original.factory.inlineLink(text, url, ""));
      return this;
    }

    public Markdown end() {
      original.text(original.factory.unorderedList(items));
      return original;
    }

    @Override
    public String toString() {
      return end().toString();
    }
  }

  @Override
  public String toString() {
    return container.toString();
  }

  public void collect(Consumer<String> collector) {
    collector.accept(toString());
  }
}
