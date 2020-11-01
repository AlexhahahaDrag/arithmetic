package array;
import java.util.Arrays;

public class KthSmallestPath {

    public String kthSmallestPath1(int[] d, int k) {
        char[] ch = new char[d[0] + d[1]];
        int row = d[0];
        int column = d[1];
        int index = 0;
        while(column-- > 0) {
            ch[index++] = 'H';
        }
        while(row-- > 0) {
            ch[index++] = 'V';
        }
        while(--k > 0) {
            int in = ch.length - 1;
            while(in >= 1 && ch[in] <= ch[in - 1])
                in--;
            if (in >= 1) {
                char temp = ch[in];
                ch[in] = ch[in - 1];
                ch[in - 1] = temp;
            }
            Arrays.sort(ch, in, ch.length);
        }
        return new String(ch);
    }

    public String kthSmallestPath(int[] d, int k) {
        char[] ch = new char[d[0] + d[1]];
        int[][] dp = new int[d[0] + 1][d[1] + 1];
        for (int i = 0; i <= d[0]; i++)
            dp[i][d[1]] = 1;
        for (int i = 0; i <= d[1]; i++)
            dp[0][i] = 1;
        for (int i = 1; i <= d[0]; i++) {
            for (int j = d[1] - 1; j >= 0; j--) {
                dp[i][j] = dp[i - 1][j] + dp[i][j + 1];
            }
        }
        find(dp, 0, 0, ch, 0, k);
        return new String(ch);
    }

    private void find(int[][] dp, int i, int j, char[] ch, int index, int k) {
        if (i == dp.length - 1)
            return;
        if (dp[i + 1][j] <= k) {
            ch[index++] = 'V';
            if (k != 1 && k == dp[i + 1][j])
                k -= dp[i][j + 1];
            find(dp, i + 1, j, ch, index, k);
        } else {
            ch[index++] = 'H';
            find(dp, i, j + 1, ch, index, k);
        }
    }
    public static void main(String[] args) {
        int[] d = {2,3};
        int k = 3;
//        int[] d = {15,15};
//        int k = 155117520;
        KthSmallestPath kthSmallestPath = new KthSmallestPath();
        System.out.println(kthSmallestPath.kthSmallestPath(d, k));
    }
}

