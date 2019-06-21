package string;

import java.util.Arrays;

/**
 * @Description: 已知一个字符串s= "findinahedleaysnaedletackneedleina";
 *                         求t="needle"在他中的位置
 * @Author:     alex
 * @CreateDate: 2019/6/20 17:40
 * @Version:    1.0
 *
*/
public class BMArgorithm {
    public static void main(String[] args) {
        BMArgorithm bmArgorithm = new BMArgorithm();
        String s = "abchbcaaabcfiabciabcaaabcndinahedleaysnaedletackneedleina";
        String t = "abcabcaaabc";
        System.out.println(bmArgorithm.getBM(s, t));
    }
    public int getBM(String target, String pattern) {
        int pLen = pattern.length() - 1;
        int tLen = target.length() - 1;
        if (pLen > tLen)
            return -1;
        int[] bad_table = bad_char_table(pattern);
        int[] good_table = good_char_table(pattern);
        for (int i = pLen - 1, j; i < tLen; ) {
            System.out.println("跳跃位置：" + i);
            for (j = pLen - 1; pattern.charAt(j) == target.charAt(i) ; i--,j--) {
                if (j == 0) {
                    System.out.println("匹配成功，位置：" + i);
                    return i;
                }
            }
            i += Math.max(good_table[pLen - j - 1], bad_table[target.charAt(i)]);
        }
        return -1;
    }

    /**
     * @Description: 创建坏的字符串数组
     * @Author:      alex
     * @CreateDate:  2019/6/21 13:47
     * @param
     * @return
    */
    public int[] bad_char_table(String str) {
        int len = str.length();
        int[] bad_table = new int[65536];
       Arrays.fill(bad_table, -1);
        for (int j = 0; j < len; j++)
            bad_table[str.charAt(j)] = len - j -1;
        return bad_table;
    }

    /**
     * @Description: 创建好的字符串数组
     * @Author:      alex
     * @CreateDate:  2019/6/21 13:47
     * @param
     * @return
    */
    public int[] good_char_table(String str) {
        int[] good_table = new int[65536];
        Arrays.fill(g);
        int lastPrefixPosition = plen;
        for (int i = plen - 1; i >= 0; i--) {
            if (isPrefix(str, i + 1))
                lastPrefixPosition = i + 1;
            good_table[plen - 1 - i] = lastPrefixPosition - i + plen - 1;
        }
        for (int i = 0; i < plen - 1; ++i) {
            int slen = suffixLen(str, i);
            good_table[slen] = plen - 1 - i + slen;
        }
        return good_table;
    }
    /**
     * @Description: 前缀匹配
     * @Author:      alex
     * @CreateDate:  2019/6/21 13:21
     * @param
     * @return
    */
    public boolean isPrefix(String pattern, int p) {
        int len = pattern.length();
        for (int i = p, j = 0; i < len; i++, j++) {
            if (pattern.charAt(i) != pattern.charAt(j))
                return false;
        }
        return true;
    }

    /**
     * @Description: 后缀匹配
     * @Author:      alex
     * @CreateDate:  2019/6/21 13:25
     * @param
     * @return
    */
    public int suffixLen(String pattern, int p) {
        int plen = pattern.length();
        int len = 0;
        for (int i = p, j = plen - 1; i >= 0 && pattern.charAt(i) == pattern.charAt(j); i--, j--)
            len += 1;
        return len;
    }
}
