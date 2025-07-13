package Lab9.Ej_resueltos.Hash_Cerrado;

public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed<Integer> table = new HashClosed<>(11); // tamaño primo para mejor dispersión

        // Agregar los elementos
        int[] elementsToInsert = {100, 5, 14, 15, 22, 16, 17, 32, 13, 32, 100};
        System.out.println("Insertando elementos:");
        for (int elem : elementsToInsert) {
        boolean inserted = table.insert(elem);
        System.out.println("Insertar " + elem + ": " + (inserted ? "✔" : "✖ (duplicado o lleno)"));
        }

        // Mostrar tabla hash resultante
        System.out.println("\nTabla hash después de inserciones:");
        table.showTable();

        // Buscar elementos
        System.out.println("\nBuscando elementos:");
        int[] searchItems = {32, 200};
        for (int item : searchItems) {
        System.out.println("Buscar " + item + ": " + (table.search(item) ? "Encontrado" : "No encontrado"));
        }

        // Eliminar elementos
        System.out.println("\nEliminando elementos:");
        int[] deleteItems = {17, 100};
        for (int item : deleteItems) {
        System.out.println("Eliminar " + item + ": " + (table.delete(item) ? "Eliminado" : "No encontrado"));
        }

        // Mostrar tabla hash final
        System.out.println("\nTabla hash después de eliminaciones:");
        table.showTable();
    }
}
