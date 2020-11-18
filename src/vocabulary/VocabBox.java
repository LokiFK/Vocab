package vocabulary;

public class VocabBox {

  private Node<Vocab> startNode;

  public boolean addVocab(Vocab v) {
    if (startNode == null) {
      startNode = new Node<>(v);
      return true;
    }
    if (startNode.getEntry().getDeutsch().compareTo(v.getDeutsch()) > 0) {
      Node<Vocab> node = new Node<>(v);
      node.setNextNode(startNode);
      startNode = node;
      return true;
    }
    Node<Vocab> cursor = startNode;
    while (cursor.getNextNode() != null) {
      if (cursor.getNextNode().getEntry().getDeutsch().compareTo(v.getDeutsch()) < 0) {
        cursor = cursor.getNextNode();
      } else break;
    }
    Node<Vocab> node = new Node<>(v);
    node.setNextNode(cursor.getNextNode());
    cursor.setNextNode(node);
    return true;
  }

  public int size() {
    int count = 0;
    if (startNode != null) count = 1;
    Node<Vocab> cursor = startNode;
    while (cursor != null) {
      cursor = cursor.getNextNode();
      count++;
    }
    return count;
  }

  public Vocab getVocab(int nr) {
    Node<Vocab> cursor = startNode;
    while (nr > 0) {
      if (cursor.getNextNode() != null) {
        cursor = cursor.getNextNode();
      } else
        return null;
      nr--;
    }
    return cursor.getEntry();
  }

  public boolean deleteVocab(String name) {
    return true;
  }

  public void deleteVocab(int nr) {
    Node<Vocab> cursor = startNode;
    while (nr > 1) {
      if (cursor.getNextNode() != null) {
        cursor = cursor.getNextNode();
      } else return;
      nr--;
    }
    cursor.setNextNode(cursor.getNextNode().getNextNode());
  }

  public void updateVocab(Vocab vocab, int nr) {
    deleteVocab(nr);
    addVocab(vocab);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < size(); i++) {
      stringBuilder.append(getVocab(i).toString()).append("\n");
    }
    return stringBuilder.toString();
  }

}
