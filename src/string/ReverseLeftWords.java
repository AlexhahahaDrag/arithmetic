package string;


/**
 *description:
 * 面试题58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *author:       alex
 *createDate:  2020/2/28 15:06
 *version:      1.0.0      
*/
public class ReverseLeftWords {

    public String reverseLeftWords1(String s, int n) {
        if (s == null || s.length() < 1)
            return s;
        int len = s.length();
        n %= len;
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            res.append(s.charAt(i));
        res.reverse();
        for (int i = n; i < len; i++)
            sb.append(s.charAt(i));
        sb.reverse();
        res.append(sb);
        return res.reverse().toString();
    }

    public String reverseLeftWords2(String s, int n) {
        if (s == null || s.length() < 1)
            return s;
        int len = s.length();
        n %= len;
        StringBuilder res = new StringBuilder();
        for (int i = n; i < len; i++)
            res.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() < 1)
            return s;
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        System.out.println(reverseLeftWords.reverseLeftWords("abcdefg", 2));
    }
}
