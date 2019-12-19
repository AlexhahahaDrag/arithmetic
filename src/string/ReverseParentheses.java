package string;

import java.util.Stack;

/**
 * Description:
 * 1190. 反转每对括号间的子串
 *
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/19 20:00
 * Version:     1.0
 *
*/
public class ReverseParentheses {

    public String reverseParentheses(String s) {
        int index = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        Stack<Integer> stack = new Stack<>();
        while(index < len) {
            if (chars[index] == '(')
                stack.add(index);
            else if (chars[index] == ')') {
                int start = stack.pop();
                reverse(chars, start, index);
            }
            index++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++)
            if (chars[i] != '(' && chars[i] != ')')
                stringBuilder.append(chars[i]);
        return stringBuilder.toString();
    }

    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            if (chars[start] == '(' || chars[start] == ')')
               start++;
            if (chars[end] == '(' || chars[end] == ')')
                end--;
            if (start >= end)
                return;
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseParentheses reverseParentheses = new ReverseParentheses();
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println(reverseParentheses.reverseParentheses(s));
    }
}
