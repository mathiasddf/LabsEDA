package Lab2.Ej_propuestos;
import java.util.Scanner;

/*Triangulo recursivo 3. El método trianguloRecursivo3 calcula y muestra el resultado.• Si b = 5
• Salida: (tipo triangulo △ , aca no se puede ver muy bien  4)
      *
     * *
    * * *
   * * * *
  * * * * * 
*/

public class Ej_propuesto05 {
    public static void trianguloRecursivo3(int totalLineas, int lineaActual) {
        if (lineaActual > totalLineas) {
            return; // caso base: ya imprimimos todas las líneas
        }
        // imprimir espacios para centrar
        for (int i = 0; i < totalLineas - lineaActual; i++) {
            System.out.print(" ");
        }
        // imprimir asteriscos con espacios entre ellos
        for (int i = 0; i < lineaActual; i++) {
            System.out.print("*");
            if (i < lineaActual - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        trianguloRecursivo3(totalLineas, lineaActual + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de pisos para la pirámide: ");
        int pisos = sc.nextInt();
        trianguloRecursivo3(pisos, 1);
        sc.close();
    }
}
