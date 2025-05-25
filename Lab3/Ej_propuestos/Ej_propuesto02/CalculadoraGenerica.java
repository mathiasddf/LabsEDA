package Lab3.Ej_propuestos.Ej_propuesto02;

public class CalculadoraGenerica {
    
    public static <T extends Number> double suma(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number> double resta(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number> double producto(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number> double division(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("División por cero");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number> double potencia(T a, T b) {
        return Math.pow(a.doubleValue(), b.doubleValue());
    }

    public static <T extends Number> double raizCuadrada(T a) {
        return Math.sqrt(a.doubleValue());
    }

    public static <T extends Number> double raizCubica(T a) {
        return Math.cbrt(a.doubleValue());
    }
}
    