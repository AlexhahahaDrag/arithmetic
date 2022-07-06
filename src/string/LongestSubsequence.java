package string;

import java.util.Arrays;

/**
 *description:  
 *author:       alex
 *createDate:   2022/6/19 11:06
 *version:      1.0.0
 */
public class LongestSubsequence {

    private int res = 0;
    private int[] map;
    public int longestSubsequence1(String s, int k) {
        int len = s.length();
        map = new int[len + 1];
        for(int i = 0; i < len; i++) {
            map[i + 1] = map[i] + (s.charAt(i) == '0' ? 1 : 0);
        }
        dfs(s, len - 1, 0, k, 0);
        return res;
    }

    private void dfs(String s, int i, int sum, int k, int len) {
        if (i < 0) {
            res = Math.max(res, len);
            return;
        }
        //不添加当前字符
        dfs(s, i - 1, sum, k, len);
        sum += (s.charAt(i) - '0') << len;
        if (sum > k) {
            res = Math.max(res, len + map[i]);
            return ;
        }
        dfs(s, i - 1, sum, k, len + 1);
    }

    public int longestSubsequence(String s, int k) {
        int len = s.length();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0;
        int res = 0;
        for(int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[i] > k + 1) {
                    break;
                }
                dp[j + 1] = Math.min((dp[j] << 1) + s.charAt(i) - '0', dp[j + 1]);
                if(dp[j + 1] <= k) {
                    res = Math.max(j + 1, res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "1001010";
//        int k = 5;//5
        String s = "001010101011010100010101101010010";
        int k = 93951055;//31
//        String s = "00101001";
//        int k = 1;//6
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        System.out.println(longestSubsequence.longestSubsequence(s, k));
        System.out.println(longestSubsequence.longestSubsequence1(s, k));
    }
}
