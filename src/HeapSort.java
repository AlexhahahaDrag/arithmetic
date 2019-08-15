/**
 * @Description: heap sort
 * @Author:     alex
 * @CreateDate: 2019/8/15 20:12
 * @Version:    1.0
 *
*/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {13,65,3,435,465,46,6576,57};
        HeapSort heapSort = new HeapSort();
        heapSort.getHeapSort(arr);
        heapSort.sort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }

    private void sort(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            peerDown(arr, 0, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void getHeapSort(int[] arr){
        int len = arr.length;
        for (int i = arr.length/2-1; i >= 0 ; i--)
            peerDown(arr, i, len);
    }

    private void peerDown(int[] arr, int start, int len) {
        int value = arr[start];
        int child = start;
        int i;
        for (i = start; 2 * i + 1 < len; i = child ) {
            child = 2 * i + 1;
            if (child < len - 1 && arr[child] < arr[child + 1])
                child++;
            if (value > arr[child])
                break;
            else
                arr[i] = arr[child];
        }
        arr[i] = value;
    }
}
