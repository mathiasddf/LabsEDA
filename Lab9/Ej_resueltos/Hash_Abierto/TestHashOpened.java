package Lab9.Ej_resueltos.Hash_Abierto;

public class TestHashOpened {
    public static void main(String[] args) {
        // Crear tabla hash de tamaño 8
        HashOpened<String> table = new HashOpened<>(8);

        // Agregar elementos
        System.out.println("=== Inserción de elementos ===");
        table.insert(new Element<>(5, "Pepe"));
        table.insert(new Element<>(21, "Jesús"));
        table.insert(new Element<>(19, "Juan"));
        table.insert(new Element<>(16, "María"));
        table.insert(new Element<>(21, "DUPLICADO")); // Intento duplicado

        // Mostrar tabla actual
        System.out.println("\n=== Tabla hash resultante ===");
        table.showTable();

        // Buscar elementos
        System.out.println("\n=== Búsqueda de claves ===");
        int[] keysToSearch = {5, 21};
        for (int key : keysToSearch) {
        Element<String> result = table.search(key);
        if (result != null) {
            System.out.println("✔ Clave " + key + " encontrada → " + result);
        } else {
            System.out.println("❌ Clave " + key + " no encontrada");
        }
        }

        // Eliminar elementos
        System.out.println("\n=== Eliminación de claves ===");
        int[] keysToDelete = {21, 100};
        for (int key : keysToDelete) {
        table.delete(key);
        }

        // Mostrar tabla final
        System.out.println("\n=== Tabla hash después de eliminaciones ===");
        table.showTable();
    }
}
