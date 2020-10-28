package vocabs;

import javafx.scene.Node;

public class Vokabel extends Node {

  private final String deutsch;
  private final String englisch;

  public Vokabel(String deutsch, String englisch) {
    this.deutsch = deutsch;
    this.englisch = englisch;
  }

  public String getDeutsch() {
    return this.deutsch;
  }

  public String getEnglisch() {
    return this.englisch;
  }

  public boolean isEnglischKorrekt(String text) {
    return this.englisch.equalsIgnoreCase(text);
  }

  public boolean isDeutschKorrekt(String text) {
    return this.deutsch.equalsIgnoreCase(text);
  }

  @Override
  public String toString() {
    return this.deutsch + " - " + this.englisch;
  }

  public Vokabel getCopy() {
    return new Vokabel(this.deutsch, this.englisch);
  }

    @Override
    public Node getStyleableNode() {
        return null;
    }
}
