/**
 * @Description: Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 * @Author:      alex
 * @CreateDate:  2019/1/22 17:58
 * @param
 * @return
*/
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
    public static int trailingZeroes(int n){
        return n<5?0:n/5+trailingZeroes(n/5);
    }
}
