package string;

/**
 *description:
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *author:       alex
 *createDate:  2020/2/18 19:41
 *version:      1.0.0      
*/
public class IsFlipedString {

    public boolean isFlipedString1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        int index = 0;
        int len = s1.length();
        while(index < len) {
            if((s1.substring(index).equals(s2.substring(0, len -index))) &&
                    (s1.substring(0, index).equals(s2.substring(len - index)))) {
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        String s = s1 + s1;
        return s.indexOf(s2) >= 0;
    }

    public static void main(String[] args) {
        IsFlipedString isFlipedString = new IsFlipedString();
        System.out.println(isFlipedString.isFlipedString("1111", "111"));
    }
}
