package Lab5.Ej_propuestos.Ejercicio4;

public class Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private final int capacity;

    public Queue(int capacity) {
        this.head = this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    // encolar al final
    public void enqueue(E value) {
        if (isFull()) {
            System.out.println("Error: cola llena.");
            return;
        }
        Node<E> n = new Node<>(value);
        if (tail != null) {
            tail.setNext(n);
        } else {
            head = n;
        }
        tail = n;
        size++;
    }

    // desencolar del frente
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Error: cola vacía.");
            return null;
        }
        E val = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    // devuelve y no remueve el frente
    public E front() {
        if (isEmpty()) {
            System.out.println("Error: cola vacía.");
            return null;
        }
        return head.getData();
    }

    // devuelve y no remueve el último elemento
    public E back() {
        if (isEmpty()) {
            System.out.println("Error: cola vacía.");
            return null;
        }
        return tail.getData();
    }

    // vacía completamente la cola
    public void destroyQueue() {
        head = tail = null;
        size = 0;
        System.out.println("La cola ha sido destruida.");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    // imprime todos los elementos de frente a fin
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("[ ] (cola vacía)");
            return;
        }
        System.out.print("[ ");
        for (Node<E> cur = head; cur != null; cur = cur.getNext()) {
            System.out.print(cur.getData() + " ");
        }
        System.out.println("]");
    }

    // getters
    public int size() {
        return size;
    }
    public int capacity() {
        return capacity;
    }
}

