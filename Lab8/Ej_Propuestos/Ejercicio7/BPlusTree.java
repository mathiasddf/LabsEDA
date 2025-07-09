package Lab8.Ej_Propuestos.Ejercicio7;

public class BPlusTree<T extends Comparable<T>> {
    private int order;
    private BPlusNode<T> root;

    public BPlusTree(int order) {
        this.order = order;
        this.root = new BPlusNode<>(true, order);
    }

    public void destroy() {
        root = new BPlusNode<>(true, order);
    }

    public boolean isEmpty() {
        return root == null || root.keys.isEmpty();
    }

    public T search(T key) {
        BPlusNode<T> node = root;
        while (!node.isLeaf) {
            int i = node.findInsertIndex(key);
            node = node.children.get(i);
        }
        for (T k : node.keys) {
            if (k.compareTo(key) == 0) return k;
        }
        return null;
    }

    public void insert(T key) {
        BPlusNode<T> newChild = insertRecursive(root, key);
        if (newChild != null) {
            BPlusNode<T> newRoot = new BPlusNode<>(false, order);
            newRoot.keys.add(newChild.keys.get(0));
            newRoot.children.add(root);
            newRoot.children.add(newChild);
            root = newRoot;
        }
    }

    private BPlusNode<T> insertRecursive(BPlusNode<T> node, T key) {
        if (node.isLeaf) {
            int idx = node.findInsertIndex(key);
            node.keys.add(idx, key);
            if (node.isOverflow(order)) return splitLeaf(node);
            return null;
        } else {
            int idx = node.findInsertIndex(key);
            BPlusNode<T> child = node.children.get(idx);
            BPlusNode<T> newChild = insertRecursive(child, key);
            if (newChild != null) {
                T promoted = newChild.keys.get(0);
                int insertIdx = node.findInsertIndex(promoted);
                node.keys.add(insertIdx, promoted);
                node.children.add(insertIdx + 1, newChild);
                if (node.isOverflow(order)) return splitInternal(node);
            }
            return null;
        }
    }

    private BPlusNode<T> splitLeaf(BPlusNode<T> leaf) {
        int mid = (order + 1) / 2;
        BPlusNode<T> newLeaf = new BPlusNode<>(true, order);
        newLeaf.keys.addAll(leaf.keys.subList(mid, leaf.keys.size()));
        leaf.keys.subList(mid, leaf.keys.size()).clear();
        newLeaf.next = leaf.next;
        leaf.next = newLeaf;
        return newLeaf;
    }

    private BPlusNode<T> splitInternal(BPlusNode<T> node) {
        int mid = order / 2;
        T midKey = node.keys.get(mid);
        BPlusNode<T> newNode = new BPlusNode<>(false, order);
        newNode.keys.addAll(node.keys.subList(mid + 1, node.keys.size()));
        newNode.children.addAll(node.children.subList(mid + 1, node.children.size()));
        node.keys.subList(mid, node.keys.size()).clear();
        node.children.subList(mid + 1, node.children.size()).clear();
        newNode.keys.add(0, midKey);
        return newNode;
    }

    public T Min() {
        BPlusNode<T> node = root;
        while (!node.isLeaf) node = node.children.get(0);
        return node.keys.get(0);
    }

    public T Max() {
        BPlusNode<T> node = root;
        while (!node.isLeaf) node = node.children.get(node.children.size() - 1);
        return node.keys.get(node.keys.size() - 1);
    }

    public T Predecesor(T key) {
        BPlusNode<T> node = root;
        T prev = null;
        while (!node.isLeaf) {
            int i = node.findInsertIndex(key);
            node = node.children.get(i);
        }
        for (T k : node.keys) {
            if (k.compareTo(key) >= 0) break;
            prev = k;
        }
        return prev;
    }

    public T Sucesor(T key) {
        BPlusNode<T> node = root;
        boolean found = false;
        while (!node.isLeaf) {
            int i = node.findInsertIndex(key);
            node = node.children.get(i);
        }
        for (T k : node.keys) {
            if (found) return k;
            if (k.compareTo(key) == 0) found = true;
        }
        return (node.next != null && !node.next.keys.isEmpty()) ? node.next.keys.get(0) : null;
    }

    public String toString() {
        return writeTree(root, 0);
    }

    public String writeTree(BPlusNode<T> node, int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(level)).append(node).append("\n");
        if (!node.isLeaf) {
            for (BPlusNode<T> child : node.children) {
                sb.append(writeTree(child, level + 1));
            }
        }
        return sb.toString();
    }

    public void FuzeNode(BPlusNode<T> left, BPlusNode<T> right, T parentKey) {
        left.keys.add(parentKey);
        left.keys.addAll(right.keys);
        if (!left.isLeaf) {
            left.children.addAll(right.children);
        } else {
            left.next = right.next;
        }
    }
}
