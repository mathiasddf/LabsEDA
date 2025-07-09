package Lab8.Ej_Propuestos.Ejercicio3;

import java.util.Scanner;

public class TestBTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>(4);
        int opc, val;

        do {
            System.out.println("""
                \n--- MENÚ ÁRBOL B ---
                1. Insertar
                2. Buscar
                3. Mostrar árbol
                4. Ver mínimo
                5. Ver máximo
                6. Eliminar
                7. Destruir
                0. Salir
                --------------------
                Ingrese opción:
                """);
            opc = sc.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.print("Ingrese valor: ");
                    val = sc.nextInt();
                    tree.insert(val);
                }
                case 2 -> {
                    System.out.print("Buscar valor: ");
                    val = sc.nextInt();
                    Integer result = tree.search(val);
                    System.out.println(result != null ? "Encontrado: " + result : "No encontrado.");
                }
                case 3 -> System.out.println(tree);
                case 4 -> System.out.println("Min: " + tree.Min());
                case 5 -> System.out.println("Max: " + tree.Max());
                case 6 -> {
                    System.out.print("Eliminar valor: ");
                    val = sc.nextInt();
                    tree.remove(val);
                }
                case 7 -> {
                    tree.destroy();
                    System.out.println("Árbol destruido.");
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opc != 0);
        sc.close();
    }
}
