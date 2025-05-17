package Lab2.Ej_propuestos;
import java.util.Scanner;
/*Invertir vector de enteros, permite ingresar tamaño y captura de valores del arreglo, el método
invertirArray calcula y muestra el resultado.
N = 3
A = [1 2 3] -> Asalida=[3 2 1] */

public class Ej_propuesto01 {

    public static int[] invertirArray(int[] A) {
        int n = A.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = A[i];
            A[i] = A[n - 1 - i];
            A[n - 1 - i] = temp;
        }

        // Mostrar resultado
        System.out.print("Arreglo invertido: ");
        for (int val : A) {
            System.out.print(val + " ");
        }
        System.out.println();

        return A;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese tamaño del arreglo: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.println("Ingrese los valores del arreglo:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.print("Arreglo: ");
        for (int val : A) {
            System.out.print(val + " ");
        }
        System.out.println();

        invertirArray(A);

        sc.close();
    }
}

