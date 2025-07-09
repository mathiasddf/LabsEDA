package Lab8.Ej_Propuestos.Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class BPlusNode<T extends Comparable<T>> {
    public boolean isLeaf;
    public List<T> keys;
    public List<BPlusNode<T>> children; // solo se usa si no es hoja
    public BPlusNode<T> next; // para hojas: puntero al siguiente nodo hoja

    public BPlusNode(boolean isLeaf, int order) {
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = isLeaf ? null : new ArrayList<>();
        this.next = null;
    }

    public boolean isOverflow(int order) {
        return keys.size() > order - 1;
    }

    public boolean isUnderflow(int order) {
        int minKeys = (int) Math.ceil((order - 1) / 2.0);
        return keys.size() < minKeys;
    }

    public int findInsertIndex(T key) {
        int i = 0;
        while (i < keys.size() && key.compareTo(keys.get(i)) > 0) {
            i++;
        }
        return i;
    }

    @Override
    public String toString() {
        String label = "";
        for (int i = 0; i < keys.size(); i++) {
            label += keys.get(i).toString();
            if (i < keys.size() - 1) label += " | ";
        }
        return "[" + label + "]";
    }
}
