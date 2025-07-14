package Lab9.Ej_propuestos.Ejercicio1;

public class HashClosed<E> {
    private Register<E>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        table = new Register[capacity];
        size = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % table.length;
    }

    public boolean insert(Register<E> reg) {
        if (size == table.length) {
        System.out.println(" Tabla llena. No se puede insertar: " + reg);
        return false;
        }

        int index = hash(reg.getKey());
        int start = index;

        do {
        Register<E> current = table[index];

        if (current == null || current.isDeleted()) {
            table[index] = reg;
            size++;
            System.out.println(" Insertado: " + reg + " en índice " + index);
            return true;
        }

        if (!current.isDeleted() && current.getKey() == reg.getKey()) {
            System.out.println(" Clave duplicada: " + reg.getKey());
            return false;
        }

        index = (index + 1) % table.length;

        } while (index != start);

        System.out.println(" No se pudo insertar: " + reg);
        return false;
    }

    public Register<E> search(int key) {
        int index = hash(key);
        int start = index;

        do {
        Register<E> current = table[index];

        if (current == null) return null;
        if (!current.isDeleted() && current.getKey() == key) return current;

        index = (index + 1) % table.length;

        } while (index != start);

        return null;
    }

    public boolean delete(int key) {
        int index = hash(key);
        int start = index;

        do {
        Register<E> current = table[index];

        if (current == null) return false;
        if (!current.isDeleted() && current.getKey() == key) {
            current.delete();
            size--;
            System.out.println(" Eliminado lógicamente: " + key);
            return true;
        }

        index = (index + 1) % table.length;

        } while (index != start);

        return false;
    }

    public void showTable() {
        System.out.println("\n--- Tabla Hash Cerrado ---");
        for (int i = 0; i < table.length; i++) {
        System.out.print(i + ": ");
        if (table[i] == null) {
            System.out.println("[VACÍO]");
        } else {
            System.out.println(table[i]);
        }
        }
    }

}
