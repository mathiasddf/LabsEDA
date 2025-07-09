package Lab8.Ej_Resueltos;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    public BNode(int n) {
        this.keys = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n + 1);
        this.count = 0;
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
        }
        for (int i = 0; i < n + 1; i++) {
            this.childs.add(null);
        }
    }

    // Verifica si el nodo está lleno
    public boolean nodeFull(int n) {
        return count == n;
    }

    // Verifica si el nodo está vacío
    public boolean nodeEmpty() {
        return count == 0;
    }

    // Busca una clave dentro del nodo y retorna si existe, junto con su posición
    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < count && keys.get(i).compareTo(key) < 0) {
            i++;
        }

        pos[0] = i;
        if (i < count && keys.get(i).compareTo(key) == 0) {
            return true; // encontrada
        }
        return false; // no encontrada, pero pos indica dónde seguir
    }

    // Representación en texto del nodo
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Método auxiliar para insertar claves directamente (solo demostración)
    public void insertKey(E key) {
        int i = count - 1;
        while (i >= 0 && keys.get(i) != null && keys.get(i).compareTo(key) > 0) {
            if (i + 1 < keys.size()) {
                keys.set(i + 1, keys.get(i));
            }
            i--;
        }
        keys.set(i + 1, key);
        count++;
    }
}

