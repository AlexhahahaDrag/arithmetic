package string;

/**
 * @description:
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * @author:      alex
 * @createTime:  2020/8/24 9:09
 * @version:     1.0
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2)
            return false;
        int len = s.length();
        for(int i = 2; i <= s.length(); i++) {
            if (len % i == 0) {
                boolean flag = true;
                int j = 0;
                while(j <= len - len / i * 2) {
                    if (!s.substring(j, j + len / i).equals(s.substring(j + len / i, j + len / i * 2))) {
                        flag = false;
                        break;
                    } else
                        j += len / i;
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aa";
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s));
    }
}
