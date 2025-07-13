package Lab9.Ej_resueltos.Hash_Abierto;

import java.util.LinkedList;

public class HashOpened<E> {
    private LinkedList<Element<E>>[] table;

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

    public void insert(Element<E> elem) {
        int index = hash(elem.getKey());

        for (Element<E> e : table[index]) {
        if (e.getKey() == elem.getKey() && !e.isDeleted()) {
            System.out.println("❌ Clave duplicada: " + elem.getKey());
            return;
        }
        }

        table[index].add(elem);
        System.out.println("✔ Insertado: " + elem);
    }

    public void delete(int key) {
        int index = hash(key);

        for (Element<E> e : table[index]) {
        if (e.getKey() == key && !e.isDeleted()) {
            e.delete();
            System.out.println("✔ Eliminado lógicamente: " + key);
            return;
        }
        }

        System.out.println("❌ Clave no encontrada: " + key);
    }

    public Element<E> search(int key) {
        int index = hash(key);

        for (Element<E> e : table[index]) {
        if (e.getKey() == key && !e.isDeleted()) {
            return e;
        }
        }

        return null;
    }

    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Abierto) ---");
        for (int i = 0; i < table.length; i++) {
        System.out.print(i + ": ");
        if (table[i].isEmpty()) {
            System.out.println("[VACÍO]");
        } else {
            for (Element<E> e : table[i]) {
            System.out.print(e + " -> ");
            }
            System.out.println("null");
        }
        }
    }
}
