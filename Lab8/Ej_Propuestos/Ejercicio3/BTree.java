package Lab8.Ej_Propuestos.Ejercicio3;

import java.util.ArrayList;

public class BTree<T extends Comparable<T>> {
    private BNode<T> root;
    private int orden;
    private boolean up;
    private BNode<T> newChild;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void destroy() {
        root = null;
    }

    public void insert(T key) {
        up = false;
        T mediana = push(root, key);
        if (up) {
            BNode<T> newRoot = new BNode<>(orden);
            newRoot.count = 1;
            newRoot.keys.set(0, mediana);
            newRoot.children.set(0, root);
            newRoot.children.set(1, newChild);
            root = newRoot;
        }
    }

    private T push(BNode<T> node, T key) {
        if (node == null) {
            up = true;
            newChild = null;
            return key;
        }
        int[] pos = new int[1];
        if (node.searchKey(key, pos)) {
            System.out.println("Elemento duplicado.");
            up = false;
            return null;
        }
        T mediana = push(node.children.get(pos[0]), key);
        if (up) {
            if (node.isFull(orden)) {
                mediana = divideNode(node, mediana, pos[0]);
            } else {
                insertInNode(node, mediana, newChild, pos[0]);
                up = false;
            }
        }
        return mediana;
    }

    private void insertInNode(BNode<T> node, T key, BNode<T> child, int k) {
        for (int i = node.count - 1; i >= k; i--) {
            node.keys.set(i + 1, node.keys.get(i));
            node.children.set(i + 2, node.children.get(i + 1));
        }
        node.keys.set(k, key);
        node.children.set(k + 1, child);
        node.count++;
    }

    private T divideNode(BNode<T> node, T key, int k) {
        BNode<T> right = newChild;
        int mid = orden / 2;
        BNode<T> newNode = new BNode<>(orden);

        for (int i = mid; i < orden - 1; i++) {
            newNode.keys.set(i - mid, node.keys.get(i));
            newNode.children.set(i - mid + 1, node.children.get(i + 1));
        }

        newNode.count = (orden - 1) - mid;
        node.count = mid;

        if (k <= mid) {
            insertInNode(node, key, right, k);
        } else {
            insertInNode(newNode, key, right, k - mid);
        }

        T median = node.keys.get(node.count - 1);
        newNode.children.set(0, node.children.get(node.count));
        node.count--;
        newChild = newNode;
        return median;
    }

    public String toString() {
        if (isEmpty()) return "Árbol vacío.";
        return writeTree(root, 0);
    }

