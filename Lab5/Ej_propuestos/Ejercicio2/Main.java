package Lab5.Ej_propuestos.Ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int CAP = 10;
        Stack<Integer> stack = new Stack<>(CAP);
        Scanner sc = new Scanner(System.in);
        
        // Inicializamos la pila con los elementos 1 al 10
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        System.out.println("Pila inicial cargada con 1 a 10.\n");
        
        int opcion = -1;
        while (opcion != 8) {
            System.out.println("---- MENÚ DE PRUEBA DE MÉTODOS ----");
            System.out.println("1. push (apilar un valor)");
            System.out.println("2. pop (desapilar)");
            System.out.println("3. top (ver tope)");
            System.out.println("4. destroyStack (vaciar pila)");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. printStack");
            System.out.println("8. Salir");
            System.out.print("Seleccione opción [1–8]: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Valor a apilar: ");
                    int v = sc.nextInt();
                    stack.push(v);
                    break;
                case 2:
                    Integer desapilado = stack.pop();
                    if (desapilado != null) {
                        System.out.println("Desapilado: " + desapilado);
                    }
                    break;
                case 3:
                    Integer tope = stack.top();
                    if (tope != null) {
                        System.out.println("Tope actual: " + tope);
                    }
                    break;
                case 4:
                    stack.destroyStack();
                    break;
                case 5:
                    System.out.println("¿Pila vacía? " + stack.isEmpty());
                    break;
                case 6:
                    System.out.println("¿Pila llena? " + stack.isFull() + " (size=" + stack.size() + "/" + stack.capacity() + ")");
                    break;
                case 7:
                    System.out.print("Contenido de la pila: ");
                    stack.printStack();
                    break;
                case 8:
                    System.out.println("Saliendo. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
            System.out.println();
        }
        
        sc.close();
    }
}

