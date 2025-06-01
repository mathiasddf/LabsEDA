package Ej_propuestos.Ejercicio1;

public class Node <T> {
    Node<T> nextNode;
    Node<T> lastNode;
    private T data;

    public Node(T data){
        this.data=data;
        this.nextNode=null;
        this.lastNode=null;
    }

    public T getData(){
        return this.data;
    }
}
