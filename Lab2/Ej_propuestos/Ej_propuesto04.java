package Lab2.Ej_propuestos;
import java.util.Scanner;
/*Triangulo recursivo 2. El método trianguloRecursivo2 calcula y muestra el resultado.
• Si b = 5
• Salida:
     *
    **
   ***
  ****
 *****
*/

public class Ej_propuesto04 {
    public static void trianguloRecursivo2(int base, int actual) {
        if (actual > base) return;
        // Imprimir espacios
        for (int i = 0; i < base - actual; i++) {
            System.out.print(" ");
        }
        // Imprimir asteriscos
        for (int i = 0; i < actual; i++) {
            System.out.print("*");
        }
        System.out.println();
        trianguloRecursivo2(base, actual + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indicar numero de pisos del grafico (base): ");
        int base = sc.nextInt();
        trianguloRecursivo2(base, 1);
        sc.close();
    }
}
