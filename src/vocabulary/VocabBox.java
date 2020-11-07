package vocabulary;

import java.util.*;

public class VocabBox {

  private List<Vocab> vocabList;

  public VocabBox() {
    vocabList = new LinkedList<>();
  }

  public void addVocab(Vocab v) {
    vocabList.add(v);
    sortVocabBox();
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

  public void deleteVocab(int nr) {
    vocabList.remove(nr);
    sortVocabBox();
  }

  public void sortVocabBox() {
      for (int i = 1; i < vocabList.size(); i++) {
        for (int j = i; j > 0 && vocabList.get(j-1).getDeutsch().compareTo(vocabList.get(j).getDeutsch()) > 0; j--) {
          Vocab temp = vocabList.get(j);
          updateVocab(vocabList.get(j-1), j);
          updateVocab(temp, j-1);
        }
      }
  }

  public void updateVocab(Vocab vocab, int nr) {
    vocabList.set(nr, vocab);
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
