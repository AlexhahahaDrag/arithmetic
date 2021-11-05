package array;

import java.util.HashMap;
import java.util.Map;

/**
 *description:  1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 *author:       alex
 *createDate:   2021/11/5 12:34
 *version:      1.0.0
 */
public class LongestSubsequence {

    public int longestSubsequence1(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int cur;
        for(int i : arr) {
            cur = map.getOrDefault(i - difference, 0) + 1;
            res = Math.max(res, cur);
            map.put(i, cur);
        }
        return res;
    }

    public int longestSubsequence(int[] arr, int difference) {
        int[] map = new int[40001];
        int res = 0;
        int cur;
        for(int i : arr) {
            cur = map[i -difference + 20000] + 1;
            map[i + 20000] = cur;
            res = Math.max(cur, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int difference = 1;
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        System.out.println(longestSubsequence.longestSubsequence(arr, difference));
    }
}
