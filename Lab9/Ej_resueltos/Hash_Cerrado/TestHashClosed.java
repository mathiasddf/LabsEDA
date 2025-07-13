package Lab9.Ej_resueltos.Hash_Cerrado;

public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed<Integer> table = new HashClosed<>(11); // tamaño primo

        // Agregar elementos
        System.out.println("=== Inserción de elementos ===");
        int[] toInsert = {100, 5, 14, 15, 22, 16, 17, 32, 13, 32, 100};
        for (int elem : toInsert) {
        table.insert(elem);
        }

        // Mostrar tabla resultante
        System.out.println("\n=== Tabla luego de inserciones ===");
        table.showTable();

        // Buscar elementos
        System.out.println("\n=== Búsqueda de elementos ===");
        int[] toSearch = {32, 200};
        for (int elem : toSearch) {
        System.out.println("Buscar " + elem + ": " + (table.search(elem) ? "✔ Encontrado" : "❌ No encontrado"));
        }

        // Eliminar elementos
        System.out.println("\n=== Eliminación de elementos ===");
        int[] toDelete = {17, 100};
        for (int elem : toDelete) {
        table.delete(elem);
        }

        // Mostrar tabla final
        System.out.println("\n=== Tabla luego de eliminaciones ===");
        table.showTable();

        // Prueba adicional (inserción tras eliminación)
        System.out.println("\n=== Inserción tras eliminaciones (prueba adicional) ===");
        table.insert(77); // debe ocupar una posición eliminada
        table.showTable();
    }
}
