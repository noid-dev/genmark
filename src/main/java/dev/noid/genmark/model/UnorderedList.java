package dev.noid.genmark.model;

record UnorderedList(Iterable<String> items, char bulletSymbol, String lineSeparator) {

  @Override
  public String toString() {
    StringBuilder temp = new StringBuilder();
    for (String item : items) {
      temp.append(String.format("%s %s%s", bulletSymbol, item, lineSeparator));
    }
    return temp.toString();
  }
}
