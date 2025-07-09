package Lab8.Ej_Propuestos.Ejercicio3;

public class BTree<T extends Comparable<T>> {
    private BNode<T> root;
    private int orden;
    private boolean up;
    private BNode<T> newChild;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void destroy() {
        root = null;
    }

    public void insert(T key) {
        up = false;
        T mediana = push(root, key);
        if (up) {
            BNode<T> newRoot = new BNode<>(orden);
            newRoot.count = 1;
            newRoot.keys.set(0, mediana);
            newRoot.children.set(0, root);
            newRoot.children.set(1, newChild);
            root = newRoot;
        }
    }

    private T push(BNode<T> node, T key) {
        if (node == null) {
            up = true;
            newChild = null;
            return key;
        }
        int[] pos = new int[1];
        if (node.searchKey(key, pos)) {
            System.out.println("Elemento duplicado.");
            up = false;
            return null;
        }
        T mediana = push(node.children.get(pos[0]), key);
        if (up) {
            if (node.isFull(orden)) {
                mediana = divideNode(node, mediana, pos[0]);
            } else {
                insertInNode(node, mediana, newChild, pos[0]);
                up = false;
            }
        }
        return mediana;
    }

    private void insertInNode(BNode<T> node, T key, BNode<T> child, int k) {
        for (int i = node.count - 1; i >= k; i--) {
            node.keys.set(i + 1, node.keys.get(i));
            node.children.set(i + 2, node.children.get(i + 1));
        }
        node.keys.set(k, key);
        node.children.set(k + 1, child);
        node.count++;
    }

    private T divideNode(BNode<T> node, T key, int k) {
        BNode<T> right = newChild;
        int mid = orden / 2;
        BNode<T> newNode = new BNode<>(orden);

        for (int i = mid; i < orden - 1; i++) {
            newNode.keys.set(i - mid, node.keys.get(i));
            newNode.children.set(i - mid + 1, node.children.get(i + 1));
        }

        newNode.count = (orden - 1) - mid;
        node.count = mid;

        if (k <= mid) {
            insertInNode(node, key, right, k);
        } else {
            insertInNode(newNode, key, right, k - mid);
        }

        T median = node.keys.get(node.count - 1);
        newNode.children.set(0, node.children.get(node.count));
        node.count--;
        newChild = newNode;
        return median;
    }

    public String toString() {
        if (isEmpty()) return "Árbol vacío.";
        return writeTree(root, 0);
    }

    private String writeTree(BNode<T> node, int level) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = node.count - 1; i >= 0; i--) {
            sb.append(writeTree(node.children.get(i + 1), level + 1));
            sb.append(" ".repeat(level * 4)).append(node.keys.get(i)).append("\n");
        }
        sb.append(writeTree(node.children.get(0), level + 1));
        return sb.toString();
    }

    public T search(T key) {
        return searchRec(root, key);
    }

    private T searchRec(BNode<T> node, T key) {
        if (node == null) return null;
        int[] pos = new int[1];
        boolean found = node.searchKey(key, pos);
        if (found) return node.keys.get(pos[0]);
        return searchRec(node.children.get(pos[0]), key);
    }

    // Métodos placeholder:
    public T Min() { return null; }
    public T Max() { return null; }
    public T Predecesor(T x) { return null; }
    public T Sucesor(T x) { return null; }
    public void remove(T x) { System.out.println("Eliminación no implementada aún."); }
}

