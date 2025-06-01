package Lab4.Ej_propuestos.Ejercicio5;

import java.util.NoSuchElementException;
/**
 * LinkedList<E>
 * Implementación genérica de lista simplemente enlazada con los métodos:
 * - insert(E data)            : inserta al final (mismo que addLast)
 * - printList()               : imprime todos los elementos
 * - deleteByKey(E key)        : elimina la primera ocurrencia de key
 * - deleteAtPosition(int pos) : elimina el nodo en la posición pos (0-based)
 * - size()                    : devuelve el número de nodos
 * - removeFirst()             : elimina y retorna el primer nodo
 * - removeLast()              : elimina y retorna el último nodo
 * - addFirst(E data)          : inserta un nodo al principio
 * - addLast(E data)           : inserta un nodo al final
 */
public class LinkedList<E> {
    private Node<E> head;

    public LinkedList() {
        head = null;
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al final de la lista.
     * Equivalente a addLast(data).
     */
    public void insert(E data) {
        addLast(data);
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al principio de la lista.
     */
    public void addFirst(E data) {
        Node<E> nuevo = new Node<>(data);
        nuevo.setNext(head);
        head = nuevo;
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al final de la lista.
     */
    public void addLast(E data) {
        Node<E> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
            return;
        }
        Node<E> actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }
        actual.setNext(nuevo);
    }

    /**
     * Imprime todos los elementos de la lista en orden.
     * Si la lista está vacía, imprime "La lista está vacía."
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
     * Elimina la primera ocurrencia de 'key' en la lista.
     * Si se elimina, retorna true; si no se encuentra, retorna false.
     */
    public boolean deleteByKey(E key) {
        if (head == null) {
            return false;
        }
        // Si el primer nodo contiene la clave
        if (head.getData().equals(key)) {
            head = head.getNext();
            return true;
        }
        Node<E> actual = head.getNext();
        Node<E> prev = head;
        while (actual != null) {
            if (actual.getData().equals(key)) {
                prev.setNext(actual.getNext());
                return true;
            }
            prev = actual;
            actual = actual.getNext();
        }
        return false;
    }

    /**
     * Elimina el nodo en la posición 'pos' (0-based).
     * Retorna true si se eliminó, o false si pos está fuera de rango.
     */
    public boolean deleteAtPosition(int pos) {
        if (head == null || pos < 0) {
            return false;
        }
        if (pos == 0) {
            head = head.getNext();
            return true;
        }
        Node<E> actual = head;
        Node<E> prev = null;
        int index = 0;
        while (actual != null && index < pos) {
            prev = actual;
            actual = actual.getNext();
            index++;
        }
        if (actual == null) {
            return false;
        }
        prev.setNext(actual.getNext());
        return true;
    }

    /**
     * Devuelve el número de elementos en la lista.
     */
    public int size() {
        int count = 0;
        Node<E> actual = head;
        while (actual != null) {
            count++;
            actual = actual.getNext();
        }
        return count;
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
        head = head.getNext();
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
        if (head.getNext() == null) {
            E valor = head.getData();
            head = null;
            return valor;
        }
        Node<E> actual = head;
        Node<E> prev = null;
        while (actual.getNext() != null) {
            prev = actual;
            actual = actual.getNext();
        }
        E valor = actual.getData();
        prev.setNext(null);
        return valor;
    }
}
