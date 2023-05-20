# Binary Search Tree (BST)
# Assigment 5
# Course: Algorithms and Data Structures
# Binary Search Tree
---

## Tasks from
- [Assignment 5](https://moodle.astanait.edu.kz/mod/assign/view.php?id=82642)

## Build
IntelliJ IDEA
- I used v2022.3.1
## Explanation of the Assignment 5
<details>
<summary>BST class</summary>
This is a Java implementation of a Binary Search Tree (BST) data structure. A BST is a tree-based data structure in which each node has a key and an associated value. The keys in a BST are stored in a particular order that allows for efficient searching, insertion, and deletion operations.
---
Class: BST<K extends Comparable<K>, V>
This class represents the Binary Search Tree.

-Constructors
BST(): Constructs an empty Binary Search Tree.

-Fields
private Node root: The root node of the binary search tree.
private int size: The number of nodes in the binary search tree.

-Methods
public void put(K key, V val): Inserts a key-value pair into the binary search tree.
  
private Node put(Node current, K key, V val): Recursive method to insert a key-value pair into the binary search tree.
  
public V get(K key): Retrieves the value associated with a given key from the binary search tree.
  
private Node get(Node current, K key): Recursive method to search for a key in the binary search tree.
  
public void delete(K key): Deletes a key and its associated value from the binary search tree.
  
private Node delete(Node current, K key): Recursive method to delete a key from the binary search tree.
  
private Node findMinNode(Node node): Finds the node with the minimum key in the given subtree.
  
public int size(): Returns the number of nodes in the binary search tree.
  
public Iterable<KeyValue<K, V>> iterator(): Returns an iterable collection of key-value pairs in the binary search tree.
  
private void inorderTraversal(Node node, List<KeyValue<K, V>> keyValues): Performs an inorder traversal of the binary search tree and collects key-value pairs.
  
-Inner Class: Node
This class represents a node in the Binary Search Tree.

-Fields
private K key: The key of the node.
private V val: The value associated with the key.
private Node left: The left child node.
private Node right: The right child node.
  
-Constructors
public Node(K key, V val): Constructs a node with the given key and value.
  
-Inner Class: KeyValue<K, V>
This class represents a key-value pair in the Binary Search Tree.

-Fields
private K key: The key of the key-value pair.
private V value: The value associated with the key.
  
-Constructors
public KeyValue(K key, V value): Constructs a key-value pair with the given key and value.
  
Methods
public K getKey(): Returns the key of the key-value pair.
  
public V getValue(): Returns the value associated with the key-value pair.
  </details>
