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
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < strChar.length; i++) {
            results[i] = R > i ? Math.min(R - i + 1, results[(c << 1) - i]) : 1;
            while (i + results[i] < strChar.length && i -results[i] > -1)
                if (strChar[i + results[i]] == strChar[i - results[i]])
                    results[i]++;
                else
                    break;
            if (i + results[i] > R) {
                R = i + results[i] - 1;
                c = i;
            }
            max = Math.max(max, results[i] - 1);
        }
        return max;
    }
}
