package array;

import java.util.Arrays;

/**
 *description:
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *author:       alex
 *createDate:   2021/8/5 5:56
 *version:      1.0.0
 */
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int k = i + 1;
            for(int j = i + 1; j < nums.length - 1; j++) {
                while(k + 1 < nums.length && nums[i] + nums[j] > nums[k + 1]) {
                    k++;
                }
                sum += Math.max(k - j, 0);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {2,2,3,4};
//        int[] nums = { 7, 0, 0, 0};
        int[] nums = { 1, 2, 3, 4, 5, 6};
        TriangleNumber triangleNumber = new TriangleNumber();
        System.out.println(triangleNumber.triangleNumber(nums));
    }
}
