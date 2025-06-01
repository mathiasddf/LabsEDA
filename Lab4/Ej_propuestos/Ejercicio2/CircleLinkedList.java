package Lab4.Ej_propuestos.Ejercicio2;

public class CircleLinkedList<E> {
    private Node<E> head; // Puntero al primer nodo de la lista circular
    private int size;     // Cantidad de elementos en la lista

    /** Constructor: inicializa la lista vacía. */
    public CircleLinkedList() {
        head = null;
        size = 0;
    }

    /** 
     * Devuelve true si la lista no contiene elementos.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna el número de elementos que hay en la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Elimina todos los elementos de la lista dejando head = null y size = 0.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Inserta un nuevo nodo con el dato dado al inicio de la lista circular.
     * Si la lista está vacía, el nuevo nodo apunta a sí mismo.
     * En caso contrario, busca el último nodo actual para que su enlace next apunte al nuevo nodo,
     * y el nuevo nodo apunte al antiguo head.
     */
    public void addFirst(E data) {
        Node<E> nuevo = new Node<>(data);
        if (isEmpty()) {
            head = nuevo;
        } else {
            // Buscar el último nodo para mantener la circularidad
            Node<E> last = head;
            while (last.getNext() != head) {
                last = last.getNext();
            }
            // Enlazar el nuevo nodo entre last y head
            nuevo.setNext(head);
            last.setNext(nuevo);
            head = nuevo;
        }
        size++;
    }

    /**
     * Inserta un nuevo nodo con el dato dado al final de la lista circular.
     * Si la lista está vacía, el nuevo nodo pasa a ser head (y apunta a sí mismo).
     * En caso contrario, busca el último nodo actual y enlaza su next al nuevo nodo,
     * luego el nuevo nodo enlaza de vuelta a head.
     */
    public void addLast(E data) {
        Node<E> nuevo = new Node<>(data);
        if (isEmpty()) {
            head = nuevo;
        } else {
            // Buscar el último nodo actual
            Node<E> last = head;
            while (last.getNext() != head) {
                last = last.getNext();
            }
            // Enlazar nuevo nodo después de last y volver a head
            last.setNext(nuevo);
            nuevo.setNext(head);
        }
        size++;
    }

    /**
     * Inserta un nuevo nodo con el dato dado en la posición index (0-based).
     * Lanza IndexOutOfBoundsException si index < 0 o index > size.
     * - Si index == 0, equivale a addFirst(data).
     * - Si index == size, equivale a addLast(data).
     * - En otro caso, recorre hasta el nodo en index-1, inserta el nuevo nodo
     *   entre ese nodo y su siguiente.
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
        Node<E> actual = head;
        for (int i = 0; i < index - 1; i++) {
            actual = actual.getNext();
        }
        Node<E> nuevo = new Node<>(data);
        nuevo.setNext(actual.getNext());
        actual.setNext(nuevo);
        size++;
    }

    /**
     * Devuelve el dato almacenado en el primer nodo (head).
     * Retorna null si la lista está vacía.
     */
    public E getFirst() {
        return isEmpty() ? null : head.getData();
    }

    /**
     * Devuelve el dato almacenado en el último nodo.
     * Para hallarlo, recorre desde head hasta encontrar un nodo cuyo next apunte a head.
     * Retorna null si la lista está vacía.
     */
    public E getLast() {
        if (isEmpty()) return null;
        Node<E> actual = head;
        while (actual.getNext() != head) {
            actual = actual.getNext();
        }
        return actual.getData();
    }

    /**
     * Devuelve el dato en la posición index (0-based).
     * Lanza IndexOutOfBoundsException si index < 0 o index >= size, o si la lista está vacía.
     * Recorre index pasos desde head.
     */
    public E get(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        Node<E> actual = head;
        for (int i = 0; i < index; i++) {
            actual = actual.getNext();
        }
        return actual.getData();
    }

    /**
     * Retorna el índice de la primera ocurrencia de key en la lista (0-based).
     * Recorre exactamente size nodos partiendo de head.
     * Si no encuentra key, devuelve -1.
     */
    public int indexOf(E key) {
        if (isEmpty()) return -1;
        Node<E> actual = head;
        for (int i = 0; i < size; i++) {
            if (actual.getData().equals(key)) {
                return i;
            }
            actual = actual.getNext();
        }
        return -1;
    }

