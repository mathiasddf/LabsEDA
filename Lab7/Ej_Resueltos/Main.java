package Lab7.Ej_Resueltos;
public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        try {
            int[] valores = {10, 20, 5, 4, 15, 25};
            for (int v : valores) {
                tree.insert(v);
            }
            System.out.println(tree);
        } catch (ItemDuplicated e) {
            System.err.println(e.getMessage());
        }
    }
}
