package Lab2.Ej_resueltos;

public class Ej_resuelto01 {
    public static class Recursividad {
        void repetir() {
        repetir();
        }
        public static void main(String[] ar) {
            Recursividad re = new Recursividad();
            re.repetir();
        }
    }
}
