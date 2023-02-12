package dev.noid.genmark.model;

record InlineLink(String text, String url, String title) {

  @Override
  public String toString() {
    return String.format("[%s](%s%s)", text, url, title.isEmpty() ? "" : " \"" + title + "\"");
  }
}
