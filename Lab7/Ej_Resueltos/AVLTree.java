package Lab7.Ej_Resueltos;

public class AVLTree<E extends Comparable<E>> {
    /** Nodo interno con factor de equilibrio. */
    protected class NodeAVL extends Node<E> {
        protected int bf; // balance factor

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private NodeAVL root;
    private boolean height; // flag para cambios de altura

    /** Inserta un elemento, lanzando ItemDuplicated si ya existe. */
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, this.root);
    }

    private NodeAVL insert(E x, NodeAVL node) throws ItemDuplicated {
        if (node == null) {
            this.height = true;
            return new NodeAVL(x);
        }

        int cmp = x.compareTo(node.data);
        if (cmp == 0) {
            throw new ItemDuplicated("El elemento ya existe en el árbol.");
        } else if (cmp < 0) {
            node.left = insert(x, (NodeAVL)node.left);
            if (height) rebalanceAfterInsertLeft(node);
        } else {
            node.right = insert(x, (NodeAVL)node.right);
            if (height) rebalanceAfterInsertRight(node);
        }
        return node;
    }

    private void rebalanceAfterInsertLeft(NodeAVL node) {
        switch (--node.bf) {
            case  0: height = false;               break;
            case -1: height = true;                break;
            case -2: node = balanceToRight(node); height = false; break;
        }
    }

    private void rebalanceAfterInsertRight(NodeAVL node) {
        switch (++node.bf) {
            case  0: height = false;               break;
            case  1: height = true;                break;
            case  2: node = balanceToLeft(node);  height = false; break;
        }
    }

    private NodeAVL balanceToLeft(NodeAVL z) {
        NodeAVL y = (NodeAVL)z.right;
        if (y.bf >= 0) {
            // rotación simple izq
            z.bf = y.bf = 0;
            return rotateSL(z);
        }
        // rotación doble der-izq
        NodeAVL x = (NodeAVL)y.left;
        switch (x.bf) {
            case -1: z.bf = 0; y.bf = 1;  break;
            case  0: z.bf = y.bf = 0;    break;
            case  1: z.bf = -1; y.bf = 0; break;
        }
        x.bf = 0;
        z.right = rotateSR(y);
        return rotateSL(z);
    }

    private NodeAVL balanceToRight(NodeAVL z) {
        NodeAVL y = (NodeAVL)z.left;
        if (y.bf <= 0) {
            // rotación simple der
            z.bf = y.bf = 0;
            return rotateSR(z);
        }
        // rotación doble izq-der
        NodeAVL x = (NodeAVL)y.right;
        switch (x.bf) {
            case  1: z.bf = 0; y.bf = -1; break;
            case  0: z.bf = y.bf = 0;    break;
            case -1: z.bf = 1; y.bf = 0;  break;
        }
        x.bf = 0;
        z.left = rotateSL(y);
        return rotateSR(z);
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL)node.right;
        node.right = p.left;
        p.left = node;
        return p;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL)node.left;
        node.left = p.right;
        p.right = node;
        return p;
    }

    @Override
    public String toString() {
        return buildString(root, "", true);
    }

    private String buildString(NodeAVL n, String pref, boolean tail) {
        if (n == null) return "";
        String s = pref + (tail ? "└── " : "├── ")
                 + n.data + " [bf=" + n.bf + "]\n";
        s += buildString((NodeAVL)n.left,  pref + (tail ? "    " : "│   "), false);
        s += buildString((NodeAVL)n.right, pref + (tail ? "    " : "│   "), true);
        return s;
    }
}
