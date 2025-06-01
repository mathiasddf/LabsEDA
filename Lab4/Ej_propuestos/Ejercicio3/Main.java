package Lab4.Ej_propuestos.Ejercicio3;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Demuestra el uso de java.util.LinkedList<Integer> como lista doblemente enlazada.
 * Inserta los enteros del 1 al 10 y usa métodos genéricos para operar sobre ella.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Crear la lista genérica de Integer
        LinkedList<Integer> lista = new LinkedList<>();

        // 2. Insertar los números del 1 al 10 usando addLast(E elemento)
        for (int i = 1; i <= 10; i++) {
            lista.addLast(i);
        }

        // 3. Mostrar el tamaño con size()
        System.out.println("Tamaño de la lista: " + lista.size());

        // 4. Imprimir la lista de adelante hacia atrás
        System.out.print("Lista adelante: ");
        for (Integer valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();

        // 5. Imprimir la lista de atrás hacia adelante con descendingIterator()
        System.out.print("Lista atrás:   ");
        Iterator<Integer> it = lista.descendingIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 6. Otros métodos genéricos de LinkedList<E>
        System.out.println("Primer elemento (getFirst): " + lista.getFirst());
        System.out.println("Último elemento (getLast):  " + lista.getLast());
        System.out.println("Elemento en índice 4 (get): " + lista.get(4));    // valor 5
        System.out.println("¿Contiene 7? (contains):     " + lista.contains(7));
        System.out.println("Índice de 3 (indexOf):       " + lista.indexOf(3));

        // 7. Eliminar el primer y último con removeFirst() y removeLast()
        Integer eliminadoPrimero = lista.removeFirst();
        Integer eliminadoUltimo   = lista.removeLast();
        System.out.println("\nSe eliminó el primer elemento: " + eliminadoPrimero);
        System.out.println("Se eliminó el último elemento:  " + eliminadoUltimo);

        // 8. Mostrar lista resultante y tamaño final
        System.out.print("Lista actual (adelante): ");
        for (Integer v : lista) {
            System.out.print(v + " ");
        }
        System.out.println("\nTamaño actual: " + lista.size());
    }
}
