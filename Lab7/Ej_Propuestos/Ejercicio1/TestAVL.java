package Lab7.Ej_Propuestos.Ejercicio1;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        // 1) INSERTAR
        int[] inserts = {100,200,300,400,500,50,25,350,375,360,355,150,175,120,190};
        for (int v : inserts) {
            tree.insert(v);
            System.out.println(tree);
        }

        // Mostrar recorridos del árbol final tras inserción
        System.out.println("\n+++ Recorridos tras inserciones +++");
        System.out.println("InOrder:  " + tree.inOrder());
        System.out.println("PreOrder: " + tree.preOrder());
        System.out.println("PostOrder:" + tree.postOrder());

        // 2) ELIMINAR
        int[] deletes = {100,200,300,400,500,50,25,350,375,360,355,150,175,120,190};
        for (int v : deletes) {
            tree.delete(v);
            System.out.println(tree);
        }

        // Mostrar recorridos del árbol final tras eliminaciones
        System.out.println("\n+++ Recorridos tras eliminaciones +++");
        System.out.println("InOrder:  " + tree.inOrder());
        System.out.println("PreOrder: " + tree.preOrder());
        System.out.println("PostOrder:" + tree.postOrder());
    }
}