package string;

/**
 * Description:
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 * Author:      alex
 * CreateDate:  2020/5/11 22:12
 * Version:     1.0
 *
*/
public class CheckValidString {

    public boolean checkValidString(String s) {
        int left = 0;
        int len = s.length();
        int index = 0;
        while(index < len) {
            char ch = s.charAt(index++);
            if (ch == '(' || ch == '*') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        int right = 0;
        index = len - 1;
        while(index >= 0) {
            char ch = s.charAt(index--);
            if (ch == '*' || ch == ')') {
                right++;
            } else if (ch == '(') {
                if (right > 0) {
                    right--;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        CheckValidString checkValidString = new CheckValidString();
        System.out.println(checkValidString.checkValidString("(((((*)))"));
    }
}
