package LCS;

/**
 * 给定两个字符串，求他们的最大公共子序列
 */
public class MaximumCommenSubsequence {
    public static void main(String[] args) {
        MaximumCommenSubsequence maximumCommenSubsequence = new MaximumCommenSubsequence();
        System.out.println(maximumCommenSubsequence.LCS("abcd","acd"));
    }
    private String LCS(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] lcs = new int[ch1.length + 1][ch2.length + 1];
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i-1] == ch2[j-1])
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int k = lcs[ch1.length][ch2.length];
        int i = ch1.length;
        int j = ch2.length;
        while (k > 0) {
            if (lcs[i][j] == lcs[i - 1][j]) i--;
            else if (lcs[i][j] == lcs[i][j - 1]) j--;
            else {
                stringBuilder.insert(0,ch1[i-1]);
                k--;i--;j--;
            }
        }
        return stringBuilder.toString();
    }
}
