package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 *
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 *  
 *
 * 示例 1：
 *
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 *
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 *  
 *
 * 提示：
 *
 * 10 <= low <= high <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sequential-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/16 11:19
 * Version:     1.0
 *
*/
public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        int lowDi = getDigit(low);
        int highDi = getDigit(high);
        int lowSt = low / (int)(Math.pow(10, lowDi));
        int num = low;
        List<Integer> list = new ArrayList<>();
        while(lowDi <= highDi && num <= high) {
            num = getNum(lowSt, lowDi);
            if (num <= high && num >= low) {
                list.add(num);
            }
            if (lowSt + lowDi >= 10) {
                lowSt = 1;
                lowDi++;
            } else {
                lowSt++;
            }
        }
        return list;
    }

    private int getDigit(int num) {
        int digit = 0;
        while(num > 0) {
            digit++;
            num /= 10;
        }
        return digit;
    }

    private int getNum(int start, int digit) {
        int num = start;
        while(digit-- > 1) {
            num = (num * 10) + ++start;
        }
        return num;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();
        System.out.println(sequentialDigits.sequentialDigits(1000, 3000));
    }
}
