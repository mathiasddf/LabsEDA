package Lab9.Ej_resueltos.Hash_Cerrado;

public class Element<T> {
    private T value;
    private boolean deleted;

    public Element(T value) {
        this.value = value;
        this.deleted = false;
    }

    public T getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }

    @Override
    public String toString() {
        return deleted ? "X" : value.toString();
    }
}
