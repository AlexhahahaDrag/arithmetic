package classes;

public class HeapSort <AnyType extends Comparable<? super AnyType>>{

    int size = 0;
    public void heapSort(AnyType[] arr) {
        size = arr.length;
        buildHeap(arr);
        swap(arr, --size);
        while(size > 0) {
            down(arr, 0);
            swap(arr, --size);
        }
    }

    private void swap(AnyType[] arr, int i) {
        AnyType temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
    }

    private void buildHeap(AnyType[] arr) {
        for (int i = size >> 1; i >= 0; i--)
            down(arr, i);
    }

    private void down(AnyType[] arr, int i) {
        AnyType temp = arr[i];
        int child;
        int j;
        for (j = i; (j + 1) * 2 - 1 < size; j = child) {
            child = (j + 1) * 2 - 1;
            if (child < size - 1 && arr[child + 1].compareTo(arr[child]) > 0)
                child++;
            if (temp.compareTo(arr[child]) < 0)
                arr[j] = arr[child];
            else
                break;
        }
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {-1, 2, -56, 6, 28, 35, -42, 5, 6, 9};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        for (int i : arr)
            System.out.print(i + "  ");
    }
}
