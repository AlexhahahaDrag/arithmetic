package array;

import java.util.Arrays;

/**
 *description:面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *author:       alex
 *createDate:   2021/9/3 7:44
 *version:      1.0.0
 */
public class SmallestK {

    public int[] smallestK1(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0 || arr.length == 0) {
            return res;
        }
        Arrays.fill(res, Integer.MAX_VALUE);
        int cur;
        for(int i = 0; i < k; i++) {
            cur = k - 1;
            if(arr[i] < res[cur]) {
                while(cur - 1 >= 0 && res[cur - 1] > arr[i]) {
                    res[cur] = res[cur - 1];
                    cur--;
                }
                res[cur] = arr[i];
            }
        }
        for(int j = k; j < arr.length; j++) {
            cur = k - 1;
            if(arr[j] < res[cur]) {
                while(cur - 1 >= 0 && res[cur - 1] > arr[j]) {
                    res[cur] = res[cur - 1];
                    cur--;
                }
                res[cur] = arr[j];
            }
        }
        return res;
    }

    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        SmallestK smallestK = new SmallestK();
        int[] res = smallestK.smallestK(arr, k);
        for(int i : res) {
            System.out.print(i + ",");
        }
    }
}
