package Lab7.Ej_Propuestos.Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 * Árbol AVL genérico con método de visualización usando GraphStream.
 */
public class AVLTree<T extends Comparable<? super T>> {
    private NodeAVL<T> root;

    // --------------- Operaciones básicas ---------------

    public void destroy() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T key) {
        root = insert(root, key);
    }

    private NodeAVL<T> insert(NodeAVL<T> node, T key) {
        if (node == null) {
            return new NodeAVL<>(key);
        }
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) node.left  = insert(node.left,  key);
        else if (cmp > 0) node.right = insert(node.right, key);
        else              return node; // duplicado: ignorar

        updateHeight(node);
        return rebalance(node);
    }

    public void remove(T key) {
        root = remove(root, key);
    }

    private NodeAVL<T> remove(NodeAVL<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) node.left  = remove(node.left,  key);
        else if (cmp > 0) node.right = remove(node.right, key);
        else {
            if (node.left == null)  return node.right;
            if (node.right == null) return node.left;
            NodeAVL<T> succ = minNode(node.right);
            node.key       = succ.key;
            node.right     = remove(node.right, succ.key);
        }
        updateHeight(node);
        return rebalance(node);
    }

    public T search(T key) {
        NodeAVL<T> n = searchNode(root, key);
        return n != null ? n.key : null;
    }

    private NodeAVL<T> searchNode(NodeAVL<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) return searchNode(node.left,  key);
        else if (cmp > 0) return searchNode(node.right, key);
        else              return node;
    }

    public T Min() {
        NodeAVL<T> n = minNode(root);
        return n != null ? n.key : null;
    }

    private NodeAVL<T> minNode(NodeAVL<T> n) {
        while (n != null && n.left != null) n = n.left;
        return n;
    }

    public T Max() {
        NodeAVL<T> n = maxNode(root);
        return n != null ? n.key : null;
    }

    private NodeAVL<T> maxNode(NodeAVL<T> n) {
        while (n != null && n.right != null) n = n.right;
        return n;
    }

    public T Predecesor(T key) {
        NodeAVL<T> p = predecessorNode(root, key);
        return p != null ? p.key : null;
    }

    private NodeAVL<T> predecessorNode(NodeAVL<T> node, T key) {
        NodeAVL<T> target = searchNode(node, key);
        if (target == null) return null;
        if (target.left != null) {
            return maxNode(target.left);
        }
        NodeAVL<T> pred = null, anc = root;
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
        if (target.right != null) {
            return minNode(target.right);
        }
        NodeAVL<T> succ = null, anc = root;
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

    // --------------- Recorridos ---------------

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

    // --------------- Altura y balance ---------------

    private void updateHeight(NodeAVL<T> n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }
    private int height(NodeAVL<T> n) {
        return (n==null) ? 0 : n.height;
    }
    private int balanceFactor(NodeAVL<T> n) {
        return (n==null) ? 0 : height(n.right) - height(n.left);
    }

    // --------------- Rotaciones ---------------

    private NodeAVL<T> rotateLeft(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        x.right = y.left;
        y.left  = x;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private NodeAVL<T> rotateRight(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        y.left  = x.right;
        x.right = y;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private NodeAVL<T> balanceLeft(NodeAVL<T> z) {
        if (balanceFactor(z) > 1) {
            if (balanceFactor(z.right) < 0) {
                z.right = rotateRight(z.right);
            }
            return rotateLeft(z);
        }
        return z;
    }

    private NodeAVL<T> balanceRight(NodeAVL<T> z) {
        if (balanceFactor(z) < -1) {
            if (balanceFactor(z.left) > 0) {
                z.left = rotateLeft(z.left);
            }
            return rotateRight(z);
        }
        return z;
    }

    private NodeAVL<T> rebalance(NodeAVL<T> node) {
        node = balanceLeft(node);
        node = balanceRight(node);
        return node;
    }

    // --------------- Impresión en texto ---------------

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

    // --------------- Visualización con GraphStream ---------------

    /**
     * Muestra una ventana con el árbol gráficado, 
     * con aristas etiquetadas L y R para hijos izq./der.
     */
    public void visualize() {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("AVL");
        graph.setStrict(false);
        graph.setAutoCreate(true);

        addToGraph(root, graph);

        graph.setAttribute("ui.stylesheet",
          "node { fill-color: lightblue; size-mode: fit; padding: 8px; text-alignment: center; text-size: 14; }" +
          "edge { arrow-size: 8px, 6px; }"
        );
        graph.display();
    }

    private void addToGraph(NodeAVL<T> node, Graph graph) {
        if (node == null) return;

        String id = node.key.toString();
        if (graph.getNode(id) == null) {
            org.graphstream.graph.Node gN = graph.addNode(id);
            gN.setAttribute("ui.label", id);
        }

        if (node.left != null) {
            String lid = node.left.key.toString();
            if (graph.getNode(lid) == null) {
                org.graphstream.graph.Node ln = graph.addNode(lid);
                ln.setAttribute("ui.label", lid);
            }
            String eL = id + "_L_" + lid;
            if (graph.getEdge(eL) == null) {
                graph.addEdge(eL, id, lid, true).setAttribute("ui.label", "L");
            }
            addToGraph(node.left, graph);
        }

        if (node.right != null) {
            String rid = node.right.key.toString();
            if (graph.getNode(rid) == null) {
                org.graphstream.graph.Node rn = graph.addNode(rid);
                rn.setAttribute("ui.label", rid);
            }
            String eR = id + "_R_" + rid;
            if (graph.getEdge(eR) == null) {
                graph.addEdge(eR, id, rid, true).setAttribute("ui.label", "R");
            }
            addToGraph(node.right, graph);
        }
    }
}

