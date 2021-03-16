package array;

import java.util.Arrays;

/**
 * Description:
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * Author:      alex
 * CreateDate:  2020/6/12 16:08
 * Version:     1.0
 *
*/
public class ThreeSumClosest {

    public int threeSumClosest1(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < target) {
                        closeSum = target - sum < Math.abs(target - closeSum) ? sum : closeSum;
                    } else {
                        closeSum = sum - target < Math.abs(target - closeSum) ? sum : closeSum;
                        break;
                    }

                }
            }
        }
        return closeSum;
    }

    public int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int t = target - nums[i];
            if (nums[i + 1] + nums[i + 2] > t) {
                int temp = nums[i] + nums[i + 1] + nums[i + 2];
                if (abs(target - closeSum, target - temp)) {
                    closeSum = temp;
                }
                continue;
            }
            if (nums[nums.length - 2] + nums[nums.length - 1] < t) {
                int temp = nums[i] + nums[nums.length - 2] + nums[nums.length - 1];
                if (abs(target - closeSum, target - temp)) {
                    closeSum = temp;
                }
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (abs(target - closeSum, target - sum)) {
                    closeSum = sum;
                }
                if (target > sum) {
                    l++;
                } else if (target < sum) {
                    r--;
                } else {
                    return target;
                }
            }

        }
        return closeSum;
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return -1;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int closeNum = nums[0] + nums[1] + nums[2];
        int cur;
        for(int i = 0; i < len - 2; i++) {
            int t = target - nums[i];
            if(nums[i + 1] + nums[i + 2] > t) {
                cur = nums[i + 1] + nums[i + 2] + nums[i];
                if (Math.abs(target - cur) < Math.abs(target - closeNum)) {
                    closeNum = cur;
                }
                continue;
            }
            if(nums[len - 2] + nums[len - 1] > t) {
                cur = nums[len - 2] + nums[len - 1] + nums[i];
                if (Math.abs(t - cur) < Math.abs(target - closeNum)) {
                    closeNum = cur;
                }
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right) {
                cur = nums[left] + nums[right];
                if (Math.abs(t - cur) < Math.abs(target - closeNum)) {
                    closeNum = cur + nums[i];
                }
                if(cur < t) {
                    left++;
                } else if (cur > t) {
                    right--;
                } else {
                    return closeNum;
                }
            }
        }
        return closeNum;
    }

    private boolean abs(int a, int b) {
        return Math.abs(a) > Math.abs(b);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        int target = 1;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(nums, target));
    }
}
