package Lab9.Ej_resueltos.Hash_Abierto;

public class Element<T> implements Comparable<Element<T>> {
    private int key;
    private T value;
    private boolean deleted;

    public Element(int key, T value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        this.deleted = true;
    }

    @Override
    public int compareTo(Element<T> other) {
        return Integer.compare(this.key, other.key);
    }

    @Override
    public String toString() {
        return (deleted ? "[ELIMINADO] " : "") + key + ":" + value;
    }
}
