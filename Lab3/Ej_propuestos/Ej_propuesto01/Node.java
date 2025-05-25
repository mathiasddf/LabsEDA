package Lab3.Ej_propuestos.Ej_propuesto01;

public class Node<T> {
    private T data;                      // Información del nodo
    private Node<T> nextNode;           // Referencia al siguiente nodo
    private Node<T> previousNode;       // Referencia al nodo anterior (si la lista es doble)
    private boolean isDeleted;          // Marcado lógico para "eliminación suave"
    private int position;               // Posición en la lista (rastreo)

    public Node(T data) {
        this.data = data;
        this.nextNode = null;
        this.previousNode = null;
        this.isDeleted = false;
        this.position = -1; 
    }

    // Getters y Setters

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

