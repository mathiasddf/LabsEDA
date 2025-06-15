package Lab6.Ej_resueltos.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Recorrido en orden (inorder): ");
        tree.inorderTraversal();  // Salida esperada: 20 30 40 50 60 70 80
        System.out.println();

        System.out.println("Buscar 40: " + tree.search(40)); // true
        System.out.println("Buscar 90: " + tree.search(90)); // false
    }
}
