import java.util.*;  

public class GFG4 {  
    public static void main(String args[])  {  
        LinkedList<String> ll  
            = new LinkedList<>();  
        ll.add("Uno");  
        ll.add("Dos");  
        ll.add(1, "Tres");  
        // Usando el método Get en el  
        // ciclo for  
        for (int i = 0; i < ll.size(); i++) {  
            System.out.print(ll.get(i) + " ");  
        }  
        System.out.println();  
        // Using the for each loop  
        for (String str : ll)  
            System.out.print(str + " ");  
    }  
}
