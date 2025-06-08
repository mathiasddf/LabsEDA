package Lab5.Ej_resueltos.Ejercicio2;

public class QueueList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    
    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        T value = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        return size;
    }
}
