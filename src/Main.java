public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(10, "Sample1");
        bst.put(5, "Sample2");
        bst.put(15, "Sample3");
        bst.put(3, "Sample4");
        bst.put(8, "Sample5");
        bst.put(13, "Sample6");
        bst.put(18, "Sample7");
        bst.delete(10);
        bst.delete(8);
        bst.delete(18);
        System.out.println(bst.consist(18));
        System.out.println(bst.consist(3));
        System.out.println(bst.consist(5));
        System.out.println(bst.consist(15));
        /*BST<Integer, String> tree = new BST<>();
        tree.put(1, "Sample1");
        tree.put(2, "Sample2");
        tree.put(3, "Sample3");

        for (BST.KeyValue elem : tree.iterator()) {
            System.out.println("key:" + elem.getKey() + " value:" + elem.getValue());
        }*/
    }
}