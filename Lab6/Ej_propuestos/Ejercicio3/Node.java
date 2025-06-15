package Lab6.Ej_propuestos.Ejercicio3;

public class Node<T> {
    T data;
    Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
