package Lab7.Ej_Propuestos.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<? super T>> {

    private NodeAVL<T> root;

    // Inserta un nodo y muestra paso a paso y rotaciones
    public void insert(T key) {
        System.out.println("\n=== Insertar " + key + " ===");
        root = insert(root, key);
    }

    private NodeAVL<T> insert(NodeAVL<T> node, T key) {
        if (node == null) {
            System.out.println("  -> Nodo " + key + " creado");
            return new NodeAVL<>(key);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key);
        } else if (cmp > 0) {
            node.right = insert(node.right, key);
        } else {
            System.out.println("  ¡Clave duplicada: " + key + "!");
            return node;
        }
        updateHeight(node);
        return rebalance(node);
    }

    // Elimina un nodo y muestra paso a paso y rotaciones
    public void delete(T key) {
        System.out.println("\n=== Eliminar " + key + " ===");
        root = delete(root, key);
    }

    private NodeAVL<T> delete(NodeAVL<T> node, T key) {
        if (node == null) {
            System.out.println("  -> " + key + " no encontrado");
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            System.out.println("  -> Nodo " + key + " eliminado");
            // caso 1 o 2 hijos
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // caso 2 hijos: tomar el sucesor
            NodeAVL<T> succ = minValueNode(node.right);
            node.key = succ.key;
            node.right = delete(node.right, succ.key);
        }
        updateHeight(node);
        return rebalance(node);
    }

    private NodeAVL<T> minValueNode(NodeAVL<T> n) {
        while (n.left != null) n = n.left;
        return n;
    }

    // Rebalancea y registra la rotación usada
    private NodeAVL<T> rebalance(NodeAVL<T> z) {
        int bf = balanceFactor(z);
        // Rotación izquierda
        if (bf > 1 && balanceFactor(z.right) >= 0) {
            System.out.println("  Rotación simple izq en " + z.key);
            return rotateLeft(z);
        }
        // Rotación derecha
        if (bf < -1 && balanceFactor(z.left) <= 0) {
            System.out.println("  Rotación simple der en " + z.key);
            return rotateRight(z);
        }
        // Rotación doble derecha-izq
        if (bf > 1 && balanceFactor(z.right) < 0) {
            System.out.println("  Rotación doble der‑izq en " + z.key);
            z.right = rotateRight(z.right);
            return rotateLeft(z);
        }
        // Rotación doble izq‑der
        if (bf < -1 && balanceFactor(z.left) > 0) {
            System.out.println("  Rotación doble izq‑der en " + z.key);
            z.left = rotateLeft(z.left);
            return rotateRight(z);
        }
        return z;
    }

    private NodeAVL<T> rotateLeft(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        x.right = y.left;
        y.left = x;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private NodeAVL<T> rotateRight(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        y.left = x.right;
        x.right = y;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(NodeAVL<T> n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(NodeAVL<T> n) {
        return n == null ? 0 : n.height;
    }

    private int balanceFactor(NodeAVL<T> n) {
        return n == null ? 0 : height(n.right) - height(n.left);
    }

    // ————— Recorridos que devuelven listas —————

    public List<T> inOrder() {
        List<T> r = new ArrayList<>();
        inOrder(root, r);
        return r;
    }
    private void inOrder(NodeAVL<T> n, List<T> r) {
        if (n == null) return;
        inOrder(n.left, r);
        r.add(n.key);
        inOrder(n.right, r);
    }

    public List<T> preOrder() {
        List<T> r = new ArrayList<>();
        preOrder(root, r);
        return r;
    }
    private void preOrder(NodeAVL<T> n, List<T> r) {
        if (n == null) return;
        r.add(n.key);
        preOrder(n.left, r);
        preOrder(n.right, r);
    }

    public List<T> postOrder() {
        List<T> r = new ArrayList<>();
        postOrder(root, r);
        return r;
    }
    private void postOrder(NodeAVL<T> n, List<T> r) {
        if (n == null) return;
        postOrder(n.left, r);
        postOrder(n.right, r);
        r.add(n.key);
    }

    // Imprime el árbol en ASCII con factores de equilibrio
    @Override
    public String toString() {
        return buildString(root, "", true);
    }
    private String buildString(NodeAVL<T> n, String pref, boolean tail) {
        if (n == null) return "";
        String s = pref + (tail ? "└── " : "├── ")
                 + n.key + " (h=" + n.height + ", bf=" + balanceFactor(n) + ")\n";
        s += buildString(n.left,  pref + (tail ? "    " : "│   "), false);
        s += buildString(n.right, pref + (tail ? "    " : "│   "), true);
        return s;
    }
}