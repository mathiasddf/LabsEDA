import java.util.*; 

public class GFG3 { 
    public static void main(String args[]) { 
        LinkedList<String> ll = new LinkedList<>(); 
        ll.add("Uno"); 
        ll.add("Dos"); 
        ll.add(1, "Tres"); 
        System.out.println("Initial LinkedList " + ll); 
        ll.set(1, "Cuatro"); 
        System.out.println("Updated LinkedList " + ll); 
    } 
} 
