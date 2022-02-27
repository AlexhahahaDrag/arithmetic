package string;

/**
 *description:
 * 6009. 使两字符串互为字母异位词的最少步骤数
 * 给你两个字符串 s 和 t 。在一步操作中，你可以给 s 或者 t 追加 任一字符 。
 *
 * 返回使 s 和 t 互为 字母异位词 所需的最少步骤数。
 *
 * 字母异位词 指字母相同但是顺序不同（或者相同）的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "leetcode", t = "coats"
 * 输出：7
 * 解释：
 * - 执行 2 步操作，将 "as" 追加到 s = "leetcode" 中，得到 s = "leetcodeas" 。
 * - 执行 5 步操作，将 "leede" 追加到 t = "coats" 中，得到 t = "coatsleede" 。
 * "leetcodeas" 和 "coatsleede" 互为字母异位词。
 * 总共用去 2 + 5 = 7 步。
 * 可以证明，无法用少于 7 步操作使这两个字符串互为字母异位词。
 * 示例 2：
 *
 * 输入：s = "night", t = "thing"
 * 输出：0
 * 解释：给出的字符串已经互为字母异位词。因此，不需要任何进一步操作。
 *
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 2 * 105
 * s 和 t 由小写英文字符组成
 *author:       alex
 *createDate:   2022/2/27 13:47
 *version:      1.0.0
 */
public class MinStepsII {

    public int minSteps1(String s, String t) {
        int[] map = new int[26];
        int i = 0;
        while(i < s.length()) {
            map[s.charAt(i++) - 'a']++;
        }
        i = 0;
        while(i < t.length()) {
            map[t.charAt(i++) - 'a']--;
        }
        int res = 0;
        for(int num : map) {
            if(num > 0) {
                res += num;
            } else if(num < 0) {
                res -= num;
            }
        }
        return res;
    }

    public int minSteps(String s, String t) {
        int[] map = new int[26];
        int i = 0;
        while(i < s.length()) {
            map[s.charAt(i++) - 'a']++;
        }
        i = -1;
        int res = 0;
        while(++i < t.length()) {
            if (map[t.charAt(i) - 'a'] > 0) {
                res++;
            }
            map[t.charAt(i) - 'a']--;
        }
        return s.length() + t.length() - (res << 1);
    }

    public static void main(String[] args) {
        String s = "night";
        String t = "thing";//5
        MinStepsII minStepsII = new MinStepsII();
        System.out.println(minStepsII.minSteps(s, t));
    }
}
