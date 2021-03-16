package array;

import java.util.Arrays;

/**
 * Description:
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * Author:      alex
 * CreateDate:  2020/7/10 16:32
 * Version:     1.0
 *
*/
public class PlusOne {

    public int[] plusOne1(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int index = digits.length;
        int dig = 0;
        digits[index - 1]++;
        while(--index >= 0) {
            if (digits[index] + dig > 9) {
                dig = 1;
                digits[index] = 0;
            } else {
                digits[index] += dig;
                dig = 0;
                break;
            }
        }
        if (dig > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = dig;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int index = digits.length;
        while(--index >= 0) {
            digits[index]++;
            digits[index] %= 10;
            if (digits[index] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {1, 9};
        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.plusOne(digits);
        for (int i :res) {
            System.out.print(i + "   ");
        }
    }
}
