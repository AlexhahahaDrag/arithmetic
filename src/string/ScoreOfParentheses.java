package string;

import java.util.Stack;

/**
 * Description:
 * 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 *
 *
 * 提示：
 *
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 * Author:      alex
 * CreateDate:  2020/5/11 21:54
 * Version:     1.0
 *
*/
public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        int index = 0;
        int len = S.length();
        Stack<Integer> stack = new Stack();
        while (index < len) {
            if (S.charAt(index) == '(') {
                stack.add(-1);
            } else if (!stack.isEmpty()){
                int sum = 0;
                Integer object = stack.pop();
                while(!stack.isEmpty() && object != -1) {
                    sum += object;
                    object = stack.pop();
                }
                if (object == -1) {
                    sum = sum == 0 ? 1 : sum << 1;
                    stack.add(sum);
                } else {
                    stack.add(sum);
                }
            }
            index++;
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
        System.out.println(scoreOfParentheses.scoreOfParentheses("()"));
    }
}
