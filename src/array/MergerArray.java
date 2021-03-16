package array;

/**
 * @Description:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @Author:     alex
 * @CreateDate: 2019/11/21 16:00
 * @Version:    1.0
 *
*/
public class MergerArray {

    public static void main(String[] args) {
        MergerArray mergerArray = new MergerArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        mergerArray.merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i + "   ");
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length;
        while(m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[--index] = nums1[m-- - 1];
            } else if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[--index] = nums2[n-- - 1];
            }
        }
        while(m > 0) {
            nums1[--index] = nums1[m-- - 1];
        }
        while(n > 0) {
            nums1[--index] = nums2[n-- - 1];
        }
        if(index > 0) {
            for(int i = 0; i < nums1.length - index; i++) {
                nums1[i] = nums1[i + index];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n;
        while(n > 0) {
            int nu1 = m <= 0 ? Integer.MIN_VALUE : nums1[m - 1];
            if(nu1 > nums2[n - 1]) {
                nums1[--size] = nums1[--m];
            } else {
                nums1[--size] = nums2[--n];
            }
        }
    }
}
