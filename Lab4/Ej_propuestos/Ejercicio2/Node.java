package Lab4.Ej_propuestos.Ejercicio2;

public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = this; // En lista circular, un nodo aislado apunta a sí mismo
    }

    // Getter y setter 
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
