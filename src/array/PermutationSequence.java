package array;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * @Author:     alex
 * @CreateDate: 2019/8/22 17:58
 * @Version:    1.0
 *
*/
public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int factorial = 1;
        for (int i = 2; i < n; i++)
            factorial *= i;
        k--;
        while(n > 1) {
            int index = k / factorial;
            sb.append(list.get(index));
            k =  k % factorial;
            list.remove(index);
            n--;
            factorial /= n;
        }
        sb.append(list.get(0));
        return sb.toString();
    }

    public String getPermutation1(int n, int k) {
        int index = 1;
        int[] arr = new int[n];
        while(index <= n)
            arr[index - 1] = index++;
        int p = arr.length  - 1;
        int q;
        int pFind;
        while(k > 1) {
            q = p;
            p--;
            if (arr[p] < arr[q]) {
                pFind = arr.length - 1;
                while (arr[pFind] < arr[p])
                    pFind--;
                swap(arr, pFind, p);
                sort(arr, q, arr.length - 1);
                p = arr.length - 1;
                k--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr)
            stringBuilder.append(i);
        return stringBuilder.toString();
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void sort(int[] arr, int i, int j) {
        while(i < j)
            swap(arr, i++, j--);
    }
}
