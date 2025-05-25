package Lab3.Ej_propuestos.Ej_propuesto01;

public class List<T> {
    private Node<T> root;       // Primer nodo
    private Node<T> tail;       // Último nodo
    private int size;           // Tamaño de la lista
    private String name;        // Nombre opcional de la lista
    private int idCounter;      // Contador interno de posición

    // Constructor por defecto (sin forzar nada)
    public List() {
        this.root = null;
        this.tail = null;
        this.size = 0;
        this.name = "Lista";      // Nombre por defecto
        this.idCounter = 0;
    }

    // Agregar al final
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setPosition(idCounter++);  // Asignar posición lógica
        if (root == null) {
            root = tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    // Obtener un elemento por índice
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return current.getData();
    }

    // Eliminar por índice
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            root = root.getNextNode();
            if (root == null) tail = null;
        } else {
            Node<T> previous = root;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNextNode();
            }
            Node<T> toDelete = previous.getNextNode();
            previous.setNextNode(toDelete.getNextNode());
            if (toDelete == tail) tail = previous;
        }
        size--;
    }

    // Verificar si contiene un dato
    public boolean contains(T data) {
        Node<T> current = root;
        while (current != null) {
            if (current.getData().equals(data)) return true;
            current = current.getNextNode();
        }
        return false;
    }

    // Obtener tamaño
    public int size() {
        return size;
    }

    // Vaciar lista
    public void clear() {
        root = null;
        tail = null;
        size = 0;
        idCounter = 0;
    }

    // Verificar si está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Imprimir contenido
    public void printList() {
        System.out.print("[" + name + "] ");
        Node<T> current = root;
        while (current != null) {
            System.out.print("(" + current.getPosition() + ") " + current.getData() + " -> ");
            current = current.getNextNode();
        }
        System.out.println("null");
    }
}
