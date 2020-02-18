package array;

/**
 *description:
 *面试题57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/17 9:50
 *version:      1.0.0      
*/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] res = new int[2];
        int sum;
        while(start < end) {
            sum = nums[start] + nums[end];
            if(sum == target) {
                res[0] = nums[start];
                res[1] = nums[end];
                break;
            } else if (sum < target)
                start++;
            else
                end--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(arr, target);
        System.out.println(res[0] + "      " + res[1]);
    }
}
