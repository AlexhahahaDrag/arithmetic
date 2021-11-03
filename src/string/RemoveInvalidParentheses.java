package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 *
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 *
 * 输入：s = ")("
 * 输出：[""]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */
public class RemoveInvalidParentheses {
    private List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        char[] ch = s.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                left++;
            } else if (ch[i] == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        if (left == 0 && right == 0) {
            res.add(s);
        } else {
            dfs(s, 0, 0,0, left, right);
        }
        return res;
    }

    private void dfs(String s, int start, int lCount, int rCount, int lRemain, int rRemain) {
        if(lRemain == 0 && rRemain == 0) {
            if (judge(s)) {
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.length() - i < lRemain + rRemain) {
                return;
            }
            //去除左括号
            if (s.charAt(i) == '(') {
                if (lRemain > 0) {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, lCount, rCount,lRemain - 1, rRemain);
                }
                lCount++;
            }
            //去除右括号
            if (s.charAt(i) == ')' && rRemain > 0) {
                if (rRemain > 0) {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, lCount, rCount, lRemain, rRemain - 1);
                }
                rCount++;
            }
            if (lCount < rCount) {
                return;
            }
        }
    }

    private boolean judge(String s) {
        int index = -1;
        int left = 0;
        int len = s.length();
        char c;
        while(++index < len) {
            c = s.charAt(index);
            if ( c== '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                }else {
                    return false;
                }
            }
        }
        return left == 0;
    }

    public static void main(String[] args) {
        String s = ")(";
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        System.out.println(removeInvalidParentheses.removeInvalidParentheses(s));
    }
}
