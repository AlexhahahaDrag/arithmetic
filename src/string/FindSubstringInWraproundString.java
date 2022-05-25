package string;

/**
 *description:
 *author:       alex
 *createDate:   2022/5/25 8:04
 *version:      1.0.0
 * 467. 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." .
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 示例 2:
 *
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * 示例 3:
 *
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 *
 *
 * 提示:
 *
 * 1 <= p.length <= 105
 * p 由小写英文字母构成
 */
public class FindSubstringInWraproundString {

    public int findSubstringInWraproundString(String p) {
        int[] map = new int[26];
        int i = 0;
        int len = p.length();
        int next = (p.charAt(0) - 'a' + 1) % 26;
        int k = 1;
        map[p.charAt(0) - 'a'] = 1;
        char cur;
        while(++i < len) {
            cur = p.charAt(i);
            if (next == cur - 'a') {
                k++;
            } else {
                k = 1;
            }
            next = (cur - 'a' + 1) % 26;
            map[cur - 'a'] = Math.max(map[cur -'a'], k);
        }
        int res = 0;
        for(int num : map) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        String p = "zab";
        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString(p));
    }
}
