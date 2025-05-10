package Ej_resueltos;
/* Escribe un programa en Java que permita calcular la suma de los primeros N números
naturales usando un bucle while. El usuario debe ingresar el valor de N.*/

import java.util.Scanner;
public class Ej_resuelto02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de N: ");
        int N = scanner.nextInt();
        int suma = 0;
        int i = 1;
        while (i <= N) {
            suma += i;
            i++;
        }
        System.out.println("La suma de los primeros " + N + " números naturales es: " + suma);
        scanner.close();
    }
}


    




