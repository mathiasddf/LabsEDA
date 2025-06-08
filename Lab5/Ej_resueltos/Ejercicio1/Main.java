package Lab5.Ej_resueltos.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        StackList<Integer> stack = new StackList<>();
        // Apilamos los valores 1 a 8
        for (int i = 1; i <= 8; i++) {
            stack.push(i);
        }
        // Mostramos el comportamiento LIFO
        System.out.println("Desapilando elementos de la Pila (LIFO):");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nTamaño final de la pila: " + stack.size());
    }
}

