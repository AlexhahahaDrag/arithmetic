package array;

import java.util.Arrays;

/**
 * @description:
 * 35. 搜索插入位置
 * 难度
 * 简单
 *
 * 587
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * @author:      alex
 * @createTime:  2020/7/17 12:22
 * @version:     1.0
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0])
            return 0;
        int len = nums.length;
        if (target > nums[len - 1])
            return len;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while(left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                if (nums[mid + 1] >= target)
                    return mid + 1;
                left = mid + 1;
            } else {
                if (nums[mid - 1] < target)
                    return mid;
                right = mid;
            }
        }
        return mid;
    }

    public int searchInsert2(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i < 0 ? -i -1 : i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 2;
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, target));
        System.out.println(Arrays.binarySearch(nums, target));
    }
}
