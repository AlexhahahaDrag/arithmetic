package classes;

/**
 *description:  希尔排序
 *author:       alex
 *createDate:  2020/4/27 7:01
 *version:      1.0.0
*/
public class SellSort {

    public <AnyType extends Comparable<? super AnyType>> void sellSort(AnyType[] arr) {
        int j;
        for (int step = arr.length >> 1; step > 0; step >>= 1) {
            for (int i = step; i < arr.length; i++) {
                AnyType temp = arr[i];
                for (j = i; j >= step && temp.compareTo(arr[j - step]) < 0 ; j -= step)
                    arr[j] = arr[j - step];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {-1, 2, 7, 8, 9, 10, -56, 6, 28, 35, -42, 5, 6, 9, 23, 43, 23};
        SellSort sellSort = new SellSort();
        sellSort.sellSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
