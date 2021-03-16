package array;

import java.util.Arrays;

/**
 *description:
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *author:       alex
 *createDate:  2020/3/20 22:30
 *version:      1.0.0
*/
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length <= k) {
            return arr;
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,2,0,5};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] res = getLeastNumbers.getLeastNumbers(arr, 0);
        for (int i : res) {
            System.out.print(i + "  ");
        }
    }
}
