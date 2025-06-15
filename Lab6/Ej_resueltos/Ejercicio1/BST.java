package Lab6.Ej_resueltos.Ejercicio1;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        this.root = null;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node<T> insertRec(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.data) < 0) {
            current.left = insertRec(current.left, value);
        } else if (value.compareTo(current.data) > 0) {
            current.right = insertRec(current.right, value);
        }

        return current;
    }

    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(Node<T> node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    public boolean search(T value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value.compareTo(current.data) == 0) {
            return true;
        }
        if (value.compareTo(current.data) < 0) {
            return searchRec(current.left, value);
        } else {
            return searchRec(current.right, value);
        }
    }
}
