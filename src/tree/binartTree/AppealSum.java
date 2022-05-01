package tree.binartTree;

import java.util.Arrays;

public class AppealSum {
    public long appealSum1(String s) {
        long sum = 0;
        int len = s.length();
        int[][] map = new int[len + 1][26];
        for (int i = 0; i < len; i++) {
            map[i + 1] = Arrays.copyOfRange(map[i], 0, 26);
            map[i + 1][s.charAt(i) - 'a']++;
        }
        for(int j = 1; j <= len; j++) {
            for (int k = 0; k <= len - j; k++) {
                for (int l = 0; l < 26; l++) {
                    if (map[k + j][l] - map[k][l] > 0) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public long appealSum(String s) {
        long sum = 0;
        int ans = 0;
        int[] map = new int[26];
        Arrays.fill(map, - 1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            sum += i - map[c];
            ans += sum;
            map[c] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "abbca";//28
//        String s = "code";//20
        String s = "codedsafdfdsfdskjfdskfjdslkjfdsfjdksfjsldfjsdolf";//20
        AppealSum appealSum = new AppealSum();
        System.out.println(appealSum.appealSum(s));
        System.out.println(appealSum.appealSum1(s));
    }
}
