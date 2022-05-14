package string_array;

import java.util.Arrays;

/**
 *description:
 * 691. 贴纸拼词
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 *
 * 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 *
 * 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
 *
 * 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
 *
 *
 *
 * 示例 1：
 *
 * 输入： stickers = ["with","example","science"], target = "thehat"
 * 输出：3
 * 解释：
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 * 示例 2:
 *
 * 输入：stickers = ["notice","possible"], target = "basicbasic"
 * 输出：-1
 * 解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 *
 *
 * 提示:
 *
 * n == stickers.length
 * 1 <= n <= 50
 * 1 <= stickers[i].length <= 10
 * 1 <= target <= 15
 * stickers[i] 和 target 由小写英文单词组成
 *author:       alex
 *createDate:   2022/5/14 14:28
 *version:      1.0.0
 */
public class MinStickers {

    public int minStickers(String[] stickers, String target) {
        int len = target.length();
        int[] memo = new int[1 << len];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int res = dp(stickers, target, memo, (1 << len) - 1);
        return res <= len ? res : -1;
    }

    private int dp(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        if (memo[mask] < 0) {
            int res = m + 1;
            for(String sticker : stickers) {
                int left = mask;
                int[] map = new int[26];
                for(int i = 0; i < sticker.length(); i++) {
                    map[sticker.charAt(i) - 'a']++;
                }
                for(int j = 0; j < target.length(); j++) {
                    char cu = target.charAt(j);
                    if(((mask >> j) & 1) == 1 && map[cu - 'a'] > 0) {
                        map[cu - 'a']--;
                        left ^= 1 << j;
                    }
                }
                //如果left没有变化，代表该字符串与target没有交集
                if (left < mask) {
                    int ii = dp(stickers, target, memo, left) + 1;
                    res = Math.min(res, ii);
                }
            }
            memo[mask] = res;
        }
        return memo[mask];
    }


    public int minStickers1(String[] stickers, String target) {
        int m = target.length();
        int[] memo = new int[1 << m];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int res = dp1(stickers, target, memo, (1 << m) - 1);
        return res <= m ? res : -1;
    }

    public int dp1(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        if (memo[mask] < 0) {
            int res = m + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        cnt[c - 'a']--;
                        left ^= 1 << i;
                    }
                }
                if (left < mask) {
                    res = Math.min(res, dp1(stickers, target, memo, left) + 1);
                }
            }
            memo[mask] = res;
        }
        return memo[mask];
    }



    public static void main(String[] args) {
        String[] stickers = {"with","example","science"};
        String target = "thehat";
        MinStickers minStickers = new MinStickers();
        System.out.println(minStickers.minStickers(stickers, target));
        System.out.println(minStickers.minStickers1(stickers, target));
    }
}
