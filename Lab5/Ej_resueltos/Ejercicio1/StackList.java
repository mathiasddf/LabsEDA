package Lab5.Ej_resueltos.Ejercicio1;

public class StackList<T> {
    private Node<T> top;
    private int size = 0;
    
    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.setNext(top);
        top = node;
        size++;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        T value = top.getData();
        top = top.getNext();
        size--;
        return value;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public int size() {
        return size;
    }
}

