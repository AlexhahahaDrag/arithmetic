package string;

/**
 * @description:
 * 1657. 确定两个字符串是否接近
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 *
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 *
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 示例 4：
 *
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅包含小写英文字母
 * @author:       majf
 * @createDate:   2023/11/30 17:58
 * @version:      1.0.0
 */
public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] map = new int[26];
        int len = word1.length();
        for (int i = 0; i < len; i++) {
            map[word1.charAt(i) - 'a']++;
            map[word2.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += map[i];
        }
        return sum == 0;
    }

    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "aabbss";
        CloseStrings closeStrings = new CloseStrings();
        System.out.println(closeStrings.closeStrings(word1, word2));
    }
}
