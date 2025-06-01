package Lab4.Ej_propuestos.Ejercicio7;

public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = this; // Por defecto, apunta a sí mismo en lista circular
    }

    // Getter y setter para 'data'
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    // Getter y setter para 'next'
    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

