package array;

import java.util.Arrays;

/**
 *description:
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
            int k = i;
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
