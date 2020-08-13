package array;
/**
 *description:
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *author:       alex
 *createDate:  2020/3/27 20:44
 *version:      1.0.0      
*/
public class Rotate {

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k %= nums.length;
        swap(nums, len - k - 1, len);
        swap(nums, -1, len - k);
        swap(nums, -1, len);
    }

    private void swap(int[] nums, int start, int end) {
        while(++start < --end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0)
            return;
        rotateNums(nums, nums.length - k, k, 0, nums.length);
    }

    private void rotateNums(int[] nums, int left, int right, int start, int end) {
        if(left == right) {
            cSwap(nums, start, end, left);
        } else if (left > right) {
            cSwap(nums, start, end, right);
            rotateNums(nums, left - right, right, start + right, end);
        } else {
            cSwap(nums, start, end, left);
            rotateNums(nums, left, right - left, start, end - left);
        }
    }

    private void cSwap(int[] nums, int start, int end, int len) {
        int newEnd = end - len;
        while(--len >= 0) {
            int temp = nums[start + len];
            nums[start + len] = nums[newEnd + len];
            nums[newEnd + len] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
            Rotate rotate = new Rotate();
        rotate.rotate(nums, 3);
        for (int i : nums)
            System.out.print(i + "  ");
    }
}
