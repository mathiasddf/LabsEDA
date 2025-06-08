package Lab5.Ej_propuestos.Ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int CAP = 10;
        Queue<Integer> queue = new Queue<>(CAP);
        Scanner sc = new Scanner(System.in);

        // cargar cola con 1–10
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }
        System.out.println("Cola inicial cargada con 1–10.\n");

        int opcion;
        do {
            System.out.println("---- MENÚ DE COLA ----");
            System.out.println("1. enqueue (agregar)");
            System.out.println("2. dequeue (atender)");
            System.out.println("3. front (ver frente)");
            System.out.println("4. back (ver último)");
            System.out.println("5. destroyQueue (vaciar)");
            System.out.println("6. isEmpty");
            System.out.println("7. isFull");
            System.out.println("8. printQueue");
            System.out.println("9. Salir");
            System.out.print("Elige [1–9]: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a encolar: ");
                    int v = sc.nextInt();
                    queue.enqueue(v);
                    break;
                case 2:
                    Integer at = queue.dequeue();
                    if (at != null) System.out.println("Atendido: " + at);
                    break;
                case 3:
                    Integer f = queue.front();
                    if (f != null) System.out.println("Frente: " + f);
                    break;
                case 4:
                    Integer b = queue.back();
                    if (b != null) System.out.println("Último: " + b);
                    break;
                case 5:
                    queue.destroyQueue();
                    break;
                case 6:
                    System.out.println("¿Vacía? " + queue.isEmpty());
                    break;
                case 7:
                    System.out.println("¿Llena? " + queue.isFull() + " (" + queue.size() + "/" + queue.capacity() + ")");
                    break;
                case 8:
                    System.out.print("Contenido: ");
                    queue.printQueue();
                    break;
                case 9:
                    System.out.println("Saliendo.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 9);

        sc.close();
    }
}
