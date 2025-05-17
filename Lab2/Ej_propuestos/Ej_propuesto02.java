package Lab2.Ej_propuestos;
import java.util.Scanner;

/*Rotar a la Izquierda, permite ingresar tamaño y captura de valores del arreglo, el método
rotarIzquierdaArray calcula y muestra el resultado.
Si d=2
A=[1 2 3 4 5] -> Ainvertido=[3 4 5 1 2] */

public class Ej_propuesto02 {
    public static int[] rotarIzquierdaArray(int[] A, int d) {
        int n = A.length;
        d = d % n; // normalizar d
        int[] Ainvertido = new int[n];

        for (int i = 0; i < n - d; i++) {
            Ainvertido[i] = A[i + d];
        }
        for (int i = n - d; i < n; i++) {
            Ainvertido[i] = A[i - (n - d)];
        }
        // Mostrar resultado
        System.out.print("Arreglo rotado a la izquierda: ");
        for (int val : Ainvertido) {
            System.out.print(val + " ");
        }
        System.out.println();
        return Ainvertido;
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

        System.out.print("Ingrese número de posiciones a rotar (d): ");
        int d = sc.nextInt();

        rotarIzquierdaArray(A, d);

        sc.close();
    }
}

