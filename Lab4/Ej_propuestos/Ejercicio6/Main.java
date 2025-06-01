package Lab4.Ej_propuestos.Ejercicio6;

import java.util.Scanner;

/**
 * Clase Principal con menú interactivo para probar los métodos
 * de LinkedList<Integer> (lista doblemente enlazada genérica).
 * Inicialmente, la lista contiene los elementos 1..10.
 */
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        // Pre-cargar la lista con los enteros del 1 al 10
        for (int i = 1; i <= 10; i++) {
            lista.addLast(i);
        }

        System.out.println("==== LISTA DOBLEMENTE ENLAZADA (1–10) ====");
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1) Mostrar lista");
            System.out.println("2) Insertar al final");
            System.out.println("3) Añadir al inicio");
            System.out.println("4) Eliminar por clave");
            System.out.println("5) Eliminar en posición");
            System.out.println("6) Eliminar primer nodo");
            System.out.println("7) Eliminar último nodo");
            System.out.println("8) Mostrar tamaño");
            System.out.println("0) Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    lista.printList();
                    break;
                case 2:
                    System.out.print("Ingrese el valor a insertar al final: ");
                    int val2 = sc.nextInt();
                    lista.addLast(val2);
                    System.out.println("Valor " + val2 + " insertado al final.");
                    break;
                case 3:
                    System.out.print("Ingrese el valor a insertar al inicio: ");
                    int val3 = sc.nextInt();
                    lista.addFirst(val3);
                    System.out.println("Valor " + val3 + " insertado al inicio.");
                    break;
                case 4:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int clave = sc.nextInt();
                    Integer eliminadoPorClave = lista.deleteByKey(clave);
                    if (eliminadoPorClave != null) {
                        System.out.println("Se eliminó clave " + eliminadoPorClave + ".");
                    } else {
                        System.out.println("Clave " + clave + " no encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la posición (0-based) a eliminar: ");
                    int pos = sc.nextInt();
                    Integer eliminadoPorPos = lista.deleteAtPosition(pos);
                    if (eliminadoPorPos != null) {
                        System.out.println("Se eliminó el nodo en posición " + pos + " (valor: " + eliminadoPorPos + ").");
                    } else {
                        System.out.println("Posición " + pos + " fuera de rango.");
                    }
                    break;
                case 6:
                    try {
                        Integer rem1 = lista.removeFirst();
                        System.out.println("Se eliminó el primer nodo (valor: " + rem1 + ").");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        Integer remLast = lista.removeLast();
                        System.out.println("Se eliminó el último nodo (valor: " + remLast + ").");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;
                case 0:
                    System.out.println("Saliendo…");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
