package Lab9.Ej_propuestos.Ejercicio1;

public class TestHashClosed {
    public static void main(String[] args) {
        // Crear tabla hash cerrada con capacidad 7
        HashClosed<String> table = new HashClosed<>(7);

        System.out.println("=== Inserciones ===");
        table.insert(new Register<>(5, "Pepe"));
        table.insert(new Register<>(12, "Ana"));  // Puede colisionar con 5 si hash = key % 7
        table.insert(new Register<>(9, "Luis"));
        table.insert(new Register<>(16, "Pedro"));
        table.insert(new Register<>(12, "DUPLICADO")); // No debe insertarse

        table.showTable();

        System.out.println("\n=== Búsqueda ===");

        Register<String> result = table.search(12);
        if (result != null) {
        System.out.println(" Clave 12 encontrada → Valor: " + result.getValue());
        } else {
        System.out.println(" Clave 12 no encontrada");
        }

        result = table.search(100);
        if (result != null) {
        System.out.println(" Clave 100 encontrada → Valor: " + result.getValue());
        } else {
        System.out.println(" Clave 100 no encontrada");
        }

        System.out.println("\n=== Eliminaciones ===");
        table.delete(12);  // Eliminación válida
        table.delete(100); // No existente

        table.showTable();

        System.out.println("\n=== Búsqueda después de eliminar ===");
        result = table.search(12);
        if (result != null) {
        System.out.println(" Clave 12 encontrada → Valor: " + result.getValue());
        } else {
        System.out.println(" Clave 12 no encontrada");
        }
    }
}

