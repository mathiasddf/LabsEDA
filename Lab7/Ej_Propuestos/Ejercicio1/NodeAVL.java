package Lab7.Ej_Propuestos.Ejercicio1;

public class NodeAVL<T extends Comparable<? super T>> {
    T key;
    NodeAVL<T> left, right;
    int height;

    public NodeAVL(T key) {
        this.key = key;
        this.height = 1;
    }
}