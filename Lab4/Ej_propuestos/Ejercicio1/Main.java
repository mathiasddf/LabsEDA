package Lab4.Ej_propuestos.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();

        // Insertar los números del 1 al 10
        for (int i = 1; i <= 10; i++) {
            lista.addLast(i);
        }

        // Mostrar tamaño y recorridos
        System.out.println("Tamaño de la lista: " + lista.size());
        lista.printForward();
        lista.printBackward();
    }
}