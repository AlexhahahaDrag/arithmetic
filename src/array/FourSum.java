package array;

import java.util.*;

/**
 *description:
 * 18. 四数之和
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/13 20:53
 *version:      1.0.0      
*/
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int zero = 0;
        int positive = 0;
        int negative = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : nums) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            if (i < 0) {
                negative++;
            } else if (i == 0) {
                zero++;
            } else {
                positive++;
            }
        }

        if (zero > 3) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                list.add(0);
            }
            result.add(list);
        }
        if (negative == 0 || positive == 0) {
            return result;
        }
        int[] pos = new int[positive];
        int[] neg = new int[negative];
        positive = 0;
        negative = 0;
        for(int i : nums) {
            if (i < 0) {
                neg[negative++] = i;
            } else if (i > 0) {
                pos[positive++] = i;
            }
        }
        Arrays.sort(pos);
        Arrays.sort(neg);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2, 0, 0};
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(arr, 0));
    }
}
