package Ej_propuestos;
import java.util.Arrays;

public class Ej_propuesto03 {
    public static void insertionSort(int[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            int clave = A[i];
            int j = i - 1;
            // Invariante: A[0..i-1] está ordenado
            while (j >= 0 && A[j] > clave) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = clave;
        }
    }
    public static void main(String[] args) {
        int[] A = {7, 2, 4, 6, 1, 3, 5, 8, 10, 9};
        System.out.println("Antes: " + Arrays.toString(A));
        insertionSort(A);
        System.out.println("Después: " + Arrays.toString(A));
    }
}
