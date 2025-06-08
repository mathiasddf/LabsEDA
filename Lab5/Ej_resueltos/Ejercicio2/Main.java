package Lab5.Ej_resueltos.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        QueueList<Integer> queue = new QueueList<>();
        // Encolamos los valores 1 a 8
        for (int i = 1; i <= 8; i++) {
            queue.enqueue(i);
        }
        // Mostramos el comportamiento FIFO
        System.out.println("Atendiendo elementos de la Cola (FIFO):");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("\nTamaño final de la cola: " + queue.size());
    }
}
