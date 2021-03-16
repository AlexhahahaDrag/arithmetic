package array;

import java.util.Arrays;

/**
 * Description:
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * Author:     alex
 * CreateDate: 2019/12/15 9:25
 * Version:    1.0
 *
*/
public class SearchRange {

    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[2];
        }
        int num = 0;
        int index = find(nums, target, 0, nums.length - 1);
        if (index == -1) {
            return new int[2];
        }
        return findMore(nums, target, index, num);
    }

    private int[] findMore(int[] nums, int target, int now, int num) {
        int start = now;
        while (start >= 0 && nums[start] == target) {
            start--;
        }
        int end = now + 1;
        while (end < nums.length && nums[end] == target) {
            end++;
        }
        return new int[]{start + 1, end - 1};
    }

    private int find(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

//    public int[] searchRange(int[] nums, int target) {
//        int index = binary(nums, 0, nums.length - 1, target);
//        if (index == -1)
//            return new int[] {-1, -1};
//        int start = index; int end = index;
//        while(start - 1 >= 0 && nums[start - 1] == target)
//            start--;
//        while(end + 1 < nums.length && nums[end + 1] == target)
//            end++;
//        return new int[] {start, end};
//    }
//
//    private int binary(int[] nums, int start, int end, int target) {
//        while(start <= end) {
//            int mid = start + (end - start >> 1);
//            if(nums[mid] > target)
//                end = mid - 1;
//            else if (nums[mid] < target)
//                start = mid + 1;
//            else
//                return mid;
//        }
//        return -1;
//    }

    public int[] searchRange(int[] nums, int target) {
        int start = binary(nums, 0, nums.length - 1, target, true);
        int end = binary(nums, 0, nums.length - 1, target, false) - 1;
        if (start <= end && end < nums.length && nums[start] == target && nums[end] == target) {
            return new int[] {start, end};
        }
        return new int[] {-1, -1};
    }

    private int binary(int[] nums, int start, int end, int target, boolean low) {
        int ans = nums.length;
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(nums[mid] > target || (low && target <= nums[mid])) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int target = 2;
        int nums[] = { 2};
        int[] arr = searchRange.searchRange(nums, target);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
