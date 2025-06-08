package Lab5.Ej_propuestos.Ejercicio2;

public class Stack<E> {
    private Node<E> top;
    private int size;
    private final int capacity;
    
    // Construye una pila vacía con capacidad dada
    public Stack(int capacity) {
        this.top = null;
        this.size = 0;
        this.capacity = capacity;
    }
    
    // push: apila un nuevo elemento
    public void push(E value) {
        if (isFull()) {
            System.out.println("Error: pila llena (capacidad " + capacity + ").");
            return;
        }
        Node<E> node = new Node<>(value);
        node.setNext(top);
        top = node;
        size++;
    }
    
    // pop: desapila y devuelve el tope
    public E pop() {
        if (isEmpty()) {
            System.out.println("Error: pila vacía. No hay nada que desapilar.");
            return null;
        }
        E value = top.getData();
        top = top.getNext();
        size--;
        return value;
    }
    
    // top: devuelve el elemento del tope sin desapilar
    public E top() {
        if (isEmpty()) {
            System.out.println("Error: pila vacía.");
            return null;
        }
        return top.getData();
    }
    
    // destroystak: vacía completamente la pila
    public void destroyStack() {
        top = null;
        size = 0;
        System.out.println("La pila ha sido destruida (vacía).");
    }
    
    // isEmpty: ¿vacía?
    public boolean isEmpty() {
        return size == 0;
    }
    
    // isFull: ¿llena?
    public boolean isFull() {
        return size >= capacity;
    }
    
    // printStack: muestra todos los elementos desde el tope hacia abajo
    public void printStack() {
        if (isEmpty()) {
            System.out.println("[ ] (pila vacía)");
            return;
        }
        System.out.print("[ ");
        Node<E> curr = top;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println("]");
    }
    
    // getter de tamaño actual
    public int size() {
        return size;
    }
    
    // getter de capacidad
    public int capacity() {
        return capacity;
    }
}
