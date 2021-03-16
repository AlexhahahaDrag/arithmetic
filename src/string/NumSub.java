package string;

/**
 *description:
 * 5461. 仅含 1 的子串数
 * 难度
 * 中等
 *
 * 0
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 * 返回所有字符都为 1 的子字符串的数目。
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 *
 * 示例 1：
 * 输入：s = "0110111"
 * 输出：9
 * 解释：共有 9 个子字符串仅由 '1' 组成
 * "1" -> 5 次
 * "11" -> 3 次
 * "111" -> 1 次
 * 示例 2：
 * 输入：s = "101"
 * 输出：2
 * 解释：子字符串 "1" 在 s 中共出现 2 次
 * 示例 3：
 * 输入：s = "111111"
 * 输出：21
 * 解释：每个子字符串都仅由 '1' 组成
 * 示例 4：
 * 输入：s = "000"
 * 输出：0
 *
 * 提示：
 * s[i] == '0' 或 s[i] == '1'
 * 1 <= s.length <= 10^5
 *author:       alex
 *createDate:   2020/7/12 21:05
 *version:      1.0.0
 */
public class NumSub {

    public int numSub(String s) {
        int index = -1;
        int len = s.length();
        int one = 0;
        int res = 0;
        while(++index < len) {
            if (s.charAt(index) == '1') {
                res = (res + ++one) % ((int) Math.pow(10, 9) + 7);
            } else {
                one = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "0110111";
        NumSub numSub = new NumSub();
        System.out.println(numSub.numSub(s));
    }
}
