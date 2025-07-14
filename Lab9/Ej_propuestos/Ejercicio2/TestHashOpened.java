package Lab9.Ej_propuestos.Ejercicio2;

public class TestHashOpened {
    public static void main(String[] args) {
        HashOpened<String> table = new HashOpened<>(6);

        System.out.println("=== Inserciones ===");
        table.insert(new Register<>(3, "Carlos"));
        table.insert(new Register<>(9, "Laura")); // colisión con 3 si hash = % 6
        table.insert(new Register<>(15, "Miguel")); // colisión con 3 también
        table.insert(new Register<>(10, "Sofía"));
        table.insert(new Register<>(3, "DUPLICADO")); // debe fallar

        table.showTable();

        System.out.println("\n=== Búsquedas ===");
        int[] buscar = {3, 10, 100};
        for (int key : buscar) {
        String valor = table.buscarValor(key);
        if (valor != null) {
            System.out.println(" Clave " + key + " encontrada → Valor: " + valor);
        } else {
            System.out.println(" Clave " + key + " no encontrada");
        }
        }

        System.out.println("\n=== Eliminaciones ===");
        table.delete(9);   // eliminar válido
        table.delete(100); // no existe

        table.showTable();
    }
}
