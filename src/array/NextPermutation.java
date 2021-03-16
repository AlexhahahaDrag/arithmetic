package array;

import java.util.Arrays;

/**
 * @description:
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author:      alex
 * @createTime:  2020/11/10 9:21
 * @version:     1.0
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        out: for (; i >= 0; i--) {
            len = nums.length;
            while(i < len--) {
                if (nums[i] < nums[len]) {
                    break out;
                }
            }
        }
        if (len >= 0) {
            int temp = nums[len];
            nums[len] = nums[i];
            nums[i] = temp;
        }
        Arrays.sort(nums, i + 1, nums.length);
    }

    public static void main(String[] args) {
       // int[] arr = {1,3,2};
        int[] arr = {4,2,0,2,3,2,0}; // 4,2,0,3,0,2,2
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + "   ");
        }
    }
}
