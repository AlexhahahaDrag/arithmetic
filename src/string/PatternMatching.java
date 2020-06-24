package string;


/**
 * Description:
 * 面试题 16.18. 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 *
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 *
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 *
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 *
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 *
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 * Author:      alex
 * CreateDate:  2020/6/22 12:26
 * Version:     1.0
 *
*/
public class PatternMatching {

    public boolean patternMatching(String pattern, String value) {
        if (pattern == null || value == null || pattern.length() == 0 || value.length() == 0)
            return true;
        int lp = pattern.length();
        int lv = value.length();
        if (lp % lv != 0 && lv % lp != 0)
            return false;
        if (lp > lv)
            return match(value, pattern);
        else
            return match(pattern, value);
    }

    private boolean match(String s1, String s2) {
        int len = s1.length();
        int pat = s2.length()  / len;
        char ch1 = s1.charAt(0);
        char ch2 = '0';
        String st1 = s2.substring(0, pat);
        String st2 = null;
        char ch;
        String cur;
        int index = 1;
        while (index < len) {
            ch = s1.charAt(index);
            cur = s2.substring(index * pat, (index + 1) * pat);
            if (ch == ch1) {
               if (!st1.equals(cur))
                   return false;
            } else {
                if (ch2 == '0') {
                    ch2 = ch;
                    st2 = cur;
                } else {
                    if (ch2 == ch && !st2.equals(cur))
                        return false;
                }
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String value = "dogdogdogdog";
        PatternMatching patternMatching = new PatternMatching();
        System.out.println(patternMatching.patternMatching(pattern, value));
    }
}
