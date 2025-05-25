package Lab3.Ej_propuestos.Ej_propuesto01;

/*
Listas, Implementar una Lista usando POO con clases y métodos genéricos siguiendo los estándares de
Java. (Los métodos para una lista)
- Puede ignorar los siguientes métodos:
    ✓ hashCode()
    ✓ iterator()
    ✓ listIterator()
    ✓ listIterator(int index)
    ✓ retainAll(Collection<?> c)
    ✓ toArray()
    ✓ toArray(T[] a)
- Implemente una clase Node<T> donde T es un tipo genérico, esta clase debe contener al menos
dos propiedades:
    ✓ T data: la información almacenada en el nodo Node<T> nextNode: una referencia al siguiente
    nodo
- Implementar una clase List<T> esta clase debe contener al menos esta propiedad
    ✓ Node<T> root: la referencia sobre el nodo inicial 
*/

public class Main {
    public static void main(String[] args) {
        List<String> lista = new List<>();

        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");

        lista.printList();  // Uno -> Dos -> Tres -> null

        System.out.println("Contiene 'Dos'? " + lista.contains("Dos")); // true
        lista.remove(1);
        lista.printList();  // Uno -> Tres -> null

        System.out.println("Elemento en posición 1: " + lista.get(1)); // Tres
        System.out.println("Tamaño: " + lista.size()); // 2
        lista.clear();
        System.out.println("¿Vacía? " + lista.isEmpty()); // true
    }
}
