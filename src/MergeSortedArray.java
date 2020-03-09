import java.util.Arrays;

/**
 * @Description: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * @Author:      alex
 * @CreateDate:  2019/2/14 14:38
 * @param
 * @return
*/
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1={1,2,3,0,0,0};
        int[] num2={};
        merge1(num1,3,num2,0);
    }
    public static void merge11(int[] nums1, int m, int[] nums2, int n) {
        int sum=m+n-1;
        while(m>0&&n>0)
            if(nums1[m-1]>nums2[n-1])
                nums1[sum--] = nums1[m-- - 1];
            else
                nums1[sum--] = nums2[n-- - 1];
        while(n>0)
            nums1[sum--] = nums2[n-- - 1];
        for (int i = 0; i <nums1.length ; i++) {
            System.out.println(nums1[i]);
        }
    }
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int mergedIdx = m + n - 1;
        while (m > 0 || n > 0) {
            int x = m > 0 ? nums1[m-1] : Integer.MIN_VALUE;
            int y = n > 0 ? nums2[n-1] : Integer.MIN_VALUE;
            if (x >= y)
                nums1[mergedIdx--] = nums1[m-- -1];
            else
                nums1[mergedIdx--] = nums2[n---1];
        }
        for (int i = 0; i <nums1.length ; i++) {
            System.out.println(nums1[i]);
        }
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int index = A.length - 1;
        while(m > 0 || n > 0) {
            if(A[m - 1] >B[n - 1]) {
                A[index--] = A[m-- - 1];
                n--;
            } else
                A[index--] = B[n-- - 1];
        }
        Arrays.copyOfRange(A, index, A.length - 1);
    }
}
