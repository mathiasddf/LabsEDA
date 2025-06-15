package Lab6.Ej_propuestos.Ejercicio1;

public class Test {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("InOrder:");
        tree.inOrder(); // 20 30 40 50 60 70 80

        System.out.println("PreOrder:");
        tree.preOrder(); // 50 30 20 40 70 60 80

        System.out.println("PostOrder:");
        tree.postOrder(); // 20 40 30 60 80 70 50

        System.out.println("Min: " + tree.min()); // 20
        System.out.println("Max: " + tree.max()); // 80

        System.out.println("Buscar 60: " + tree.search(60)); // true
        System.out.println("Buscar 90: " + tree.search(90)); // false

        System.out.println("Sucesor de 60: " + tree.successor(60)); // 70
        System.out.println("Predecesor de 60: " + tree.predecessor(60)); // 50

        System.out.println("Eliminar 70:");
        tree.remove(70);
        tree.inOrder(); // 20 30 40 50 60 80

        System.out.println("Destruir árbol:");
        tree.destroy();
        System.out.println("¿Árbol vacío? " + tree.isEmpty()); // true
    }
}
