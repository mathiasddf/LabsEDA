package Lab9.Ej_resueltos.Hash_Abierto;

public class TestHashOpened {
    public static void main(String[] args) {
        HashOpened<String> table = new HashOpened<>(8); // tamaño solicitado

        System.out.println("=== Inserciones ===");
        table.insert(new Element<>(5, "Pepe"));
        table.insert(new Element<>(21, "Jesús"));
        table.insert(new Element<>(19, "Juan"));
        table.insert(new Element<>(16, "María"));
        table.insert(new Element<>(21, "DUPLICADO")); // duplicado, debe fallar

        System.out.println("\n=== Mostrar tabla ===");
        table.showTable();

        System.out.println("\n=== Búsquedas ===");
        int[] buscar = {5, 21};
        for (int key : buscar) {
        Element<String> encontrado = table.search(key);
        if (encontrado != null) {
            System.out.println("Clave " + key + " encontrada: " + encontrado);
        } else {
            System.out.println("Clave " + key + " no encontrada");
        }
        }

        System.out.println("\n=== Eliminaciones ===");
        table.delete(21); // eliminar válido
        table.delete(100); // no existente

        System.out.println("\n=== Tabla después de eliminaciones ===");
        table.showTable();

        // Prueba adicional: insertar después de eliminar
        System.out.println("\n=== Inserción tras eliminación ===");
        table.insert(new Element<>(21, "Nuevo Jesús"));
        table.showTable();
    }
}
