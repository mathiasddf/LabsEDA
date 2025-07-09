package Lab8.Ej_Propuestos.Ejercicio7;

import java.util.Scanner;

public class TestBPlusTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el orden del árbol B+: ");
        int orden = sc.nextInt();
        BPlusTree<Integer> arbol = new BPlusTree<>(orden);

        int opcion;
        do {
            System.out.println("\n--- MENÚ B+ TREE ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mínimo");
            System.out.println("5. Máximo");
            System.out.println("6. Predecesor");
            System.out.println("7. Sucesor");
            System.out.println("8. Mostrar árbol");
            System.out.println("9. Destruir árbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese valor a insertar: ");
                    int valIns = sc.nextInt();
                    arbol.insert(valIns);
                    System.out.println("Insertado correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese valor a eliminar: ");
                    int valDel = sc.nextInt();
                    arbol.remove(valDel);
                    System.out.println("Eliminado si existía.");
                    break;
                case 3:
                    System.out.print("Ingrese valor a buscar: ");
                    int valBus = sc.nextInt();
                    System.out.println(arbol.search(valBus) != null ? "Encontrado." : "No encontrado.");
                    break;
                case 4:
                    System.out.println("Mínimo: " + arbol.Min());
                    break;
                case 5:
                    System.out.println("Máximo: " + arbol.Max());
                    break;
                case 6:
                    System.out.print("Ingrese valor para predecesor: ");
                    int valPred = sc.nextInt();
                    System.out.println("Predecesor: " + arbol.Predecesor(valPred));
                    break;
                case 7:
                    System.out.print("Ingrese valor para sucesor: ");
                    int valSucc = sc.nextInt();
                    System.out.println("Sucesor: " + arbol.Sucesor(valSucc));
                    break;
                case 8:
                    System.out.println("\nRepresentación del árbol:");
                    System.out.println(arbol);
                    break;
                case 9:
                    arbol.destroy();
                    System.out.println("Árbol destruido.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}
