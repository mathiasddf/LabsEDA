package Lab7.Ej_Propuestos.Ejercicio3;

public class TestAVL {
    public static void main(String[] args) throws InterruptedException {
        AVLTree<Integer> tree = new AVLTree<>();

        // Inserción de ejemplo
        int[] valores = {100,200,300,400,500,50,25,350,375,360,355,150,175,120,190};
        for (int v : valores) {
            tree.insert(v);
        }

        // Imprime por consola
        System.out.println("Árbol tras inserciones:");
        System.out.println(tree);

        // Visualiza con GraphStream
        tree.visualize();

        // Pausa para que cierre la ventana antes de terminar el programa
        Thread.sleep(10_000);
        System.exit(0);
    }
}