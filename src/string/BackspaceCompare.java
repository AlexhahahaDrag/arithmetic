package string;

/**
 *description:
 * 844. 比较含退格的字符串
 * 比较含退格的字符串 显示英文描述
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 *author:       alex
 *createDate:  2020/2/4 13:34
 *version:      1.0.0      
*/
public class BackspaceCompare {

    public boolean backspaceCompare1(String S, String T) {
        return getStr(S).equals(getStr(T));
    }

    private String getStr(String s) {
        char[] str = s.toCharArray();
        for (int i = 1; i < str.length; i++) {
            if (str[i] == '#') {
                int in = i - 1;
                while(in >= 1 && str[in] == '#'){
                    in--;
                }
                str[in] = '#';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : str) {
            if (ch != '#') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        int sl = S.length() - 1;
        int tl = T.length() - 1;
        int ss = 0;
        while(sl >= 0 && tl >= 0) {
            while(sl >= 0 && (S.charAt(sl) == '#' || ss > 0)) {
                if (S.charAt(sl) == '#') {
                    ss++;
                } else {
                    ss--;
                }
                sl--;
            }
            while(tl >= 0 && (T.charAt(tl) == '#' || ss > 0)) {
                if (T.charAt(tl) == '#') {
                    ss++;
                } else {
                    ss--;
                }
                tl--;
            }
           if (sl >= 0 && tl >= 0) {
                if (S.charAt(sl) != T.charAt(tl)) {
                    return false;
                }
                sl--;
                tl--;
            }
        }
        while(sl >= 0 && (S.charAt(sl) == '#')) {
            sl -= 2;
        }
        while(tl >= 0 && T.charAt(tl) == '#') {
            tl -= 2;
        }
        return sl < 0 && tl < 0;
    }

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
//        String S = "ab#c";
//        String T = "ad#c";
//        String S = "ab##";
//        String T = "c#d#";
//        String S = "bxj##tw";
//        String T = "bxo#j##tw";
//        String S = "bxj##tw";
//        String T = "bxj###tw";

        String S = "nzp#o#g";
        String T = "b#nzp#o#g";
        System.out.println(backspaceCompare.backspaceCompare(S, T));
    }
}
