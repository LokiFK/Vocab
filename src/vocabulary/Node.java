package vocabulary;

public class Node<T> {

    private Node<T> nextNode;
    private final T entry;

//    sets the entry so that the node is never null
public Node(T entry) {
    this.entry = entry;
}

    //    gets the next node
    public Node<T> getNextNode() {
        return nextNode;
    }

    //    sets the next node
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    //    gets the entry of current node
    public T getEntry() {
        return entry;
    }

    //    returns entry.toString()
    public String toString() {
        return entry.toString();
    }

}
