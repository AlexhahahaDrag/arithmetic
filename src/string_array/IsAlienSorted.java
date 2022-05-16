package string_array;

/**
 *description:
 * 953. 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 *author:       alex
 *createDate:   2022/5/17 6:17
 *version:      1.0.0
 */
public class IsAlienSorted {

    private int[] map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new int[26];
        for(int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        String pre = words[0];
        for(int j = 1; j < words.length; j++) {
            if (!judge(pre, words[j])) {
                return false;
            }
            pre = words[j];
        }
        return true;
    }

    private boolean judge(String str1, String str2) {
        int i = -1;
        int len = Math.min(str1.length(), str2.length());
        while(++i < len) {
            int n1 = map[str1.charAt(i) - 'a'];
            int n2 = map[str2.charAt(i) - 'a'];
            if (n1 > n2) {
                return false;
            } else if (n1 < n2) {
                return true;
            }
        }
        return i == str1.length();
    }

    public static void main(String[] args) {
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        IsAlienSorted isAlienSorted = new IsAlienSorted();
        System.out.println(isAlienSorted.isAlienSorted(words, order));
    }
}
