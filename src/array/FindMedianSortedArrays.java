package array;

/**
 * @Description:
 * 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * @Author:      alex
 * @CreateDate:  ${DATE} ${TIME}
 * @Version:     1.0.0
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2 == null || nums2.length == 0)
                return 0;
            else
                return findMedian(nums2);
        } else {
            if (nums2 == null || nums2.length == 0)
                return findMedian(nums1);
            else
                return (findMedian(nums1) + findMedian(nums2)) / 2;
        }
    }

    private double findMedian(int[] nums) {
        double mid;
        int len = nums.length;
        if((len & 1) == 1)
            mid = nums[len >> 1];
        else
            mid = (double)(nums[len >> 1] + nums[(len >> 1) - 1] ) / 2;
        return mid;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] nums1 = {};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));

        try {

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
