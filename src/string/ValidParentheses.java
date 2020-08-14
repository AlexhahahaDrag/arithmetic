package string;

import java.util.Stack;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:     alex
 * @CreateDate: 2019/10/21 10:30
 * @Version:    1.0
 *
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([)]"));
    }

    public boolean isValid1(String s) {
        char ch[] = s.toCharArray();
        Stack<Character> track = new Stack<>();
        for(char c : ch) {
            if(c == '{' || c == '[' || c == '(')
                track.add(c);
            else {
                if (track.size() == 0)
                    return false;
                char chSt = track.pop();
                if (!map(chSt, c))
                    return false;
            }
        }
        if(track.size() > 0)
            return false;
        return true;
    }

    private boolean map(char ch1, char ch2) {
        if((ch1 == '(' && ch2 == ')') || (ch1 == '{' && ch2 == '}') || (ch1 == '[' && ch2 == ']'))
            return true;
        return false;
    }

    public boolean isValid(String s) {
        char ch[] = s.toCharArray();
        char[] stack = new char[ch.length];
        int len = 0;
        for(char c : ch) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[len++] = c;
                    break;
                case ')':
                    if (len == 0 || stack[--len] != '(')
                        return false;
                    break;
                case ']':
                    if (len == 0 || stack[--len] != '[')
                        return false;
                    break;
                case '}':
                    if (len == 0 || stack[--len] != '{')
                        return false;
                    break;
            }
        }
        return len == 0;
    }

    public boolean isValid3(String s) {
        char[] map = new char[s.length()];
        int size = -1;
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{')
                map[++size] = ch;
            else if(size < 0 || (ch == ')' && map[size--] != '(') || (ch == ']' && map[size--] != '[') || (ch == '}' && map[size--] != '{'))
                return false;
        }
        return size == -1;
    }
}
