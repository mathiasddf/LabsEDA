package Lab8.Ej_Propuestos.Ejercicio4;

import java.util.Scanner;

public class TestBTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>(4); // Orden del árbol B
        int opcion;
        Integer valor;

        do {
            System.out.println("""
                
                ======= MENÚ ÁRBOL B =======
                1. Insertar elemento
                2. Eliminar elemento
                3. Buscar elemento
                4. Mínimo
                5. Máximo
                6. Predecesor
                7. Sucesor
                8. Mostrar árbol (estructura)
                9. Destruir árbol
               10. Graficar árbol (GraphStream)
                0. Salir
                ============================
                Ingrese opción:
                """);

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese valor a insertar: ");
                    valor = sc.nextInt();
                    tree.insert(valor);
                    System.out.println("✔ Elemento insertado.");
                }
                case 2 -> {
                    System.out.print("Ingrese valor a eliminar: ");
                    valor = sc.nextInt();
                    tree.remove(valor);
                }
                case 3 -> {
                    System.out.print("Ingrese valor a buscar: ");
                    valor = sc.nextInt();
                    Integer encontrado = tree.search(valor);
                    if (encontrado != null) {
                        System.out.println("🔍 Elemento encontrado: " + encontrado);
                    } else {
                        System.out.println("❌ Elemento NO encontrado.");
                    }
                }
                case 4 -> {
                    Integer min = tree.Min();
                    System.out.println(min != null ? "🔽 Mínimo: " + min : "Árbol vacío.");
                }
                case 5 -> {
                    Integer max = tree.Max();
                    System.out.println(max != null ? "🔼 Máximo: " + max : "Árbol vacío.");
                }
                case 6 -> {
                    System.out.print("Elemento para predecesor: ");
                    valor = sc.nextInt();
                    Integer pred = tree.Predecesor(valor);
                    System.out.println(pred != null ? "⬅ Predecesor: " + pred : "No tiene predecesor o no existe.");
                }
                case 7 -> {
                    System.out.print("Elemento para sucesor: ");
                    valor = sc.nextInt();
                    Integer succ = tree.Sucesor(valor);
                    System.out.println(succ != null ? "➡ Sucesor: " + succ : "No tiene sucesor o no existe.");
                }
                case 8 -> {
                    System.out.println("\n📂 Estructura del árbol:");
                    tree.printTree();
                }
                case 9 -> {
                    tree.destroy();
                    System.out.println("🗑 Árbol destruido.");
                }
                case 10 -> {
                    System.out.println("🧩 Graficando árbol...");
                    String resultado = tree.graficar("✔ Graficación completa.");
                    System.out.println(resultado);
                }
                case 0 -> System.out.println("👋 Saliendo del programa.");
                default -> System.out.println("⚠ Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
