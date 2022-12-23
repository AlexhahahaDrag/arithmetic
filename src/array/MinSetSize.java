package array;

/**
 * description:
 * 1338. 数组大小减半
 * 中等
 * 42
 * 相关企业
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * <p>
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * 示例 2：
 * <p>
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * arr.length 为偶数
 * 1 <= arr[i] <= 105
 * author:       majf
 * createDate:   2022/12/23 17:43
 * version:      1.0.0
 */
public class MinSetSize {

    public int minSetSize(int[] arr) {
        int[] map = new int[100001];
        for (int i : arr) {
            map[i]++;
        }
        int len = arr.length;
        int[] count = new int[len + 1];
        for (int j : map) {
            count[j]++;
        }
        int res = 0;
        int half = len >> 1;
        for (int k = len; k >= 0; k--) {
            if (count[k] == 0) {
                continue;
            }
            while (count[k] > 0) {
                count[k]--;
                len -= k;
                res++;
                if (half > len) {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};//2
        int[] arr = {7,7,7,7,7,7};
        MinSetSize minSetSize = new MinSetSize();
        System.out.println(minSetSize.minSetSize(arr));
    }
}
