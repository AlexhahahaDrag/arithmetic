package string;

/**
 * Description:
 * 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 *
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 *
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 *
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 *
 * 输入：s = "tryhard", k = 4
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 * Author:      alex
 * CreateDate:  2020/6/15 12:54
 * Version:     1.0
 *
*/
public class MaxVowels {

    public int maxVowels1(String s, int k) {
        if (s.isEmpty() || k == 0) {
            return 0;
        }
        int max = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len && i < k; i++) {
            if (judge(chars[i])) {
                max++;
            }
        }
        if (max == k) {
            return max;
        }
        int cur = max;
        for(int i = k; i < len; i++) {
            cur += (judge(chars[i]) ? 1 : 0) - (judge(chars[i - k]) ? 1 : 0);
            max = Math.max(max, cur);
            if (max == k) {
                return max;
            }
        }
        return max;
    }

    private boolean judge(char ch) {
        switch (ch) {
            case 'a' :
            case 'i' :
            case 'e' :
            case 'o' :
            case 'u' :
                return true;
            default:
                return false;
        }
    }

    public int maxVowels(String s, int k) {
        if (s.isEmpty() || k == 0 || k > s.length()) {
            return 0;
        }
        int max = 0;
        int len = s.length();
        int[] map = new int[26];
        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        for (char ch : chars) {
            map[ch - 'a']++;
        }
        for (int i = 0; i < len && i < k; i++) {
            max += map[s.charAt(i) - 'a'];
        }
        if (max == k) {
            return max;
        }
        int cur = max;
        for(int i = k; i < len; i++) {
            cur += map[s.charAt(i) - 'a'] - map[s.charAt(i - k) - 'a'];
            max = Math.max(max, cur);
            if (max == k) {
                return max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        MaxVowels maxVowels = new MaxVowels();
        System.out.println(maxVowels.maxVowels(s, k));
    }
}
