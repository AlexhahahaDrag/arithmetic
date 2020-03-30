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

    public int[] searchRange1(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(target < nums[mid])
                end = mid - 1;
            else if (target > nums[mid])
                start = mid + 1;
            else {
                result[0] = find(nums, start, mid, target);
                result[1] = find(nums, mid, end, target);
                break;
            }
        }
        return result;
    }

    private int find1(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(target < nums[mid])
                end = mid - 1;
            else if (target > nums[mid])
                start = mid + 1;
            else {
                if (nums[mid] == nums[end])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return start;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return new int[2];
        int num = 0;
        int index = find(nums, target, 0, nums.length - 1);
        if (index == -1)
            return new int[2];
        return findMore(nums, target, index, num);
    }

    private int[] findMore(int[] nums, int target, int now, int num) {
        int start = now;
        while (start >= 0 && nums[start] == target)
            start--;
        int end = now + 1;
        while (end < nums.length && nums[end] == target)
            end++;
        return new int[]{start + 1, end - 1};
    }

    private int find(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int target = 8;
        int nums[] = {5, 7, 7, 8, 8, 10};
        int[] arr = searchRange.searchRange(nums, target);
        for(int i : arr)
            System.out.print(i + " ");
    }
}
