package Lab2.Ej_propuestos;
import java.util.Scanner;
/*Triangulo recursivo 1. El método trianguloRecursivo1 calcula y muestra el resultado.
• Si b = 5
• Salida:
 *
 **
 ***
 ****
 ***** 
*/  

public class Ej_propuesto03 {
    public static void trianguloRecursivo1(int base) {
        if (base > 0) {
            trianguloRecursivo1(base - 1); // llamada recursiva
            for (int i = 0; i < base; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indicar numero de pisos del grafico (base): ");
        int base = sc.nextInt();
        trianguloRecursivo1(base);
        sc.close();
    }
}
