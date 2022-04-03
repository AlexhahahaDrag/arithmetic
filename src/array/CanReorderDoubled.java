package array;

/**
 *description:
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 *
 *
 * 提示：
 *
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 *author:       alex
 *createDate:   2022/4/1 23:34
 *version:      1.0.0
 */
public class CanReorderDoubled {

    public boolean canReorderDoubled(int[] arr) {
        int len = 100000;
        int[] map = new int[len * 2 + 1];
        for(int i : arr) {
            map[i + len]++;
        }
        for(int i = len; i < map.length; i++) {
            if(map[i] > 0) {
                if(i * 2  > len * 3 + 1 || map[i] > map[i * 2 - len]) {
                    return false;
                }
                map[i * 2 - len] -= map[i];
            }
        }
        for (int j = len - 1; j >= 0; j--) {
            if (map[j] > 0) {
                if (j * 2 < len || map[j] > map[j * 2 - len]) {
                    return false;
                }
                map[j * 2 - len] -= map[j];
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {4, -2, 2, -4};//ture
//        int[] arr = {3,1,3,6};//false
        int[] arr = {4, -2, 2, -4, 50000, 100000, -50000, -100000};//true
        CanReorderDoubled canReorderDoubled = new CanReorderDoubled();
        System.out.println(canReorderDoubled.canReorderDoubled(arr));
    }
}
