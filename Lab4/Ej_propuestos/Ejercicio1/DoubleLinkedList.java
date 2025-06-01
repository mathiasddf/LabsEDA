package Ejercicios.Ejercicio1;

public class DoubleLinkedList <T> {
   Node<T> head;

   public DoubleLinkedList(){
    this.head = null;
   }

   public void setNext(T data){
    Node<T> newNode = new Node<>(data);
        if (!isEmpty()){
            head = newNode;
        }
        else if(head.nextNode == null){
            head.nextNode = newNode;
            newNode.lastNode = head;
        } else{
            Node<T> current = head.nextNode;
            while (current.nextNode != null)
                current = current.nextNode;
            current.nextNode = newNode;
            newNode.lastNode = current;
        }
   }

   public boolean isEmpty(){
    return head == null;
   }
   
}
