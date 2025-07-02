package Lab7.Ej_Resueltos;

public class Node<T> {
    protected T data;
    protected Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
    }
}
