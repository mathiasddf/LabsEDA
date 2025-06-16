package Lab6.Ej_propuestos.Ejercicio3;

public class Test {
    public static void main(String[] args) {
        // Configurar UI para GraphStream ANTES de usar el grafo
        System.setProperty("org.graphstream.ui", "swing");

        BST<Integer> arbol = new BST<>();
        
        // Insertar nodos
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        
        // Mostrar el árbol gráficamente
        arbol.graphTree();
    }
}
