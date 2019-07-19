package array;

/**
 * @Description: Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * @Author:     alex
 * @CreateDate: 2019/7/19 14:26
 * @Version:    1.0
 *
*/
public class SingleNumberII {
    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();
        int[] arr = {0,1,0,1,0,1,99,3};
        System.out.println(99^3);
        System.out.println(singleNumberII.singleNumber(arr));
    }
    public int singleNumber(int[] nums) {
        int ones = 0;//出现一次
        int twos = 0;//出现两次
        for (int value : nums) {
            ones = (ones ^ value) & ~twos; //~two表示出现两次清0
            twos = (twos ^ value) & ~ones; // ~one表示出现三次清0
        }
        return ones;
    }
}
