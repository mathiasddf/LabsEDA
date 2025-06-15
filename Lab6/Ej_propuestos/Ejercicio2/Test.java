package Lab6.Ej_propuestos.Ejercicio2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST<String> asciiTree = new BST<>();

        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();

        for (char c : palabra.toCharArray()) {
            int ascii = (int) c;
            String dato = String.format("%03d(%c)", ascii, c);  // ej: 104(h)
            asciiTree.insert(dato);
        }

        System.out.println("\nRecorrido InOrder (valores ASCII con letras):");
        asciiTree.inOrder();

        System.out.println("\nÁrbol estructurado (valores ASCII con letras):");
        asciiTree.printTree();
        scanner.close();
    }
}

