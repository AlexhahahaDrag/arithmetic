package array;

/**
 * @Description:插入排序
 * @Author:      alex
 * @CreateDate:  ${DATE} ${TIME}
 * @Version:     1.0.0
*/
public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = {45,676,234,17,87,9,8,90,8,2,423,1,23};
        insertSort.insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    private void insertSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                    arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
