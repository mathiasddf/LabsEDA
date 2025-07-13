package Lab9.Ej_resueltos.Hash_Cerrado;

public class HashClosed<E> {
    private Element<E>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        table = (Element<E>[]) new Element[capacity];
        size = 0;
    }

    private int hash(E key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public boolean insert(E key) {
        if (size == table.length) return false;

        int index = hash(key);
        int start = index;

        do {
        Element<E> element = table[index];
        if (element == null || element.isDeleted()) {
            table[index] = new Element<>(key);
            size++;
            return true;
        }
        if (element.getValue().equals(key)) {
            return false;
        }
        index = (index + 1) % table.length;
        } while (index != start);

        return false;
    }

    public boolean search(E key) {
        int index = hash(key);
        int start = index;

        do {
        Element<E> element = table[index];
        if (element == null) return false;
        if (!element.isDeleted() && element.getValue().equals(key)) return true;
        index = (index + 1) % table.length;
        } while (index != start);

        return false;
    }

    public boolean delete(E key) {
        int index = hash(key);
        int start = index;

        do {
        Element<E> element = table[index];
        if (element == null) return false;
        if (!element.isDeleted() && element.getValue().equals(key)) {
            element.markDeleted();
            size--;
            return true;
        }
        index = (index + 1) % table.length;
        } while (index != start);

        return false;
    }

    public void showTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < table.length; i++) {
        System.out.print(i + ": ");
        if (table[i] == null) {
            System.out.println("␣");
        } else {
            System.out.println(table[i]);
        }
        }
    }
}
