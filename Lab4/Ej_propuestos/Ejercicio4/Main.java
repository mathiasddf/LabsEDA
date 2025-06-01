package Lab4.Ej_propuestos.Ejercicio4;

import java.util.LinkedList;

/**
 * Demuestra cómo usar java.util.LinkedList<Integer> para
 * tratarla como lista circular con los elementos del 1 al 12.
 */
public class Main {
    public static void main(String[] args) {
        // 1) Crear LinkedList genérica de Integer
        LinkedList<Integer> lista = new LinkedList<>();

        // 2) Insertar los enteros del 1 al 12
        for (int i = 1; i <= 12; i++) {
            lista.addLast(i);
        }

        // 3) Mostrar tamaño usando size()
        System.out.println("Tamaño de la lista: " + lista.size());

        // 4) Imprimir un ciclo completo (elementos 1–12)
        System.out.print("Ciclo completo: ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();

        // 5) Simular lista circular imprimiendo 15 elementos (da vuelta a partir del 13)
        int n = 15;
        System.out.print("Imprimo " + n + " elementos (circular): ");
        int size = lista.size();
        for (int i = 0; i < n; i++) {
            // Usar módulo para “volver” al principio
            int valor = lista.get(i % size);
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}

