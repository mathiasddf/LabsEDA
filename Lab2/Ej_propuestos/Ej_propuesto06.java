package Lab2.Ej_propuestos;
import java.util.Scanner;

/*Cuadrado recursivo. El método cuadradoRecursivo calcula y muestra el resultado.
• Si b = 5
• Salida:
 *****
 *   *
 *   *
 *   *
 ***** 
*/

public class Ej_propuesto06 {
    public static void cuadradoRecursivo(int base, int lineaActual) {
        if (lineaActual > base) {
            return; // caso base: terminamos
        }
        if (lineaActual == 1 || lineaActual == base) {
            // línea llena de asteriscos
            for (int i = 0; i < base; i++) {
                System.out.print("*");
            }
        } else {
            // línea intermedia: asterisco + espacios + asterisco
            System.out.print("*");
            for (int i = 0; i < base - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
        }
        System.out.println();
        cuadradoRecursivo(base, lineaActual + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la base del cuadrado: ");
        int base = sc.nextInt();
        cuadradoRecursivo(base, 1);
        sc.close();
    }
}
