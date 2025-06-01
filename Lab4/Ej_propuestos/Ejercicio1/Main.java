package Ejercicios.Ejercicio1;

public class Main {
   public static void main(String[] args) {
       DoubleLinkedList<Integer> numeros= new DoubleLinkedList<>();

       numeros.setNext(1);

       printList(numeros);
   }

   public static void printList(DoubleLinkedList list)  
    {  
        Node currNode = list.head;  
    
        System.out.print("LinkedList: ");  
    
        // Recorre la lista enlazada (LinkedList)  
        while (currNode != null) {  
            // Imprime el dato en el nodo actual  
            System.out.print(currNode.getData() + " ");  
    
            // Va al siguiente nodo  
            currNode = currNode.nextNode;  
        }  
    }  
}
