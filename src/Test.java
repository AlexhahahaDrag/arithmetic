public class Test {
    public static void main(String[] args) {
       BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<>();
        System.out.println(binarySearchTree.contains(4));
       binarySearchTree.insert(4);
       binarySearchTree.insert(5);
       binarySearchTree.insert(1);
       binarySearchTree.insert(1);
       binarySearchTree.insert(3);
        System.out.println(binarySearchTree.isEmpty());
        System.out.println(binarySearchTree.contains(4));
        System.out.println("min: "+binarySearchTree.findMax());
        System.out.println("max: "+binarySearchTree.findMin());
        binarySearchTree.printTree();
        binarySearchTree.remove(3);
        binarySearchTree.remove(4);
       binarySearchTree.printTree();
       binarySearchTree.makeEmpty();
        System.out.println(binarySearchTree.isEmpty());
    }
}
