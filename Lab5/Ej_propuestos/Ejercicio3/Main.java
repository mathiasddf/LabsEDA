package Lab5.Ej_propuestos.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();

        // 1) Llenar la cola con 1 al 10
        for (int i = 1; i <= 10; i++) {
            q.enqueue(i);
        }

        // 2) Mostrar el elemento del frente usando Metodo()
        System.out.println("Frente (Metodo): " + q.Metodo());

        // 3) Desencolar y mostrar todos los elementos
        System.out.print("Desencolando todos los elementos: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(q.dequeue() + " ");
        }
        System.out.println();
    }
}

