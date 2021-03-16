package array;

/**
 * Description:
 * 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * Author:     alex
 * CreateDate: 2019/12/13 16:45
 * Version:    1.0
 *
*/
public class FindMin {

    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] > nums[end]) {
            while(start < end) {
                int mid = start + (end - start >> 1);
                if (nums[mid] >= nums[0]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] arr = {3, 4 ,1};
        System.out.println(findMin.findMin(arr));
    }
}
