package Lab6.Ej_propuestos.Ejercicio2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST<Integer> asciiTree = new BST<>();

        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();

        for (char c : palabra.toCharArray()) {
            int ascii = (int) c;
            asciiTree.insert(ascii);
        }

        asciiTree.inOrder();

        System.out.print("Recorrido InOrder (letras): ");
        imprimirCaracteresInOrder(asciiTree, palabra);
        scanner.close();
    }

    // Método genérico para mostrar los caracteres originales
    public static <E> void imprimirCaracteresInOrder(BST<Integer> tree, String original) {
        // Nota: el árbol no conserva el orden original, así que esta función solo sirve como ilustración.
        // Para reconstruir la palabra original a partir del árbol se requeriría recorrido especial o almacenamiento extra.
        System.out.println("(Los caracteres fueron insertados según su valor ASCII, el árbol no representa la palabra literal)");
    }
}
