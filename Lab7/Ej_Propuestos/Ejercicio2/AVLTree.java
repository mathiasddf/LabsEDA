package Lab7.Ej_Propuestos.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<? super T>> {
    private NodeAVL<T> root;

    /** Destruye el árbol */
    public void destroy() {
        root = null;
    }

    /** ¿Está vacío? */
    public boolean isEmpty() {
        return root == null;
    }

    /** Inserta una clave */
    public void insert(T key) {
        root = insert(root, key);
    }

    private NodeAVL<T> insert(NodeAVL<T> node, T key) {
        if (node == null) {
            return new NodeAVL<>(key);
        }
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) node.left  = insert(node.left, key);
        else if (cmp > 0) node.right = insert(node.right, key);
        else               return node; // duplicado: no lo insertamos

        actualizarAltura(node);
        return rebalancear(node);
    }

    /** Elimina una clave */
    public void remove(T key) {
        root = remove(root, key);
    }

    private NodeAVL<T> remove(NodeAVL<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) node.left  = remove(node.left, key);
        else if (cmp > 0) node.right = remove(node.right, key);
        else {
            // este es el nodo a borrar
            if (node.left == null)  return node.right;
            if (node.right == null) return node.left;
            // dos hijos: tomar sucesor
            NodeAVL<T> succ = minNode(node.right);
            node.key  = succ.key;
            node.right = remove(node.right, succ.key);
        }
        actualizarAltura(node);
        return rebalancear(node);
    }

    /** Busca y devuelve la clave, o null si no existe */
    public T search(T key) {
        NodeAVL<T> n = searchNode(root, key);
        return n != null ? n.key : null;
    }

    private NodeAVL<T> searchNode(NodeAVL<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) return searchNode(node.left, key);
        else if (cmp > 0) return searchNode(node.right, key);
        else              return node;
    }

    /** Mínimo y máximo */
    public T Min() {
        NodeAVL<T> n = minNode(root);
        return n != null ? n.key : null;
    }

    private NodeAVL<T> minNode(NodeAVL<T> node) {
        if (node == null) return null;
        while (node.left != null) node = node.left;
        return node;
    }

    public T Max() {
        NodeAVL<T> n = maxNode(root);
        return n != null ? n.key : null;
    }

    private NodeAVL<T> maxNode(NodeAVL<T> node) {
        if (node == null) return null;
        while (node.right != null) node = node.right;
        return node;
    }

    /** Predecesor y sucesor */
    public T Predecesor(T key) {
        NodeAVL<T> p = predecessorNode(root, key);
        return p != null ? p.key : null;
    }

    private NodeAVL<T> predecessorNode(NodeAVL<T> node, T key) {
        // buscamos el nodo
        NodeAVL<T> target = searchNode(node, key);
        if (target == null) return null;
        // caso con subárbol izquierdo
        if (target.left != null) return maxNode(target.left);
        // caso sin sub-izq: buscamos ancestro más cercano
        NodeAVL<T> pred = null;
        NodeAVL<T> anc  = root;
        while (anc != null) {
            int cmp = key.compareTo(anc.key);
            if (cmp > 0) {
                pred = anc;
                anc  = anc.right;
            } else if (cmp < 0) {
                anc = anc.left;
            } else break;
        }
        return pred;
    }

    public T Sucesor(T key) {
        NodeAVL<T> s = successorNode(root, key);
        return s != null ? s.key : null;
    }

    private NodeAVL<T> successorNode(NodeAVL<T> node, T key) {
        NodeAVL<T> target = searchNode(node, key);
        if (target == null) return null;
        if (target.right != null) return minNode(target.right);

        NodeAVL<T> succ = null;
        NodeAVL<T> anc  = root;
        while (anc != null) {
            int cmp = key.compareTo(anc.key);
            if (cmp < 0) {
                succ = anc;
                anc  = anc.left;
            } else if (cmp > 0) {
                anc = anc.right;
            } else break;
        }
        return succ;
    }

    /** Recorridos */
    public List<T> InOrder() {
        List<T> r = new ArrayList<>();
        inOrder(root, r);
        return r;
    }
    private void inOrder(NodeAVL<T> n, List<T> r) {
        if (n==null) return;
        inOrder(n.left, r);
        r.add(n.key);
        inOrder(n.right, r);
    }

    public List<T> PreOrder() {
        List<T> r = new ArrayList<>();
        preOrder(root, r);
        return r;
    }
    private void preOrder(NodeAVL<T> n, List<T> r) {
        if (n==null) return;
        r.add(n.key);
        preOrder(n.left, r);
        preOrder(n.right, r);
    }

    public List<T> PostOrder() {
        List<T> r = new ArrayList<>();
        postOrder(root, r);
        return r;
    }
    private void postOrder(NodeAVL<T> n, List<T> r) {
        if (n==null) return;
        postOrder(n.left, r);
        postOrder(n.right, r);
        r.add(n.key);
    }

    /** Altura y factor de balance */
    private void actualizarAltura(NodeAVL<T> n) {
        n.height = 1 + Math.max(altura(n.left), altura(n.right));
    }
    private int altura(NodeAVL<T> n) {
        return n == null ? 0 : n.height;
    }
    private int factorBalance(NodeAVL<T> n) {
        return (n==null) ? 0 : altura(n.right) - altura(n.left);
    }

    /** Rotaciones simples */
    private NodeAVL<T> rotacionSimpleIzquierda(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        x.right = y.left;
        y.left  = x;
        actualizarAltura(x);
        actualizarAltura(y);
        return y;
    }

    private NodeAVL<T> rotacionSimpleDerecha(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        y.left  = x.right;
        x.right = y;
        actualizarAltura(y);
        actualizarAltura(x);
        return x;
    }

    /** Balanceos */
    private NodeAVL<T> balancearIzquierda(NodeAVL<T> z) {
        if (factorBalance(z) > 1) {
            if (factorBalance(z.right) < 0) {
                z.right = rotacionSimpleDerecha(z.right);
            }
            return rotacionSimpleIzquierda(z);
        }
        return z;
    }

    private NodeAVL<T> balancearDerecha(NodeAVL<T> z) {
        if (factorBalance(z) < -1) {
            if (factorBalance(z.left) > 0) {
                z.left = rotacionSimpleIzquierda(z.left);
            }
            return rotacionSimpleDerecha(z);
        }
        return z;
    }

    /** Aplica ambos balanceos tras inserción/borrado */
    private NodeAVL<T> rebalancear(NodeAVL<T> n) {
        n = balancearIzquierda(n);
        n = balancearDerecha(n);
        return n;
    }

    /** Para depurar: imprime el árbol con alturas y bf */
    @Override
    public String toString() {
        return buildString(root, "", true);
    }
    private String buildString(NodeAVL<T> n, String pref, boolean tail) {
        if (n == null) return "";
        String s = pref
            + (tail ? "└── " : "├── ")
            + n.key + " (h=" + n.height + ", bf=" + factorBalance(n) + ")\n";
        s += buildString(n.left,  pref + (tail ? "    " : "│   "), false);
        s += buildString(n.right, pref + (tail ? "    " : "│   "), true);
        return s;
    }
}
