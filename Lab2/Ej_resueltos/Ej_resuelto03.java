package Lab2.Ej_resueltos;

public class Ej_resuelto03 {
    public static class Recursividad {
        void imprimir(int x) {
            if (x > 0) {
                System.out.println(x);
                imprimir(x - 1);
            }
        }
        public static void main(String[] ar) {
            Recursividad re = new Recursividad();
            re.imprimir(5);
        }
    }
}
