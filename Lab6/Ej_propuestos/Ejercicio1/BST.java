package Lab6.Ej_propuestos.Ejercicio1;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void destroy() {
        root = null; // El recolector de basura eliminará los nodos
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

    public boolean search(T value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node<T> node, T value) {
        if (node == null) return false;
        if (value.compareTo(node.data) == 0) return true;
        if (value.compareTo(node.data) < 0)
            return searchRec(node.left, value);
        else
            return searchRec(node.right, value);
    }

    public void remove(T value) {
        root = removeRec(root, value);
    }

    private Node<T> removeRec(Node<T> node, T value) {
        if (node == null) return null;
        if (value.compareTo(node.data) < 0)
            node.left = removeRec(node.left, value);
        else if (value.compareTo(node.data) > 0)
            node.right = removeRec(node.right, value);
        else {
            // nodo con un hijo o sin hijo
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // nodo con dos hijos: buscar sucesor
            node.data = minRec(node.right);
            node.right = removeRec(node.right, node.data);
        }
        return node;
    }

    public T min() {
        return minRec(root);
    }

    private T minRec(Node<T> node) {
        if (node == null) return null;
        while (node.left != null) node = node.left;
        return node.data;
    }

    public T max() {
        return maxRec(root);
    }

    private T maxRec(Node<T> node) {
        if (node == null) return null;
        while (node.right != null) node = node.right;
        return node.data;
    }

    public T predecessor(T value) {
        Node<T> current = root;
        Node<T> predecessor = null;

        while (current != null) {
            if (value.compareTo(current.data) > 0) {
                predecessor = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return predecessor != null ? predecessor.data : null;
    }

    public T successor(T value) {
        Node<T> current = root;
        Node<T> successor = null;

        while (current != null) {
            if (value.compareTo(current.data) < 0) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return successor != null ? successor.data : null;
    }

    public void inOrder() {
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

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node<T> node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
}
