package vocabulary;

public class Node<T> {

    private Node<T> nextNode;
    private final T entry;

    public Node(T entry) {
        this.entry = entry;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getEntry() {
        return entry;
    }

    public String toString() {
        return entry.toString();
    }

}
