package Lab3.Ej_propuestos.Ej_propuesto02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir del Programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Ingrese el primer número: ");
                double n1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double n2 = scanner.nextDouble();

                Operador<Double> op = new Operador<>(n1, n2);

                try {
                    switch (opcion) {
                        case 1:
                            System.out.println("Resultado: " + CalculadoraGenerica.suma(op.getValor1(), op.getValor2()));
                            break;
                        case 2:
                            System.out.println("Resultado: " + CalculadoraGenerica.resta(op.getValor1(), op.getValor2()));
                            break;
                        case 3:
                            System.out.println("Resultado: " + CalculadoraGenerica.producto(op.getValor1(), op.getValor2()));
                            break;
                        case 4:
                            System.out.println("Resultado: " + CalculadoraGenerica.division(op.getValor1(), op.getValor2()));
                            break;
                        case 5:
                            System.out.println("Resultado: " + CalculadoraGenerica.potencia(op.getValor1(), op.getValor2()));
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (opcion == 6 || opcion == 7) {
                System.out.print("Ingrese el número: ");
                double n = scanner.nextDouble();
                Operador<Double> op = new Operador<>(n, 0.0);

                if (opcion == 6) {
                    System.out.println("Resultado: " + CalculadoraGenerica.raizCuadrada(op.getValor1()));
                } else {
                    System.out.println("Resultado: " + CalculadoraGenerica.raizCubica(op.getValor1()));
                }

            } else if (opcion != 8) {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 8);

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
