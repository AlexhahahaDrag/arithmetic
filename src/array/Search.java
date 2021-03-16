package array;

/**
 *description:
 * 面试题53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *author:       alex
 *createDate:  2020/3/30 22:56
 *version:      1.0.0      
 */
public class Search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int num = 0;
        int index = find(nums, target, 0, nums.length - 1);
        if (index == -1) {
            return num;
        }
        return findMore(nums, target, index, num);
    }

    private int findMore(int[] nums, int target, int now, int num) {
        int cur = now;
        while (cur >= 0 && nums[cur] == target) {
            num++;
            cur--;
        }
        cur = now + 1;
        while (cur < nums.length && nums[cur] == target) {
            cur++;
            num++;
        }
        return num;
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

    public static void main(String[] args) {
        int[] nums = {1,3};
        Search search = new Search();
        System.out.println(search.search(nums, 1));
    }
}
