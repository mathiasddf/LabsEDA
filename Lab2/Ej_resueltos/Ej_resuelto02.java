package Lab2.Ej_resueltos;

public class Ej_resuelto02 {
    public static class Recursividad {
        void imprimir(int x) {
            System.out.println(x);
            imprimir(x - 1);
        }
        public static void main(String[] ar) {
            Recursividad re = new Recursividad();
            re.imprimir(5);
        }
    }
}
