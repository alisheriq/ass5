import java.util.ArrayList;
import java.util.List;
public class BST <K extends Comparable<K>,V> {
    private Node root; // Root node of the binary search tree
    private int size;  // Number of nodes in the binary search tree

    private class Node {
        private K key; // Key of the node
        private V val; // Value associated with the key
        private Node left, right; // Left and right child nodes

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = right = null;
        }
    }
    /**
     * Inserts a key-value pair into the binary search tree.
     *
     * @param key The key to be inserted
     * @param val The value associated with the key
     */
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    /**
     * Recursive method to insert a key-value pair into the binary search tree.
     *
     * @param current The current node being compared
     * @param key     The key to be inserted
     * @param val     The value associated with the key
     * @return The updated node structure
     */
    private Node put(Node current, K key, V val) {
        if (current == null) {
            size++;
            return new Node(key, val); // Create a new node if the current node is null
        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = put(current.left, key, val); // Recursively insert into the left subtree
        } else if (cmp > 0) {
            current.right = put(current.right, key, val); // Recursively insert into the right subtree
        } else {
            current.val = val; // Update the value if the key already exists
        }
        return current;
    }
    /**
     * Retrieves the value associated with a given key from the binary search tree.
     *
     * @param key The key to be searched for
     * @return The value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        Node node = get(root, key);
        return (node == null) ? null : node.val;
    }
    /**
     * Recursive method to search for a key in the binary search tree.
     *
     * @param current The current node being compared
     * @param key     The key to be searched for
     * @return The node containing the key, or null if the key is not found
     */
    private Node get(Node current, K key) {
        if (current == null || key.equals(current.key)) {
            return current; // Return the node if the current node is null or the keys match
        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            return get(current.left, key); // Recursively search in the left subtree
        } else {
            return get(current.right, key); // Recursively search in the right subtree
        }
    }
    /**
     * Deletes a key and its associated value from the binary search tree.
     *
     * @param key The key to be deleted
     */
    public void delete(K key) {
        root = delete(root, key);
    }
    /**
     * Recursive method to delete a key from the binary search tree.
     *
     * @param current The current node being compared
     * @param key     The key to be deleted
     * @return The updated node structure
     */
    private Node delete(Node current, K key) {
        if (current == null) {
            return null; // Return null if the key is not found

        }

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = delete(current.left, key); // Recursively delete from the left subtree
        } else if (cmp > 0) {
            current.right = delete(current.right, key); // Recursively delete from the right subtree
        } else {
            // Node with the key to be deleted found
            if (current.left == null) {
                size--;
                return current.right; // Replace the node with its right child if it has no left child
            } else if (current.right == null) {
                size--;
                return current.left; // Replace the node with its left child if it has no right child
            } else {
                Node successor = findMinNode(current.right); // Find the successor node
                current.key = successor.key; // Replace the key and value of the current node with the successor node
                current.val = successor.val;
                current.right = delete(current.right, successor.key); // Recursively delete the successor node
            }
        }
        return current;
    }
    /**
     * Finds the node with the minimum key in the given subtree.
     *
     * @param node The root node of the subtree
     * @return The node with the minimum key
     */
    private Node findMinNode(Node node) {
        if (node.left == null) {
            return node; // Return the node if it has no left child (minimum key found)
        }
        return findMinNode(node.left); // Recursively search in the left subtree
    }
    /**
     * Returns the number of nodes in the binary search tree.
     *
     * @return The size of the binary search tree
     */
    public int size() {
        return size;
    }
    /**
     * Returns an iterable collection of key-value pairs in the binary search tree.
     *
     * @return The iterable collection of key-value pairs
     */
    public Iterable<KeyValue<K, V>> iterator() {
        List<KeyValue<K, V>> keyValues = new ArrayList<>();
        inorderTraversal(root, keyValues);
        return keyValues;
    }
    private void inorderTraversal(Node node, List<KeyValue<K, V>> keyValues) {
        if (node != null) {
            inorderTraversal(node.left, keyValues);
            keyValues.add(new KeyValue<>(node.key, node.val));
            inorderTraversal(node.right, keyValues);
        }
    }
    public class KeyValue<K, V> {
        private K key;
        private V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
}
