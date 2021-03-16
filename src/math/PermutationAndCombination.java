package math;

import java.util.Arrays;
/**
 * @Description: 给定一组数，找出它的所有的排列组合
 *                 先查找有比前一位大的数，后找到最小的比他大的数，在调换他们两的位置，最后在反转后面的数组。
 * @Author: alex
 * @CreateDate: ${DATE} ${TIME}
 * @Version: 1.0.0
 */
public class PermutationAndCombination {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        PermutationAndCombination permutationAndCombination = new PermutationAndCombination();
        permutationAndCombination.findAllPermutationAndCombination(arr);
    }

    public void findAllPermutationAndCombination(int[] arr) {
        Arrays.sort(arr);
        printArr(arr);
        int p = arr.length - 1;
        int q;
        int pFind;
        while(p != 0) {
            q = p;
            --p;
            if (arr[p] < arr[q]) {
                pFind = arr.length - 1;
                while(arr[pFind] < arr[p]) {
                    pFind--;
                }
                swap(arr, pFind, p);
                reverse(arr, q, arr.length - 1);
                printArr(arr);
                p = arr.length - 1;
            }
        }
    }
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    private void printArr(int[] arr) {
        Arrays.stream(arr).forEach(System.out :: print);
        System.out.println();
    }
}
