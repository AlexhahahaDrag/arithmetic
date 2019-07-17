package array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description: Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 *
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Note:
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * @Author:     alex
 * @CreateDate: 2019/6/21 15:14
 * @Version:    1.0
 *
*/
public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros.duplicateZeros(arr);
    }
    public void duplicateZeros(int[] arr) {
        int[] newArr = new int[arr.length];
        int j = 0;
        for(int i = 0; i < arr.length; i++,j++)
            if(arr[j] == 0)
                i++;
            else
                newArr[i] = arr[j];
        for (int i = 0; i < newArr.length; i++)
            arr[i] = newArr[i];
    }
}
