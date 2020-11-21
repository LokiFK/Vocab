package vocabulary;

public class VocabBox {

  private Node<Vocab> startNode;

  public boolean addVocab(Vocab v) {
//    CASE 1: list is empty
    if (startNode == null) {
      startNode = new Node<>(v);
      return true;
    }
//    CASE 2: new vocab is supposed to be added to the second node
    if (startNode.getEntry().getDeutsch().compareTo(v.getDeutsch()) > 0) {
      Node<Vocab> node = new Node<>(v);
      node.setNextNode(startNode);
      startNode = node;
      return true;
    }
//    CASE 3: new vocab is supposed to be added in middle or end of list
    Node<Vocab> cursor = startNode;
    while (cursor.getNextNode() != null) {
      if (cursor.getNextNode().getEntry().getDeutsch().compareTo(v.getDeutsch()) < 0) {
        cursor = cursor.getNextNode();
      } else break;
    }
//    swaps current node with new node
    Node<Vocab> node = new Node<>(v);
    node.setNextNode(cursor.getNextNode());
    cursor.setNextNode(node);
    return true;
  }

  //  Gets size of the list
  public int size() {
//    CASE 1: list is empty
    int count = 0;
//    CASE 2: list is not empty
    if (startNode != null) count = 1;
    Node<Vocab> cursor = startNode;
    while (cursor != null) {
      cursor = cursor.getNextNode();
      count++;
    }
    return count;
  }

  //  gets the vocab with index nr
  public Vocab getVocab(int nr) {
    Node<Vocab> cursor = startNode;
//    iterates through the list until nr reached
    while (nr > 0) {
      if (cursor.getNextNode() != null) {
        cursor = cursor.getNextNode();
      } else
        return null;
      nr--;
    }
    return cursor.getEntry();
  }

  //  deletes vocab with index nr
  public void deleteVocab(int nr) {
//    CASE 1: node to delete is in the beginning of the list
    if (nr == 0) {
      startNode = startNode.getNextNode();
      return;
    }
//    CASE 2: node to delete is in the middle or at the end of the list
    Node<Vocab> cursor = startNode;
    while (nr > 1) {
      if (cursor.getNextNode() != null) {
        cursor = cursor.getNextNode();
      } else return;
      nr--;
    }
    if (cursor.getNextNode() != null)
      cursor.setNextNode(cursor.getNextNode().getNextNode());
    else
//      CASE 3: node to delete is at the end of the list
      startNode = null;
  }

  //  updates vocab with index nr
  public void updateVocab(Vocab vocab, int nr) {
    deleteVocab(nr);
    addVocab(vocab);
  }

  //  returns the list as string
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < size(); i++) {
      stringBuilder.append(getVocab(i).toString()).append("\n");
    }
    return stringBuilder.toString();
  }

}
