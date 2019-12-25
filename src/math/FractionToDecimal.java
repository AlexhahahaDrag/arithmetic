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
        StringBuilder stringBuilder = new StringBuilder();
        if (numerator < 0 ^ denominator < 0)
            stringBuilder.append("-");
        long numerator1 = Math.abs(numerator);
        long denominator1 = Math.abs(denominator);
        if (numerator1 % denominator1 == 0)
            return numerator1 / denominator1 + "";
        stringBuilder.append(numerator1 / denominator1 + ".");
        numerator1 %= denominator1;
        Map<Long, Integer> map = new HashMap<>();
        while(numerator1 != 0) {
            if (map.containsKey(numerator1)) {
                stringBuilder.insert(map.get(numerator1), "(");
                stringBuilder.append(")");
                break;
            }
            map.put(numerator1, stringBuilder.length());
            numerator1 *= 10;
            long s = numerator1 / denominator1;
            stringBuilder.append(s);
            numerator1 = numerator1 % denominator1;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        int numerator = 7;
        int denominator = -12;
        System.out.println(fractionToDecimal.fractionToDecimal(numerator, denominator));
    }
}
