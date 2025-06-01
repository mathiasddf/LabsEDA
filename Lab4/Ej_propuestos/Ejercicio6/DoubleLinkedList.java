package Lab4.Ej_propuestos.Ejercicio6;

import java.util.NoSuchElementException;
/**
 * LinkedList<E>
 * Implementación genérica de lista doblemente enlazada con métodos:
 * - insert(E data)            : inserta al final (alias de addLast)
 * - printList()               : imprime de adelante hacia atrás
 * - deleteByKey(E key)        : elimina la primera ocurrencia de key y lo retorna (o null si no existe)
 * - deleteAtPosition(int pos) : elimina el nodo en la posición pos (0-based) y retorna su dato (o null si fuera de rango)
 * - size()                    : devuelve el número de nodos
 * - removeFirst()             : elimina y retorna el primer nodo
 * - removeLast()              : elimina y retorna el último nodo
 * - addFirst(E data)          : inserta un nodo al principio
 * - addLast(E data)           : inserta un nodo al final
 */
public class DoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al final de la lista.
     * (Alias de addLast)
     */
    public void insert(E data) {
        addLast(data);
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al principio de la lista.
     */
    public void addFirst(E data) {
        Node<E> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.setNext(head);
            head.setPrev(nuevo);
            head = nuevo;
        }
        size++;
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al final de la lista.
     */
    public void addLast(E data) {
        Node<E> nuevo = new Node<>(data);
        if (head == null) {
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
     * Imprime todos los elementos de la lista de adelante hacia atrás.
     * Si está vacía, imprime un mensaje.
     */
    public void printList() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Lista: ");
        Node<E> actual = head;
        while (actual != null) {
            System.out.print(actual.getData() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }

    /**
     * Elimina la primera ocurrencia de 'key' en la lista y retorna su valor.
     * Si no se encuentra, retorna null.
     */
    public E deleteByKey(E key) {
        if (head == null) {
            return null;
        }
        // Si el head contiene la clave
        if (head.getData().equals(key)) {
            return removeFirst();
        }
        Node<E> actual = head.getNext();
        while (actual != null) {
            if (actual.getData().equals(key)) {
                E valor = actual.getData();
                Node<E> prev = actual.getPrev();
                Node<E> next = actual.getNext();
                prev.setNext(next);
                if (next != null) {
                    next.setPrev(prev);
                } else {
                    // era el tail
                    tail = prev;
                }
                size--;
                return valor;
            }
            actual = actual.getNext();
        }
        return null;
    }

    /**
     * Elimina el nodo en la posición 'pos' (0-based) y retorna su valor.
     * Si pos < 0 o pos >= size, retorna null.
     */
    public E deleteAtPosition(int pos) {
        if (head == null || pos < 0 || pos >= size) {
            return null;
        }
        if (pos == 0) {
            return removeFirst();
        }
        if (pos == size - 1) {
            return removeLast();
        }
        Node<E> actual = head;
        for (int i = 0; i < pos; i++) {
            actual = actual.getNext();
        }
        E valor = actual.getData();
        Node<E> prev = actual.getPrev();
        Node<E> next = actual.getNext();
        prev.setNext(next);
        if (next != null) {
            next.setPrev(prev);
        }
        size--;
        return valor;
    }

    /**
     * Retorna el número de nodos en la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Elimina y retorna el primer nodo.
     * Lanza NoSuchElementException si la lista está vacía.
     */
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        E valor = head.getData();
        if (head == tail) {
            // Solo un nodo
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
        return valor;
    }

    /**
     * Elimina y retorna el último nodo.
     * Lanza NoSuchElementException si la lista está vacía.
     */
    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        E valor = tail.getData();
        if (head == tail) {
            // Solo un nodo
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        return valor;
    }
}
