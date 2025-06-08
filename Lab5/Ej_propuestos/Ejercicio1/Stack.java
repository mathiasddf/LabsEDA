package Lab5.Ej_propuestos.Ejercicio1;

public class Stack<E> {
    private Node<E> top;
    private int size = 0;

    // Inserta un elemento en el tope
    public void push(E value) {
        Node<E> node = new Node<>(value);
        node.setNext(top);
        top = node;
        size++;
    }

    // Saca y devuelve el elemento del tope
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        E value = top.getData();
        top = top.getNext();
        size--;
        return value;
    }

    // Método genérico adicional: mira el tope sin sacar
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacía");
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
