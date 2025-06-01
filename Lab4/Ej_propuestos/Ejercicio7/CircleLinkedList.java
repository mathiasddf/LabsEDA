package Lab4.Ej_propuestos.Ejercicio7;

import java.util.NoSuchElementException;

/**
 * LinkedList<E>
 * Implementación genérica de lista circular simple con métodos:
 * - insert(E data)            : inserta al final (alias de addLast)
 * - printList()               : imprime un ciclo completo
 * - deleteByKey(E key)        : elimina la primera ocurrencia de key y retorna su valor (o null si no existe)
 * - deleteAtPosition(int pos) : elimina el nodo en la posición pos (0-based) y retorna su valor (o null si fuera de rango)
 * - size()                    : devuelve el número de nodos
 * - removeFirst()             : elimina y retorna el primer nodo
 * - removeLast()              : elimina y retorna el último nodo
 * - addFirst(E data)          : inserta un nodo al principio
 * - addLast(E data)           : inserta un nodo al final
 */
public class CircleLinkedList<E> {
    private Node<E> head;
    private int size;

    public CircleLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al final de la lista circular.
     * Alias de addLast(data).
     */
    public void insert(E data) {
        addLast(data);
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al principio (head) de la lista.
     */
    public void addFirst(E data) {
        Node<E> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
        } else {
            // Buscar el último nodo para enlazarlo al nuevo head
            Node<E> last = head;
            while (last.getNext() != head) {
                last = last.getNext();
            }
            nuevo.setNext(head);
            last.setNext(nuevo);
            head = nuevo;
        }
        size++;
    }

    /**
     * Inserta un nuevo nodo con valor 'data' al final de la lista circular.
     */
    public void addLast(E data) {
        Node<E> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
        } else {
            // Buscar el último nodo actual
            Node<E> last = head;
            while (last.getNext() != head) {
                last = last.getNext();
            }
            last.setNext(nuevo);
            nuevo.setNext(head);
        }
        size++;
    }

    /**
     * Imprime un ciclo completo de la lista empezando desde head.
     * Si está vacía, imprime mensaje.
     */
    public void printList() {
        if (head == null) {
            System.out.println("La lista circular está vacía.");
            return;
        }
        System.out.print("Lista circular: ");
        Node<E> actual = head;
        do {
            System.out.print(actual.getData() + " ");
            actual = actual.getNext();
        } while (actual != head);
        System.out.println();
    }

    /**
     * Elimina la primera ocurrencia de 'key' y retorna su valor.
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
        Node<E> prev = head;
        Node<E> actual = head.getNext();
        while (actual != head) {
            if (actual.getData().equals(key)) {
                prev.setNext(actual.getNext());
                size--;
                return actual.getData();
            }
            prev = actual;
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
        Node<E> prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.getNext();
        }
        Node<E> objetivo = prev.getNext();
        E valor = objetivo.getData();
        prev.setNext(objetivo.getNext());
        size--;
        return valor;
    }

    /**
     * Devuelve el número de nodos en la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Elimina y retorna el valor del primer nodo (head).
     * Lanza NoSuchElementException si la lista está vacía.
     */
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        E valor = head.getData();
        if (size == 1) {
            head = null;
        } else {
            // Buscar el último nodo para enlazarlo al nuevo head
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
     * Elimina y retorna el valor del último nodo.
     * Lanza NoSuchElementException si la lista está vacía.
     */
    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException("La lista está vacía.");
        }
        if (size == 1) {
            E valor = head.getData();
            head = null;
            size--;
            return valor;
        }
        // Buscar el penúltimo nodo
        Node<E> prev = head;
        while (prev.getNext().getNext() != head) {
            prev = prev.getNext();
        }
        Node<E> last = prev.getNext();
        E valor = last.getData();
        prev.setNext(head);
        size--;
        return valor;
    }
}
