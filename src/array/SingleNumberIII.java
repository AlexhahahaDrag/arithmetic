package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @Author:     alex
 * @CreateDate: 2019/7/19 14:35
 * @Version:    1.0
 *
*/
public class SingleNumberIII {
    public static void main(String[] args) {
        SingleNumberIII singleNumberII = new SingleNumberIII();
        int[] arr = {1,2,1,3,2,5};
        int[] result = singleNumberII.singleNumber(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public int[] singleNumber(int[] nums) {
        int ones = 0;//出现一次
        int twos = 0;//出现两次
        for (int value : nums) {
            ones = ones ^ value;
            twos = twos ^ (value * value);
        }
        for (int num : nums) {
            int a = ones ^ num;
            if ( a * a == (twos ^ (num * num))) {
                return new int[]{a, num};
            }
        }
        return null;
    }
}
