package array;

/**
 * @Description:
 *搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * @Author:     alex
 * @CreateDate: 2019/12/9 12:46
 * @Version:    1.0
 *
 */
public class SearchII {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = (end - start >> 1) + start;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else if(nums[mid] > target) {
                if (target > nums[start]) {
                    end = mid - 1;
                } else if (nums[mid] < nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[start] < nums[mid]) {
                    start = mid + 1;
                } else {
                    if (target > nums[start]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchII searchII = new SearchII();
        int[] nums = {5,1,3 };
        System.out.println(searchII.search(nums, 3));
        int[] nums1 = {3,4,5,6,1, 2};
        System.out.println(searchII.search(nums1, 6));
        int[] nums2 = {5, 1, 2, 3, 4};
        System.out.println(searchII.search(nums2, 1));
    }
}
