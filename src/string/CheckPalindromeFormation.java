package string;

/**
 * @description:
 * 1616. 分割两个字符串得到回文串
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 *
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 *
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 *
 * 请注意， x + y 表示连接字符串 x 和 y 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = "x", b = "y"
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * 那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
 * 示例 2：
 *
 * 输入：a = "ulacfd", b = "jizalu"
 * 输出：true
 * 解释：在下标为 3 处分割：
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * 那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
 *
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 105
 * a.length == b.length
 * a 和 b 都只包含小写英文字母
 * @author:      alex
 * @createTime:  2020/10/13 13:41
 * @version:     1.0
 */
public class CheckPalindromeFormation {

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int len = a.length();
        int mid = len >> 1;
        int start = mid - 1;
        int end = len % 2 == 0 ? mid : mid + 1;
        while(start >= 0 && end < len && a.charAt(start) == a.charAt(end)) {
            start--;
            end++;
        }
        if (start < 0 || end >= len) {
            return true;
        }
        return checkStr(a, b, start, end, len) || checkStr(b, a, start, end, len);
    }

    private boolean checkStr(String a, String b, int start, int end, int len) {
        while(start >= 0 && end < len && a.charAt(start) == b.charAt(end)) {
            start--;
            end++;
        }
        return start < 0;
    }

    public static void main(String[] args) {
        String a = "";
        String b = "";
        CheckPalindromeFormation checkPalindromeFormation = new CheckPalindromeFormation();
        System.out.println(checkPalindromeFormation.checkPalindromeFormation(a, b));
    }
}
