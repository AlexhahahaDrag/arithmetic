package math;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/25 19:44
 * Version:     1.0
 *
*/

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder stringBuilder = new StringBuilder();
        if (numerator < 0 ^ denominator < 0)
            stringBuilder.append("-");
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        if (num % den == 0) {
            stringBuilder.append(num / den);
            return stringBuilder.toString();
        }
        stringBuilder.append(num / den + ".");
        num %= den;
        Map<Long, Integer> map = new HashMap<>();
        while(num != 0) {
            if (map.containsKey(num)) {
                stringBuilder.insert(map.get(num), "(");
                stringBuilder.append(")");
                break;
            }
            map.put(num, stringBuilder.length());
            num *= 10;
            long s = num / den;
            stringBuilder.append(s);
            num = num % den;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        int numerator = -2147483648;
        int denominator = -1;
        System.out.println(fractionToDecimal.fractionToDecimal(numerator, denominator));
    }
}
