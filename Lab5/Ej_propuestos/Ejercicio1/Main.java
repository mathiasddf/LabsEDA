package Lab5.Ej_propuestos.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 1) Apilar los valores del 1 al 10
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        // 2) Mostrar el elemento del tope sin desapilar
        System.out.println("Tope actual (peek): " + stack.peek());
        System.out.println("Tamaño antes de desapilar: " + stack.size());

        // 3) Desapilar todos los elementos
        System.out.println("Desapilando (LIFO):");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nTamaño después: " + stack.size());
    }
}

