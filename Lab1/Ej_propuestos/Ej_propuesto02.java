package Ej_propuestos;
import java.util.Arrays;
import java.util.Scanner;

public class Ej_propuesto02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese límite inferior: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese límite superior: ");
        int b = scanner.nextInt();
        boolean[] esPrimo = new boolean[b+1];
        Arrays.fill(esPrimo, true);
        if (b >= 0) esPrimo[0] = false;
        if (b >= 1) esPrimo[1] = false;
        for (int i = 2; i * i <= b; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= b; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        System.out.println("Números primos entre " + a + " y " + b + ":");
        for (int i = a; i <= b; i++) {
            if (i >= 2 && esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        scanner.close();
    }
}
