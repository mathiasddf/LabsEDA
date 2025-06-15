package Lab6.Ej_propuestos.Ejercicio2;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        root = null;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        if (value.compareTo(node.data) < 0)
            node.left = insertRec(node.left, value);
        else if (value.compareTo(node.data) > 0)
            node.right = insertRec(node.right, value);
        return node;
    }

    public void inOrder() {
        System.out.print("InOrder (códigos ASCII): ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<T> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }
}
