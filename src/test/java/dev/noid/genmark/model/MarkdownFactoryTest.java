package dev.noid.genmark.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class MarkdownFactoryTest {

  private final MarkdownFactory factory = new MarkdownFactory("\n", '*');

  @Test
  void bold() {
    String md = factory.bold("Escape the ordinary.");
    assertEquals("**Escape the ordinary.**", md);
  }

  @Test
  void italic() {
    String md = factory.italic("Make it happen.");
    assertEquals("*Make it happen.*", md);
  }

  @Test
  void heading() {
    String h1 = factory.heading("Celebrate every tiny victory.", 1);
    assertEquals("\n# Celebrate every tiny victory.\n", h1);

    String h2 = factory.heading("Celebrate every tiny victory.", 2);
    assertEquals("\n## Celebrate every tiny victory.\n", h2);

    String h3 = factory.heading("Celebrate every tiny victory.", 3);
    assertEquals("\n### Celebrate every tiny victory.\n", h3);
  }

  @Test
  void paragraph() {
    String md = factory.paragraph("Good things take time.");
    assertEquals("Good things take time.\n", md);
  }

  @Test
  void blockquote() {
    String md = factory.blockquote("One day at a time.");
    assertEquals("> One day at a time.", md);
  }

  @Test
  void inlineLink() {
    String titless = factory.inlineLink("Positive Short Quotes", "https://shihoriobata.com", "");
    assertEquals("[Positive Short Quotes](https://shihoriobata.com)", titless);

    String titled = factory.inlineLink("Positive Short Quotes", "https://shihoriobata.com", "by Shihori");
    assertEquals("[Positive Short Quotes](https://shihoriobata.com \"by Shihori\")", titled);
  }

  @Test
  void unorderedList() {
    String md = factory.unorderedList(List.of("Be good.", "Do good."));
    assertEquals("* Be good.\n* Do good.\n", md);
  }

  @Test
  void lineBreak() {
    assertEquals("  \n", factory.lineBreak());
  }

  @Test
  void thematicBreak() {
    assertEquals("***", factory.thematicBreak());
  }
}