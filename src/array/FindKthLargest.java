package array;

/**
 * Description:
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * Author:      alex
 * CreateDate:  2020/6/29 12:22
 * Version:     1.0
 *
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int k, int start, int end) {
        int index = sort(nums, start, end);
        if (index + 1 == k) {
            return nums[index];
        } else if (index + 1 > k) {
            return quickSort(nums, k, start, index - 1);
        } else {
            return quickSort(nums, k, index + 1, end);
        }
    }

    private int sort(int[] nums, int start, int end) {
        int mid = start + (end - start >> 1);
        if (nums[end] > nums[mid]) {
            swap(nums, mid, end);
        }
        if (nums[end] > nums[start]) {
            swap(nums, start, end);
        }
        if (nums[start] > nums[mid]) {
            swap(nums, start, mid);
        }
        int in = start;
        while(in <= end) {
            while(in <= end && nums[in] >= nums[start]) {
                in++;
            }
            while(in <= end && nums[end] < nums[start]) {
                end--;
            }
            if(in <= end) {
                swap(nums, in, end);
            }
        }
        swap(nums, in - 1, start);
        return in - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(nums, k));
    }
}
