package string;

import java.util.Arrays;

/**
 * @Description: 查找字符串中的最大的回文数
 * @Author:     alex
 * @CreateDate: 2019/6/26 17:38
 * @Version:    1.0
 *
*/
public class Manacher {
    public static void main(String[] args) {
        Manacher manacher = new Manacher();
        System.out.println(manacher.getMaxPelindromePosition("abcbaabc"));
    }
    private int getMaxPelindromePosition(String str) {
        if (str == null)
            return -1;
        int len = str.length();
        if (len == 1)
            return 0;
        char[] strChar = new char[(len << 1) + 2];
        int[] results = new int[strChar.length];
        Arrays.fill(strChar, '#');
        strChar[0] = 'S';
        int st = 2;
        int stst = 0;
        while(stst < len) {
            strChar[st] = str.charAt(stst++);
            st += 2;
        }
        for (int i = 0; i < strChar.length; i++) {

        }
        return 1;
    }
}
