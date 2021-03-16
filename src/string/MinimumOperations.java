package string;

import java.util.Arrays;

/**
 *description:
 * 3. 秋叶收藏集
 * 通过的用户数122
 * 尝试过的用户数263
 * 用户总通过次数122
 * 用户总提交次数370
 * 题目难度Medium
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 示例 1：
 *
 * 输入：leaves = "rrryyyrryyyrr"
 *
 * 输出：2
 *
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 *
 * 示例 2：
 *
 * 输入：leaves = "ryr"
 *
 * 输出：0
 *
 * 解释：已符合要求，不需要额外操作
 *
 * 提示：
 *
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 *author:       alex
 *createDate:   2020/9/12 15:30
 *version:      1.0.0
 */
public class MinimumOperations {
    public int minimumOperations(String leaves) {
        char[] ch = leaves.toCharArray();
        int[][] dp = new int[3][ch.length];
        for (int i = 0; i < ch.length; i++) {
            if (i < 1) {
                dp[0][i] = ch[i] == 'r' ? 0 : 1;
            } else {
                dp[0][i] = dp[0][i - 1] + (ch[i] == 'r' ? 0 : 1);
            }
            if (i < 1) {
                dp[1][i] = ch[i] == 'r' ? 0 : 1;
            } else {
                dp[1][i] = Math.min(dp[0][i - 1] + (ch[i] == 'r' ? 1 : 0), dp[1][i - 1] + (ch[i] == 'r' ? 1 : 0));
            }
            if (i < 2) {
                dp[2][i] = dp[1][i];
            } else {
                dp[2][i] = Math.min(dp[2][i - 1] + (ch[i] == 'r' ? 0 : 1), dp[1][i - 1] + (ch[i] == 'r' ? 0 : 1));
            }
        }
        return dp[2][ch.length - 1];
    }

    public static void main(String[] args) {
        ///String leaves = "ryyyrrrryrryyyyrrryrryyyryrryryyrryyyryyryyyyryrrryryyryrryyryryryrryyrryyyryrrryryryrrrryrrrrrryry";
        //String leaves = "ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy";
        String leaves = "yry";
        //String leaves = "yyyyyyyyyyyyyyyyyy";
        StringBuilder sb = new StringBuilder();
        MinimumOperations minimumOperations = new MinimumOperations();
        System.out.println(minimumOperations.minimumOperations(leaves));
    }
}
