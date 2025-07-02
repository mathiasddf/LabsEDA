package Lab7.Ej_Propuestos.Ejercicio2;

import java.util.List;
import java.util.Scanner;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n--- Menú AVL ---");
            System.out.println("1) Destroy");
            System.out.println("2) isEmpty");
            System.out.println("3) insert(x)");
            System.out.println("4) remove(x)");
            System.out.println("5) search(x)");
            System.out.println("6) Min()");
            System.out.println("7) Max()");
            System.out.println("8) Predecesor(x)");
            System.out.println("9) Sucesor(x)");
            System.out.println("10) InOrder");
            System.out.println("11) PreOrder");
            System.out.println("12) PostOrder");
            System.out.println("13) Mostrar árbol");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opt = sc.nextInt();
            Integer x;
            List<Integer> lst;
            switch (opt) {
                case 1:
                    tree.destroy();
                    System.out.println("Árbol destruido.");
                    break;
                case 2:
                    System.out.println("¿Vacío? " + tree.isEmpty());
                    break;
                case 3:
                    System.out.print("Valor a insertar: ");
                    x = sc.nextInt();
                    tree.insert(x);
                    break;
                case 4:
                    System.out.print("Valor a eliminar: ");
                    x = sc.nextInt();
                    tree.remove(x);
                    break;
                case 5:
                    System.out.print("Valor a buscar: ");
                    x = sc.nextInt();
                    System.out.println("Resultado: " + tree.search(x));
                    break;
                case 6:
                    System.out.println("Mínimo: " + tree.Min());
                    break;
                case 7:
                    System.out.println("Máximo: " + tree.Max());
                    break;
                case 8:
                    System.out.print("Predecesor de: ");
                    x = sc.nextInt();
                    System.out.println("Predecesor: " + tree.Predecesor(x));
                    break;
                case 9:
                    System.out.print("Sucesor de: ");
                    x = sc.nextInt();
                    System.out.println("Sucesor: " + tree.Sucesor(x));
                    break;
                case 10:
                    lst = tree.InOrder();
                    System.out.println("InOrder: " + lst);
                    break;
                case 11:
                    lst = tree.PreOrder();
                    System.out.println("PreOrder: " + lst);
                    break;
                case 12:
                    lst = tree.PostOrder();
                    System.out.println("PostOrder: " + lst);
                    break;
                case 13:
                    System.out.println(tree);
                    break;
                case 0:
                    System.out.println("Saliendo…");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opt != 0);
        sc.close();
    }
}

