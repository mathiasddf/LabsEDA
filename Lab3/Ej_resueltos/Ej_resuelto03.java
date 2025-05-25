package Lab3.Ej_resueltos;
import java.util.ArrayList;
import java.util.List;

class Animal {
        String nombre;
        boolean genero;

        // Constructor
        public Animal(String nombre, boolean genero) {
            super();
            this.nombre = nombre;
            this.genero = genero;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public boolean isGenero() {
            return genero;
        }

        public void setGenero(boolean genero) {
            this.genero = genero;
        }
}

public class Ej_resuelto03 {
    public static void main(String[] args) {
        ArrayList<Animal> mascotas = new ArrayList<Animal>();
        List<Animal> mascotas2 = new ArrayList<Animal>();
        // List<Animal> mascotas3 = new List<Animal>(); // <-- Esto generaría error (no se puede instanciar una interfaz directamente)

        // Agregamos animales a las listas
        mascotas.add(new Animal("Firulais", true));
        mascotas2.add(new Animal("Mishi", false));

        // Mostrar contenido de mascotas
        System.out.println("Lista mascotas:");
        for (Animal a : mascotas) {
            System.out.println("Nombre: " + a.getNombre() + ", Género: " + (a.isGenero() ? "Macho" : "Hembra"));
        }

        System.out.println("\nLista mascotas2:");
        for (Animal a : mascotas2) {
            System.out.println("Nombre: " + a.getNombre() + ", Género: " + (a.isGenero() ? "Macho" : "Hembra"));
        }
    }
}


