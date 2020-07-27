package string;

/**
 * @description:
 * 392. 判断子序列
 * 难度
 * 简单
 *
 * 258
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
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 * 后续挑战 :
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * @author:      alex
 * @createTime:  2020/7/27 12:11
 * @version:     1.0
 */
public class IsSubsequence {

    public boolean isSubsequence1(String s, String t) {
        int si = 0;
        int ti = 0;
        int sl = s.length();
        int tl = t.length();
        while(si < sl && ti < tl && sl - si <= tl - ti) {
            char s1 = s.charAt(si);
            char t1 = t.charAt(ti);
            if (s1 == t1)
                si++;
            ti++;
        }
        return si == sl;
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char si : s.toCharArray()) {
            index = t.indexOf(si, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "ahbgdcs";
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence(s, t));
    }
}
