package Lab7.Ej_Propuestos.Ejercicio3;

public class NodeAVL<T extends Comparable<? super T>> {
    public T              key;
    public NodeAVL<T>     left, right;
    public int            height;

    public NodeAVL(T key) {
        this.key    = key;
        this.height = 1;
    }
}