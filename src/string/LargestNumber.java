package string;

import java.util.Arrays;

/**
 * @description:
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * @author:      alex
 * @createTime:  2021/4/12 12:18
 * @version:     1.0
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!judge(nums[i], nums[j])) {
                    swap(nums, i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < nums.length; i++) {
            if (first && nums[i] == 0 && i != nums.length - 1) {
                continue;
            } else {
                first = false;
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    private boolean judge(int i, int j) {
//        int di = digit(i);
//        int dj = digit(j);
//        return di >= dj ? i >= j * Math.pow(10, di - dj) : i * Math.pow(10, dj - di) > j;
//    }
//
//    private int digit(int i) {
//        int di = 0;
//        while(i > 0) {
//             i /= 10;
//             di++;
//        }
//        return di;
//    } 9534303

    private boolean judge(int i, int j) {
        String si = i + "" + j;
        String sj = j + "" + i;
        int index = -1;
        int sil = si.length();
        while(++index < sil) {
            if (si.charAt(index) > sj.charAt(index)) {
                return true;
            } else if (si.charAt(index) < sj.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(nums));
    }
}
