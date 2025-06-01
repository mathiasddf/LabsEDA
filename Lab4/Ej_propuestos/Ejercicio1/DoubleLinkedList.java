package Lab4.Ej_propuestos.Ejercicio1;

public class DoubleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /** Constructor: inicializa la lista vacía. */
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Devuelve true si la lista está vacía. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Devuelve el número de elementos en la lista. */
    public int size() {
        return size;
    }

    /** Elimina todos los elementos de la lista. */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Inserta un elemento al principio. */
    public void addFirst(E data) {
        Node<E> nuevo = new Node<>(data);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.setNext(head);
            head.setPrev(nuevo);
            head = nuevo;
        }
        size++;
    }

    /** Inserta un elemento al final. */
    public void addLast(E data) {
        Node<E> nuevo = new Node<>(data);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.setNext(nuevo);
            nuevo.setPrev(tail);
            tail = nuevo;
        }
        size++;
    }

    /**
     * Inserta un elemento en posición index (0-based).  
     * Lanza IndexOutOfBoundsException si index<0 o index>size.
     */
    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node<E> actual = getNodeAt(index);
        Node<E> nuevo = new Node<>(data);
        Node<E> prevNode = actual.getPrev();
        prevNode.setNext(nuevo);
        nuevo.setPrev(prevNode);
        nuevo.setNext(actual);
        actual.setPrev(nuevo);
        size++;
    }

    /** Elimina y devuelve el primer elemento.  
     *  Lanza IllegalStateException si está vacía. */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        E valor = head.getData();
        if (head == tail) { // solo un nodo
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
        return valor;
    }

    /** Elimina y devuelve el último elemento.  
     *  Lanza IllegalStateException si está vacía. */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        E valor = tail.getData();
        if (head == tail) { // solo un nodo
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        return valor;
    }

    /**
     * Elimina la primera ocurrencia de 'key'.  
     * Devuelve true si se eliminó, false si no se encontró.
     */
    public boolean remove(E key) {
        if (isEmpty()) return false;

        // Caso: la clave está en head
        if (head.getData().equals(key)) {
            removeFirst();
            return true;
        }
        // Caso: la clave está en tail
        if (tail.getData().equals(key)) {
            removeLast();
            return true;
        }
        // Caso general: buscar en medio
        Node<E> actual = head.getNext();
        while (actual != null) {
            if (actual.getData().equals(key)) {
                Node<E> prevNode = actual.getPrev();
                Node<E> nextNode = actual.getNext();
                prevNode.setNext(nextNode);
                if (nextNode != null) {
                    nextNode.setPrev(prevNode);
                }
                size--;
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    /**
     * Elimina y devuelve el elemento en índice index (0-based).  
     * Lanza IndexOutOfBoundsException si index<0 o index>=size.
     */
    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> actual = getNodeAt(index);
        E valor = actual.getData();
        Node<E> prevNode = actual.getPrev();
        Node<E> nextNode = actual.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
        return valor;
    }

    /** Devuelve (sin eliminar) el primer elemento.  
     *  Lanza IllegalStateException si está vacía. */
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        return head.getData();
    }

    /** Devuelve (sin eliminar) el último elemento.  
     *  Lanza IllegalStateException si está vacía. */
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        return tail.getData();
    }

    /**
     * Devuelve (sin eliminar) el elemento en índice index (0-based).  
     * Lanza IndexOutOfBoundsException si index<0 o index>=size.
     */
    public E get(int index) {
        return getNodeAt(index).getData();
    }

    /** Devuelve el índice de la primera ocurrencia de 'key', o -1 si no existe. */
    public int indexOf(E key) {
        Node<E> actual = head;
        int idx = 0;
        while (actual != null) {
            if (actual.getData().equals(key)) {
                return idx;
            }
            actual = actual.getNext();
            idx++;
        }
        return -1;
    }

    /** Devuelve true si existe al menos una ocurrencia de 'key'. */
    public boolean contains(E key) {
        return indexOf(key) != -1;
    }

    /** Imprime los elementos de adelante hacia atrás. */
    public void printForward() {
        System.out.print("Lista adelante: ");
        Node<E> actual = head;
        while (actual != null) {
            System.out.print(actual.getData() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }

    /** Imprime los elementos de atrás hacia adelante. */
    public void printBackward() {
        System.out.print("Lista atrás:   ");
        Node<E> actual = tail;
        while (actual != null) {
            System.out.print(actual.getData() + " ");
            actual = actual.getPrev();
        }
        System.out.println();
    }

    /**
     * (Privado) Devuelve el nodo en índice index (0-based).  
     * Lanza IndexOutOfBoundsException si index<0 o index>=size.
     */
    private Node<E> getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        Node<E> actual;
        // Si está más cerca del principio, recorro desde head
        if (index < size / 2) {
            actual = head;
            for (int i = 0; i < index; i++) {
                actual = actual.getNext();
            }
        } else {
            // Si está más cerca del final, recorro desde tail
            actual = tail;
            for (int i = size - 1; i > index; i--) {
                actual = actual.getPrev();
            }
        }
        return actual;
    }
}
