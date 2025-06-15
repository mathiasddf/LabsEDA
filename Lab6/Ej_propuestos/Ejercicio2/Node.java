package Lab6.Ej_propuestos.Ejercicio2;

public class Node<T> {
    T data;
    Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
