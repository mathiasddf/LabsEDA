package Lab8.Ej_Propuestos.Ejercicio4;

import java.util.ArrayList;

public class BNode<T extends Comparable<T>> {
    protected ArrayList<T> keys;                // Claves almacenadas
    protected ArrayList<BNode<T>> children;     // Hijos
    protected int count;                        // Número de claves activas

    public BNode(int orden) {
        this.keys = new ArrayList<>(orden);
        this.children = new ArrayList<>(orden + 1);
        this.count = 0;

        // Inicializar con nulls
        for (int i = 0; i < orden; i++) {
            keys.add(null);
        }
        for (int i = 0; i <= orden; i++) {
            children.add(null);
        }
    }

    public boolean isFull(int orden) {
        return count == orden - 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean searchKey(T key, int[] pos) {
        int i = 0;
        while (i < count && keys.get(i).compareTo(key) < 0) {
            i++;
        }
        pos[0] = i;
        return (i < count && keys.get(i).compareTo(key) == 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) sb.append(" | ");
        }
        sb.append("]");
        return sb.toString();
    }
}
