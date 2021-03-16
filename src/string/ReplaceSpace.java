package string;

/**
 *description:
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *author:       alex
 *createDate:  2020/3/30 22:54
 *version:      1.0.0      
*/
public class ReplaceSpace {
    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace2(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace1(s));
    }
}
