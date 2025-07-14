package Lab9.Ej_propuestos.Ejercicio2;

import java.util.LinkedList;

public class HashOpened<E> {
    private LinkedList<Register<E>>[] table;

    @SuppressWarnings("unchecked")
    public HashOpened(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
        table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return Math.abs(key) % table.length;
    }

    public boolean insert(Register<E> reg) {
        int index = hash(reg.getKey());

        for (Register<E> r : table[index]) {
        if (r.getKey() == reg.getKey() && !r.isDeleted()) {
            System.out.println(" Clave duplicada: " + reg.getKey());
            return false;
        }
        }

        table[index].add(reg);
        System.out.println(" Insertado: " + reg + " en índice " + index);
        return true;
    }

    public boolean delete(int key) {
        int index = hash(key);

        for (Register<E> r : table[index]) {
        if (r.getKey() == key && !r.isDeleted()) {
            r.delete();
            System.out.println(" Eliminado lógicamente: " + key);
            return true;
        }
        }

        System.out.println(" Clave no encontrada: " + key);
        return false;
    }

    public Register<E> search(int key) {
        int index = hash(key);

        for (Register<E> r : table[index]) {
        if (r.getKey() == key && !r.isDeleted()) {
            return r;
        }
        }

        return null;
    }

    // Método genérico solicitado
    public E buscarValor(int key) {
        Register<E> result = search(key);
        return result != null ? result.getValue() : null;
    }

    public void showTable() {
        System.out.println("\n--- Tabla Hash Abierto ---");
        for (int i = 0; i < table.length; i++) {
        System.out.print(i + ": ");
        if (table[i].isEmpty()) {
            System.out.println("[VACÍO]");
        } else {
            for (Register<E> r : table[i]) {
            System.out.print(r + " -> ");
            }
            System.out.println("null");
        }
        }
    }
}
