package Lab4.Ej_propuestos.Ejercicio6;

public class Node<E> {
    private E data;
    private Node<E> prev;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Getter y setter para 'data'
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    // Getter y setter para 'prev'
    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    // Getter y setter para 'next'
    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
