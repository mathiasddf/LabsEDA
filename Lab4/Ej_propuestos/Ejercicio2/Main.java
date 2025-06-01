package Lab4.Ej_propuestos.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        CircleLinkedList<Integer> lista = new CircleLinkedList<>();

        // Insertar los números del 1 al 12
        for (int i = 1; i <= 12; i++) {
            lista.addLast(i);
        }

        // Mostrar tamaño y un ciclo completo
        System.out.println("Tamaño de la lista circular: " + lista.size());
        lista.printOneCycle();

        // Imprimir 15 elementos para ver la circularidad
        lista.printN(15);

        // Ejemplos de métodos genéricos:
        System.out.println("Primer elemento (getFirst): " + lista.getFirst());
        System.out.println("Último elemento (getLast):   " + lista.getLast());
        System.out.println("¿Contiene 5? " + lista.contains(5));
        System.out.println("¿Índice de 7? " + lista.indexOf(7));

        // Remover primero y último
        Integer rem1 = lista.removeFirst();
        System.out.println("\nremoveFirst() elimina: " + rem1);
        Integer rem2 = lista.removeLast();
        System.out.println("removeLast() elimina:  " + rem2);
        lista.printOneCycle();
        System.out.println("Tamaño ahora: " + lista.size());

        // Remover por valor y por índice
        boolean remOK = lista.remove(6);
        System.out.println("\nremove(6) → " + remOK);
        int remAt = lista.removeAt(4); // índice 4 (0-based)
        System.out.println("removeAt(4) → " + remAt);
        lista.printOneCycle();
        System.out.println("Tamaño final: " + lista.size());
    }
}
