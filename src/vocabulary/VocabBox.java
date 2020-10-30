package vocabulary;

import java.util.LinkedList;
import java.util.List;

public class VocabBox {

  private final List<Vocab> vocabList;

  public VocabBox() {
    vocabList = new LinkedList<>();
  }

  public void addVocab(Vocab v) {
    vocabList.add(v);
  }

  public int size() {
    return vocabList.size();
  }

  public Vocab getVocab(int nr) {
    return vocabList.get(nr);
  }

  public boolean deleteVocab(String name) {
    int loopCounter = 0;
    for (Vocab vocab : vocabList) {
      if (vocab.toString().equals(name)) {
        vocabList.remove(loopCounter);
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (Vocab vocab : vocabList) {
      if (vocab != null) {
        output.append(("\n")).append(vocab.toString());
      }
    }
    return output.toString();
  }

}
