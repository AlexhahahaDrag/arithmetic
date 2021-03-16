package array;

/**
 * @Description:
 * @Author:      alex
 * @CreateDate:  ${DATE} ${TIME}
 * @Version:     1.0.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {45,676,234,17,87,9,8,90,8,2,423,1,23};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort1(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    private void shellSort1(int[] arr) {
        int k;
        for (int i = (arr.length >> 1); i > 0 ; i >>= 1) {
            for (int j = i; j < arr.length ; j++) {
                int temp = arr[j];
                for (k = j; k >= i && temp > arr[k - i]; k -= i) {
                    arr[k]  = arr[k - i];
                }
                arr[k] = temp;
            }
        }
    }
    private void shellSort(int[] arr) {
        for (int i = (arr.length >> 1); i > 0 ; i >>= 1) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k >= i; k -= i) {
                    if (arr[k] > arr[k - i]) {
                        int temp = arr[k];
                        arr[k] = arr[k - i];
                        arr[k - i] = temp;
                    }
                }
            }
        }
    }
}
