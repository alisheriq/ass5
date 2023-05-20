public class BST <K extends Comparable<K>,V> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = right = null;
        }
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    private Node put(Node current, K key, V val) {
        if (current == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = put(current.left, key, val);
        } else if (cmp > 0) {
            current.right = put(current.right, key, val);
        } else {
            current.val = val;
        }
        return current;
    }
    public V get(K key) {
        Node node = get(root, key);
        return (node == null) ? null : node.val;
    }
    private Node get(Node current, K key) {
        if (current == null || key.equals(current.key)) {
            return current;
        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            return get(current.left, key);
        } else {
            return get(current.right, key);
        }
    }
    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = delete(current.left, key);
        } else if (cmp > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null) {
                size--;
                return current.right;
            } else if (current.right == null) {
                size--;
                return current.left;
            } else {
                Node successor = findMinNode(current.right);
                current.key = successor.key;
                current.val = successor.val;
                current.right = delete(current.right, successor.key);
            }
        }
        return current;
    }

}
