package classes;

/**
 *description:  插入排序 时间复杂度o(n^2)
 *author:       alex
 *createDate:  2020/4/27 7:00
 *version:      1.0.0
*/
public class InsertSort {

    public <AnyType extends Comparable<? super AnyType>> void insertSort(AnyType[] arr) {
        for (int i = 1; i < arr.length; i++) {
            AnyType temp = arr[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {-1, 2, -56, 6, 28, 35, -42, 5, 6, 9, 23, 43, 23};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(arr);
        for (int i : arr)
            System.out.print(i + "   ");
    }
}
