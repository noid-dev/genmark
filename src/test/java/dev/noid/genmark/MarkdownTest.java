package dev.noid.genmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class MarkdownTest {

  @Test
  void complex() {
    Configuration config = new Configuration()
        .withBulletSymbol('-')
        .withLineEnding("\r\n");

    String generated = Markdown.custom(config)
        .thematicBreak()
        .text("""
            title: 'Sample Blog Post'\r
            pubDate: 2023-02-11\r
            description: 'This is a sample post.'\r
            author: 'Peggy Motte'\r
            url: 'https://my.blog/cover.jpeg'\r
            tags: ["blogging"]\r
            """)
        .thematicBreak()
        .headingL1("Heading")
        .paragraph("Some text")
        .lineBreak()
        .unorderedList()
        .text("list item 1")
        .text("list item 2")
        .text("list item 3")
        .end()
        .lineBreak()
        .link("My website", "https://daily-dev-tips.com")
        .toString();

    String original = readResource("post.md");
    assertEquals(original, generated);
  }

  private String readResource(String resourceName) {
    try {
      var url = getClass().getClassLoader().getResource(resourceName);
      assertNotNull(url, "Resource not found: " + resourceName);
      return Files.readString(Path.of(url.toURI()));
    } catch (Exception cause) {
      throw new IllegalArgumentException(resourceName);
    }
  }
}