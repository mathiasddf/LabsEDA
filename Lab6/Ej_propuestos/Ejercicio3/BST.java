package Lab6.Ej_propuestos.Ejercicio3;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

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

    public void graphTree() {
    // Agregar esta línea para indicar que usarás la UI Swing de GraphStream
    System.setProperty("org.graphstream.ui", "swing");

    Graph graph = new SingleGraph("Árbol BST");
    graph.setStrict(false);
    graph.setAutoCreate(true);
    graph.setAttribute("ui.stylesheet", "node { fill-color: lightblue; text-size: 18px; }");
    graph.display();

    if (root != null)
        buildGraph(graph, root, null);
}


    private void buildGraph(Graph graph, Node<T> current, Node<T> parent) {
        String currId = current.data.toString();
        graph.addNode(currId).setAttribute("ui.label", currId);

        if (parent != null) {
            String parentId = parent.data.toString();
            String edgeId = parentId + "-" + currId;
            graph.addEdge(edgeId, parentId, currId, true); // true = directed
        }

        if (current.left != null)
            buildGraph(graph, current.left, current);
        if (current.right != null)
            buildGraph(graph, current.right, current);
    }
}
