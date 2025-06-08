package Lab5.Ej_propuestos.Ejercicio3;

public class Queue<E> {
    private Node<E> head;
    private Node<E> tail;

    // encolar al final
    public void enqueue(E value) {
        Node<E> n = new Node<>(value);
        if (tail != null) {
            tail.setNext(n);
        } else {
            head = n;
        }
        tail = n;
    }

    // desencolar del frente
    public E dequeue() {
        if (head == null) {
            return null;
        }
        E val = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return val;
    }

    // método genérico de ejemplo: devuelve el frente sin remover
    public E Metodo() {
        return head != null ? head.getData() : null;
    }
}

