package math;

import java.util.*;

/**
 *description:
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *author:       alex
 *createDate:   2021/1/20 17:21
 *version:      1.0.0
 */
public class MaximumProduct {

    public int maximumProduct1(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] maxl = new int[2];
        int min = Integer.MAX_VALUE;
        int[] minl = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] * nums[j] > max) {
                    max = nums[i] * nums[j];
                    maxl[0] = i;
                    maxl[1] = j;
                }
                if (nums[i] * nums[j] < min) {
                    min = nums[i] * nums[j];
                    minl[0] = i;
                    minl[1] = j;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max != Integer.MIN_VALUE && i != maxl[0] && i != maxl[1]) {
                res = Math.max(res, max * nums[i]);
            }
            if (min != Integer.MIN_VALUE && i != minl[0] && i != minl[1]) {
                res = Math.max(res, min * nums[i]);
            }
        }
        return res;
    }

    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] positive = new int[3];
        int[] negative = new int[2];
        Arrays.fill(positive, Integer.MIN_VALUE);
        Arrays.fill(negative, Integer.MAX_VALUE);
        for (int num : nums) {
            if (num > positive[positive.length - 1]) {
                int j = positive.length - 1;
                for (; j > 0; j--) {
                    if (num > positive[j - 1]) {
                        positive[j] = positive[j - 1];
                    } else {
                        break;
                    }
                }
                positive[j] = num;
            }
            if (num < negative[negative.length - 1]) {
                int j = negative.length - 1;
                for (; j > 0; j--) {
                    if (num< negative[j - 1]) {
                        negative[j] = negative[j - 1];
                    } else {
                        break;
                    }
                }
                negative[j] = num;
            }
        }
        return Math.max(positive[0] * positive[1] * positive[2], positive[0] * negative[0] * negative[1]);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {-4, -3, -2 , -7, 3};
//        int[] nums = {-1, -2, -3};
//        int[] nums = {1, 0, 100};
        MaximumProduct maximumProduct = new MaximumProduct();
        System.out.println(maximumProduct.maximumProduct(nums));
    }
}
