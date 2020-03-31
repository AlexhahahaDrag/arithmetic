package array;

/**
 *description:
 * 912. 排序数组
 * 给定一个整数数组 nums，将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：[5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 *author:       alex
 *createDate:  2020/3/31 6:54
 *version:      1.0.0      
*/
public class SortArray {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if(start < end) {
            int index = quickSort(nums, start, end);
            sort(nums, start, index - 1);
            sort(nums, index + 1, end);
        }
    }

    private int quickSort(int[] nums, int start, int end) {
        int cur = nums[end];
        int in = start - 1;
        for (int i = start; i < end; i++) {
            if (cur >= nums[i]) {
                in++;
                swap(nums, in, i);
            }
        }
        swap(nums, in + 1, end);
        return in + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        SortArray sortArray = new SortArray();
        int[] res = sortArray.sortArray(nums);
        for(int i : res)
            System.out.print(i + " ");
    }
}
