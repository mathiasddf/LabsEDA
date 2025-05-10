package Ej_propuestos;
import java.util.*;
public class Ej_propuesto01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int N = scanner.nextInt();
        List<Double> calificaciones = new ArrayList<>();
        System.out.println("Ingrese las calificaciones:");
        for (int i = 0; i < N; i++) {
            System.out.print("Calificación #" + (i+1) + ": ");
            calificaciones.add(scanner.nextDouble());
        }
        Collections.sort(calificaciones);

        // Mediana
        double mediana;
        if (N % 2 == 1) {
            mediana = calificaciones.get(N/2);
        } else {
            mediana = (calificaciones.get(N/2 - 1) + calificaciones.get(N/2)) / 2.0;
        }

        // Moda
        Map<Double, Integer> freq = new HashMap<>();
        for (double nota : calificaciones) {
            freq.put(nota, freq.getOrDefault(nota, 0) + 1);
        }
        int maxFreq = Collections.max(freq.values());
        List<Double> modas = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modas.add(entry.getKey());
            }
        }

        // Desviación estándar (poblacional)
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        double media = suma / N;
        double sumaVar = 0;
        for (double nota : calificaciones) {
            sumaVar += Math.pow(nota - media, 2);
        }
        double desviacion = Math.sqrt(sumaVar / N);

        // Resultados
        System.out.printf("Mediana: %.2f%n", mediana);
        System.out.print("Moda: ");
        for (double m : modas) {
            System.out.printf("%.2f ", m);
        }
        System.out.println();
        System.out.printf("Desviación estándar: %.2f%n", desviacion);
    }
}