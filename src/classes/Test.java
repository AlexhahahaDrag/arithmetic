package classes;

public class Test {

    public static void main(String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        System.out.println(binaryHeap.isEmpty());
        binaryHeap.insert(2);
        binaryHeap.insert(3);
        binaryHeap.insert(11);
        binaryHeap.insert(23);
        binaryHeap.insert(43);
        binaryHeap.insert(1);
        binaryHeap.insert(5);
        binaryHeap.insert(9);
        binaryHeap.insert(7);
        binaryHeap.insert(6);
        System.out.println(binaryHeap.findMin());
        binaryHeap.deleteMin();
        System.out.println(binaryHeap.findMin());
        binaryHeap.deleteMin();
        System.out.println(binaryHeap.findMin());
        binaryHeap.deleteMin();
        System.out.println(binaryHeap.findMin());
        System.out.println("----------------------------------");
        Integer[] arr = {4, 6, 7,3, 11, 34, 34, 56, 6};
        BinaryHeap<Integer> binaryHeap1 = new BinaryHeap<>(arr);
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        binaryHeap1.deleteMin();
        System.out.println(binaryHeap1.findMin());
        binaryHeap1.deleteMin();
        System.out.println(binaryHeap1.findMin());

    }

}
