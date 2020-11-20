package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 1481. 不同整数的最少数目
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 * @author:      alex
 * @createTime:  2020/11/20 15:49
 * @version:     1.0
 */
public class FindLeastNumOfUniqueInts {

    public int findLeastNumOfUniqueInts1(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        Integer[] mapp = map.values().toArray(new Integer[0]);
        Arrays.sort(mapp);
        int i = 0;
        for (; i < mapp.length; i++) {
            if (k >= mapp[i])
                k -= mapp[i];
            else
                break;
        }
        return mapp.length - i;
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] counts = new int[arr.length];
        int index = 0;
        counts[index]++;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                counts[index]++;
            else
                counts[++index]++;
        }
        Arrays.sort(counts);
        int i = 0;
        for (; i < counts.length; i++) {
            if (k >= counts[i])
                k -= counts[i];
            else
                break;
        }
        return counts.length - i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 4};
        int k = 1;
        FindLeastNumOfUniqueInts findLeastNumOfUniqueInts = new FindLeastNumOfUniqueInts();
        System.out.println(findLeastNumOfUniqueInts.findLeastNumOfUniqueInts(arr, k));
    }
}
