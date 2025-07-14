package Lab9.Ej_propuestos.Ejercicio4;

import java.util.Scanner;

public class TestHashOpenedConMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashOpened<String> hashTable = new HashOpened<>(10);

        int opcion;
        do {
        System.out.println("\n=== MENÚ - HASH ABIERTO ===");
        System.out.println("1. Insertar");
        System.out.println("2. Buscar");
        System.out.println("3. Eliminar");
        System.out.println("4. Mostrar tabla");
        System.out.println("5. ¿Hash vacio?");
        System.out.println("6. Limpiar tabla+");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
            System.out.print("Clave (int): ");
            int key = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Valor (String): ");
            String value = scanner.nextLine();
            hashTable.insert(new Register<>(key, value));
            break;

            case 2:
            System.out.print("Clave a buscar: ");
            int keyBuscar = scanner.nextInt();
            Register<String> encontrado = hashTable.search(keyBuscar);
            if (encontrado != null) {
                System.out.println(" Encontrado: " + encontrado.getValue());
            } else {
                System.out.println(" Clave no encontrada.");
            }
            break;

            case 3:
            System.out.print("Clave a eliminar: ");
            int keyEliminar = scanner.nextInt();
            hashTable.delete(keyEliminar);
            break;

            case 4:
            hashTable.showTable();
            break;

            case 5:
            if (hashTable.isEmpty()) {
                System.out.println(" La tabla está vacía.");
            } else {
                System.out.println(" La tabla NO está vacía.");
            }
            break;

            case 6:
            hashTable.clear();
            break;

            case 0:
            System.out.println("Saliendo...");
            break;

            default:
            System.out.println(" Opción inválida.");
        }

        } while (opcion != 0);

        scanner.close();
    }
}
