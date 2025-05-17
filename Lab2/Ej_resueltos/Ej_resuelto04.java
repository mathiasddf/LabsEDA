package Lab2.Ej_resueltos;

public class Ej_resuelto04 {
    public static class Recursividad {
        void imprimir(int x) {
            if (x > 0) {
                imprimir(x - 1);
                System.out.println(x);
            }
        }
        public static void main(String[] ar) {
            Recursividad re = new Recursividad();
            re.imprimir(5);
        }
    }       

}