    private String writeTree(BNode<T> node, int level) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = node.count - 1; i >= 0; i--) {
            sb.append(writeTree(node.children.get(i + 1), level + 1));
            sb.append(" ".repeat(level * 4)).append(node.keys.get(i)).append("\n");
        }
        sb.append(writeTree(node.children.get(0), level + 1));
        return sb.toString();
    }

    public T search(T key) {
        return searchRec(root, key);
    }

    private T searchRec(BNode<T> node, T key) {
        if (node == null) return null;
        int[] pos = new int[1];
        boolean found = node.searchKey(key, pos);
        if (found) return node.keys.get(pos[0]);
        return searchRec(node.children.get(pos[0]), key);
    }

    public T Min() {
        if (isEmpty()) return null;
        BNode<T> current = root;
        while (current.children.get(0) != null) {
            current = current.children.get(0);
        }
        return current.keys.get(0);
    }

    public T Max() {
        if (isEmpty()) return null;
        BNode<T> current = root;
        while (current.children.get(current.count) != null) {
            current = current.children.get(current.count);
        }
        return current.keys.get(current.count - 1);
    }

    private BNode<T> searchWithPath(T x, ArrayList<BNode<T>> path, ArrayList<Integer> indices) {
        BNode<T> current = root;
        while (current != null) {
            int i = 0;
            while (i < current.count && x.compareTo(current.keys.get(i)) > 0) {
                i++;
            }

            path.add(current);
            indices.add(i);

            if (i < current.count && current.keys.get(i).compareTo(x) == 0) {
                return current; // Encontrado
            }
            current = current.children.get(i);
        }
        return null;
    }


    public T Predecesor(T x) {
        ArrayList<BNode<T>> path = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        BNode<T> node = searchWithPath(x, path, indices);
        if (node == null) return null;

        int idx = indices.get(indices.size() - 1);
        BNode<T> child = node.children.get(idx);

        // Caso 1: hay hijo izquierdo → máximo de subárbol izquierdo
        if (child != null) {
            BNode<T> curr = child;
            while (curr.children.get(curr.count) != null) {
                curr = curr.children.get(curr.count);
            }
            return curr.keys.get(curr.count - 1);
        }

        // Caso 2: recorrer hacia arriba buscando menor a izquierda
        for (int i = indices.size() - 2; i >= 0; i--) {
            if (indices.get(i + 1) > 0) {
                return path.get(i).keys.get(indices.get(i + 1) - 1);
            }
        }

        return null; // No tiene predecesor (es el menor)
    }

    public T Sucesor(T x) {
        ArrayList<BNode<T>> path = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        BNode<T> node = searchWithPath(x, path, indices);
        if (node == null) return null;

        int idx = indices.get(indices.size() - 1);
        BNode<T> child = node.children.get(idx + 1);

        // Caso 1: hay hijo derecho → mínimo de subárbol derecho
        if (child != null) {
            BNode<T> curr = child;
            while (curr.children.get(0) != null) {
                curr = curr.children.get(0);
            }
            return curr.keys.get(0);
        }

        // Caso 2: recorrer hacia arriba buscando mayor a derecha
        for (int i = indices.size() - 2; i >= 0; i--) {
            if (indices.get(i + 1) < path.get(i).count) {
                return path.get(i).keys.get(indices.get(i + 1));
            }
        }

        return null; // No tiene sucesor (es el mayor)
    }

    public void remove(T x) {
        if (isEmpty()) {
            System.out.println("Árbol vacío.");
            return;
        }

        removeRecursive(root, x);

        // Si la raíz queda vacía y tiene hijos, se reduce el nivel del árbol
        if (root.count == 0) {
            if (root.children.get(0) != null) {
                root = root.children.get(0);
            } else {
                root = null;
            }
        }
    }

    private boolean removeRecursive(BNode<T> node, T x) {
        int i = 0;
        while (i < node.count && x.compareTo(node.keys.get(i)) > 0) i++;

        // Caso 1: clave encontrada en este nodo
        if (i < node.count && node.keys.get(i).compareTo(x) == 0) {
            if (node.children.get(i) == null) {
                // Caso 1a: nodo hoja
                for (int j = i; j < node.count - 1; j++) {
                    node.keys.set(j, node.keys.get(j + 1));
                }
                node.keys.set(node.count - 1, null);
                node.count--;
            } else {
                // Caso 1b: nodo interno - usar predecesor
                BNode<T> predNode = node.children.get(i);
                while (predNode.children.get(predNode.count) != null) {
                    predNode = predNode.children.get(predNode.count);
                }
                T pred = predNode.keys.get(predNode.count - 1);
                node.keys.set(i, pred);
                removeRecursive(node.children.get(i), pred);
            }
        } else {
            // Caso 2: clave no encontrada en este nodo
            if (node.children.get(i) == null) {
                System.out.println("Clave no encontrada.");
                return false;
            }

            BNode<T> child = node.children.get(i);

            // Si el hijo tiene el mínimo de claves, preparar antes de descender
            if (child.count == (orden - 1) / 2) {
                if (i > 0 && node.children.get(i - 1).count > (orden - 1) / 2) {
                    // Redistribuir desde hermano izquierdo
                    BNode<T> left = node.children.get(i - 1);
                    for (int j = child.count; j > 0; j--) {
                        child.keys.set(j, child.keys.get(j - 1));
                        child.children.set(j + 1, child.children.get(j));
                    }
                    child.children.set(1, child.children.get(0));
                    child.keys.set(0, node.keys.get(i - 1));
                    child.children.set(0, left.children.get(left.count));
                    node.keys.set(i - 1, left.keys.get(left.count - 1));
                    left.keys.set(left.count - 1, null);
                    left.children.set(left.count, null);
                    left.count--;
                    child.count++;
                } else if (i < node.count && node.children.get(i + 1).count > (orden - 1) / 2) {
                    // Redistribuir desde hermano derecho
                    BNode<T> right = node.children.get(i + 1);
                    child.keys.set(child.count, node.keys.get(i));
                    child.children.set(child.count + 1, right.children.get(0));
                    node.keys.set(i, right.keys.get(0));
                    for (int j = 0; j < right.count - 1; j++) {
                        right.keys.set(j, right.keys.get(j + 1));
                        right.children.set(j, right.children.get(j + 1));
                    }
                    right.children.set(right.count - 1, right.children.get(right.count));
                    right.keys.set(right.count - 1, null);
                    right.children.set(right.count, null);
                    right.count--;
                    child.count++;
                } else {
                    // Fusión
                    if (i < node.count) {
                        merge(node, i);
                    } else {
                        merge(node, i - 1);
                        child = node.children.get(i - 1);
                    }
                }
            }
            // Descendemos al hijo actualizado
            removeRecursive(child, x);
        }
        return true;
    }

    private void merge(BNode<T> parent, int idx) {
        BNode<T> left = parent.children.get(idx);
        BNode<T> right = parent.children.get(idx + 1);

        // Traer la clave del padre al centro del nodo izquierdo
        left.keys.set(left.count, parent.keys.get(idx));

        // Mover claves e hijos del derecho al izquierdo
        for (int i = 0; i < right.count; i++) {
            left.keys.set(left.count + 1 + i, right.keys.get(i));
            left.children.set(left.count + 1 + i, right.children.get(i));
        }
        left.children.set(left.count + 1 + right.count, right.children.get(right.count));

        left.count += 1 + right.count;

        // Eliminar clave del padre
        for (int i = idx; i < parent.count - 1; i++) {
            parent.keys.set(i, parent.keys.get(i + 1));
            parent.children.set(i + 1, parent.children.get(i + 2));
        }
        parent.keys.set(parent.count - 1, null);
        parent.children.set(parent.count, null);
        parent.count--;
    }



}

