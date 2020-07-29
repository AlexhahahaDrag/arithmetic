package math;

import java.util.Stack;

/**
 * @description:
 * 面试题 16.26. 计算器
 *
 * 反馈
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * @author:      alex
 * @createTime:  2020/7/29 16:04
 * @version:     1.0
 */
public class Calculate {
    Stack<Object> stack;
    public int calculate(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        int index = -1;
        stack = new Stack<>();

    }

    private Integer find(String s, int index, boolean isNagative) {
        int len = s.length();
        int res = 0;
        while(index < len) {
            char ch = s.charAt(index++);
            if (ch >= '0' && ch <= '9')
                res = res * 10 + ch - (int)'0';
            else
                break;
        }
        stack.add(res);
        return index - 1;
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate(s));
    }
}
