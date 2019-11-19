package string;

import java.util.Stack;

/**
 * @Description:
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 *  
 *
 * 示例 1：
 *
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 *
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 *
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * 示例 4：
 *
 * 输入：s = "(a(b(c)d)"
 * 输出："a(b(c)d)"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s[i] 可能是 '('、')' 或英文小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:     alex
 * @CreateDate: 2019/11/19 9:26
 * @Version:    1.0
 *
*/
public class MinRemoveToMakeValid {

    public static void main(String[] args) {
        MinRemoveToMakeValid minRemoveToMakeValid = new MinRemoveToMakeValid();
        String s = "lee(t(c)o)de";
        System.out.println(minRemoveToMakeValid.minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int remove = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ')') {
                if (left == 0) {
                    str[i] = '#';
                    remove++;
                } else
                    left--;
            } else if (str[i] == '(')
                left++;
        }
        int right = 0;
        for (int j = str.length - 1; j >= 0; j--) {
            if (str[j] == '(') {
                if (right == 0) {
                    str[j] = '#';
                    remove++;
                } else
                    right--;
            } else if (str[j] == ')')
                right++;
        }
        char[] result = new char[str.length - remove];
        int index = 0;
        for(char ch : str)
            if (ch != '#')
                result[index++] = ch;
        return new String(result);
    }

    public String minRemoveToMakeValids(String s) {
        char[] str = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ')') {
                if (stack.size() == 0)
                    str[i] = '#';
                else
                    stack.pop();
            } else if (str[i] == '(')
                stack.add(i);
        }
        while(stack.size() > 0)
            str[stack.pop()] = '#';
        StringBuilder sb = new StringBuilder();
        for(char ch : str)
            if (ch != '#')
                sb.append(ch);
        return sb.toString();
    }
}
