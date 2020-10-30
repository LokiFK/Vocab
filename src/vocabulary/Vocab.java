package vocabulary;

import javafx.scene.Node;

public class Vocab extends Node {

  private final String deutsch;
  private final String english;

  public Vocab(String deutsch, String english) {
    this.deutsch = deutsch;
    this.english = english;
  }

  public String getDeutsch() {
    return this.deutsch;
  }

  public String getEnglish() {
    return this.english;
  }

  public boolean isEnglishCorrect(String text) {
    return this.english.equalsIgnoreCase(text);
  }

  public boolean isGermanCorrect(String text) {
    return this.deutsch.equalsIgnoreCase(text);
  }

  @Override
  public String toString() {
    return this.deutsch + " - " + this.english;
  }

  public Vocab getCopy() {
    return new Vocab(this.deutsch, this.english);
  }

  @Override
  public Node getStyleableNode() {
      return null;
  }
}
