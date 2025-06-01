//Un programa java para implementar una simple lista enlazada
public class LinkedList1 {  
    Node head; // cabecera de la lista  
    // Nodo de lista enlazada.  
    // Esta clase interna se hace estática 
    // para que main() pueda acceder a ella  
    static class Node {  
        int data;  
        Node next;  
        // Constructor  
        Node(int d){  
            data = d;  
            next = null;  
        }  
    }  

    // Método para insertar un nuevo nodo  
    public static LinkedList1 insert(LinkedList1 list, int data) {  
        // Crea un nuevo nodo con los datos dados  
        Node new_node = new Node(data);  
        // Si la lista enlazada está vacía,  
        // entonces convierte el nuevo nodo en la cabeza 
        if (list.head == null) {  
            list.head = new_node;  
        } else {  
            // De lo contrario recorra hasta el último nodo  
            // e inserte el nuevo nodo alli  
            Node last = list.head;  
            while (last.next != null) {  
                last = last.next;  
            }  
            // Inserta el nuevo nodo al último nodo  
            last.next = new_node;  
        }  
        // Retorna la lista desde la cabez
        return list;  
    }  

    // Metodo para imprimir la lista enlazada LinkedList.  
    public static void printList(LinkedList1 list) {  
        Node currNode = list.head;  
        System.out.print("LinkedList: ");  
        // Recorre la lista enlazada (LinkedList)  
        while (currNode != null) {  
            // Imprime el dato en el nodo actual  
            System.out.print(currNode.data + " ");  
            // Va al siguiente nodo  
            currNode = currNode.next;  
        }  
    }  
    
    // Código principal 
    public static void main(String[] args) {  
        /* Inicia con una lista vacia. */ 
        LinkedList1 list = new LinkedList1();  
        //  
        // ******INSERCIÓN******  
        //  
        // Inserta los valores 
        list = insert(list, 1);  
        list = insert(list, 2);  
        list = insert(list, 3);  
        list = insert(list, 4);  
        list = insert(list, 5);  
        list = insert(list, 6);  
        list = insert(list, 7);  
        list = insert(list, 8);  
        // Imprime la LinkedList  
        printList(list);  
    }  
}        