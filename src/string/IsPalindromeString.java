package string;

/**
 * @description:
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xah8k6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author:      alex
 * @createTime:  2020/8/4 16:45
 * @version:     1.0
 */
public class IsPalindromeString {

    public boolean isPalindrome1(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(start < end) {
            while(start < end && !Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start)))
                start++;
            while(start < end && !Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end)))
                end--;
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(start < end) {
            char cs = s.charAt(start);
            char ce = s.charAt(end);
            if (cs == ce) {
                start++;
                end--;
            } else if (!((cs >= 'a' && cs <= 'z') || (cs >= 'A' && cs <= 'Z') || (cs >= '0' && cs <= '9')))
                start++;
            else if (!((ce >= 'a' && ce <= 'z') || (ce >= 'A' && ce <= 'Z') || (ce >= '0' && ce <= '9')))
                end--;
            else {
                if ((cs & 0xDF) != (ce & 0xDF))
                    return false;
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        IsPalindromeString isPalindromeString = new IsPalindromeString();
        System.out.println(isPalindromeString.isPalindrome(s));
    }
}