    /**
     * Devuelve true si la lista contiene al menos una ocurrencia de key.
     * Llama internamente a indexOf(key) != -1.
     */
    public boolean contains(E key) {
        return indexOf(key) != -1;
    }

    /**
     * Elimina y retorna el dato del primer nodo (head).
     * Lanza IllegalStateException si la lista está vacía.
     * Si size == 1, deja head = null.
     * En otro caso, busca el último nodo y actualiza head = head.next,
     * luego hace que last.next apunte al nuevo head.
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        E valor = head.getData();
        if (size == 1) {
            head = null;
        } else {
            Node<E> last = head;
            while (last.getNext() != head) {
                last = last.getNext();
            }
            head = head.getNext();
            last.setNext(head);
        }
        size--;
        return valor;
    }

    /**
     * Elimina y retorna el dato del último nodo.
     * Lanza IllegalStateException si la lista está vacía.
     * Si size == 1, deja head = null.
     * En otro caso, recorre hasta el penúltimo nodo (prev tal que prev.next.next == head),
     * almacena el dato del siguiente, hace prev.next = head, decrementa size y retorna el dato.
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        if (size == 1) {
            E valor = head.getData();
            head = null;
            size--;
            return valor;
        }
        Node<E> prev = head;
        while (prev.getNext().getNext() != head) {
            prev = prev.getNext();
        }
        E valor = prev.getNext().getData();
        prev.setNext(head);
        size--;
        return valor;
    }

    /**
     * Elimina la primera ocurrencia de key.
     * Si la clave está en head, llama a removeFirst().
     * De lo contrario, recorre la lista (exactamente size-1 pasos) buscando key;
     * cuando lo encuentra, hace prev.next = actual.next y decrementa size.
     * Devuelve true si eliminó, false si no encontró la clave.
     */
    public boolean remove(E key) {
        if (isEmpty()) return false;
        if (head.getData().equals(key)) {
            removeFirst();
            return true;
        }
        Node<E> prev = head;
        Node<E> actual = head.getNext();
        for (int i = 1; i < size; i++) {
            if (actual.getData().equals(key)) {
                prev.setNext(actual.getNext());
                size--;
                return true;
            }
            prev = actual;
            actual = actual.getNext();
        }
        return false;
    }

    /**
     * Elimina y retorna el dato del nodo en la posición index (0-based).
     * Lanza IndexOutOfBoundsException si index < 0 o index >= size, o si la lista está vacía.
     * Si index == 0, llama a removeFirst().
     * En otro caso, recorre hasta prev = nodo en index-1, almacena valor de prev.next,
     * luego hace prev.next = prev.next.next, decrementa size y retorna el dato.
     */
    public E removeAt(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        if (index == 0) {
            return removeFirst();
        }
        Node<E> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.getNext();
        }
        E valor = prev.getNext().getData();
        prev.setNext(prev.getNext().getNext());
        size--;
        return valor;
    }

    /**
     * Imprime exactamente un ciclo completo de la lista.
     * Si la lista está vacía, imprime un mensaje indicándolo.
     * Recorre con do/while para asegurarse de pasar por head al menos una vez.
     */
    public void printOneCycle() {
        if (isEmpty()) {
            System.out.println("La lista circular está vacía.");
            return;
        }
        System.out.print("Lista circular (1 ciclo): ");
        Node<E> actual = head;
        do {
            System.out.print(actual.getData() + " ");
            actual = actual.getNext();
        } while (actual != head);
        System.out.println();
    }

    /**
     * Imprime n elementos consecutivos empezando en head,
     * obedeciendo la naturaleza circular (si n > size, continua dando vueltas).
     * Si n <= 0 o la lista está vacía, imprime mensaje apropiado.
     */
    public void printN(int n) {
        if (isEmpty() || n <= 0) {
            System.out.println("Nada que imprimir.");
            return;
        }
        System.out.print("Imprimo " + n + " elementos: ");
        Node<E> actual = head;
        for (int i = 0; i < n; i++) {
            System.out.print(actual.getData() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }
}
