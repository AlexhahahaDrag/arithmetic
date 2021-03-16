package array;
import java.util.Arrays;

/**
 * @description:
 * 1643. 第 K 条最小指令
 * Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。他只能向 右 或向 下 走。你可以为 Bob 提供导航 指令 来帮助他到达目的地 destination 。
 *
 * 指令 用字符串表示，其中每个字符：
 *
 * 'H' ，意味着水平向右移动
 * 'V' ，意味着竖直向下移动
 * 能够为 Bob 导航到目的地 destination 的指令可以有多种，例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
 *
 * 然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k  的编号 从 1 开始 。
 *
 * 给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的 按字典序排列后的第 k 条最小指令 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：destination = [2,3], k = 1
 * 输出："HHHVV"
 * 解释：能前往 (2, 3) 的所有导航指令 按字典序排列后 如下所示：
 * ["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH", "VHVHH", "VVHHH"].
 * 示例 2：
 *
 *
 *
 * 输入：destination = [2,3], k = 2
 * 输出："HHVHV"
 * 示例 3：
 *
 *
 *
 * 输入：destination = [2,3], k = 3
 * 输出："HHVVH"
 *
 *
 * 提示：
 *
 * destination.length == 2
 * 1 <= row, column <= 15
 * 1 <= k <= nCr(row + column, row)，其中 nCr(a, b) 表示组合数，即从 a 个物品中选 b 个物品的不同方案数。
 * @author:      alex
 * @createTime:  2020/11/2 17:14
 * @version:     1.0
 */
public class KthSmallestPath {

    public String kthSmallestPath1(int[] d, int k) { //超时
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
            while(in >= 1 && ch[in] <= ch[in - 1]) {
                in--;
            }
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
        for (int i = 0; i <= d[0]; i++) {
            dp[i][d[1]] = 1;
        }
        for (int i = 0; i <= d[1]; i++) {
            dp[d[0]][i] = 1;
        }
        for (int i = d[0] - 1; i >= 0; i--) {
            for (int j = d[1] - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        find(dp, 0, 0, ch, 0, k);
        return new String(ch);
    }

    private void find(int[][] dp, int i, int j, char[] ch, int index, int k) {
        if (i == dp.length - 1) {
            while(index < ch.length) {
                ch[index++] = 'H';
            }
            return;
        }
        if (j == dp[i].length - 1) {
            while(index < ch.length) {
                ch[index++] = 'V';
            }
            return;
        }
        if (dp[i][j + 1] >= k) {
            ch[index++] = 'H';
            find(dp, i, j + 1, ch, index, k);
        } else {
            ch[index++] = 'V';
            find(dp, i + 1, j, ch, index, k - dp[i][j + 1]);
        }
    }
    public static void main(String[] args) {
//        int[] d = {2,3};
//        int k = 2;
        int[] d = {15,15};
        int k = 155117520;
        KthSmallestPath kthSmallestPath = new KthSmallestPath();
        System.out.println(kthSmallestPath.kthSmallestPath1(d, k));
        System.out.println(kthSmallestPath.kthSmallestPath(d, k));
    }
}

