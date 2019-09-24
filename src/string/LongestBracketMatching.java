package string;

import java.util.Stack;

/**
 * @Description: 求一个括号串的最长括号子串的长度，如 “ ) ( ( ) ( ) ”的最长子串为“ ( ) ( ) ”长度为4。
 * @Author:     alex
 * @CreateDate: 2019/9/24 12:36
 * @Version:    1.0
 *
 */
public class LongestBracketMatching {

    public static void main(String[] args) {
        LongestBracketMatching longestBracketMatching = new LongestBracketMatching();
        System.out.println(longestBracketMatching.getLongestBracketMatching1("(((())())"));
    }

    private int getLongestBracketMatching1(String bracketes){
        Stack<Integer> stack = new Stack();
        int index = 0;
        int len = bracketes.length();
        int start = -1;
        int maxLen = 0;
        while (index < len) {
            if ('(' == bracketes.charAt(index))
                stack.add(index);
            else {
                if (stack.empty())
                    start = index;
                else {
                    stack.pop();
                    if (stack.empty())
                        maxLen = maxLen > index - start ? maxLen : index - start;
                    else
                        maxLen = maxLen > index - stack.peek() ? maxLen : index - stack.peek();
                }
            }
            index++;
        }
        return maxLen;
    }

    private int getLongestBracketMatching(String bracketes){
        int index = 0;
        int len = bracketes.length();
        int start = -1;
        int maxLen = 0;
        int deep = 0;
        while (index < len) {
            if ('(' == bracketes.charAt(index))
                deep++;
            else {
                deep--;
                if (deep == 0)
                    maxLen = maxLen > index - start ? maxLen : index - start;
                else if (deep < 0){
                    start = index;
                    deep = 0;
                }
            }
            index++;
        }
        start = len - 1;
        while (start >= 0) {
            if (')' == bracketes.charAt(start))
                deep++;
            else {
                deep--;
                if (deep == 0)
                    maxLen = maxLen > len - start ? maxLen : len - 1 - start;
                else if (deep < 0) {
                    deep = 0;
                    len = start;
                }
            }
            start--;
        }
        return maxLen;
    }
}


