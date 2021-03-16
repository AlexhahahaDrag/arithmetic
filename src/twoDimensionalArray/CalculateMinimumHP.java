package twoDimensionalArray;

import java.util.Arrays;

/**
 *description:
 * 174. 地下城游戏
 * 难度
 * 困难
 *
 * 294
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * -2 (K)
 * -3
 * 3
 * -5
 * -10
 * 1
 * 10
 * 30
 * -5 (P)
 *
 * 说明:
 * 骑士的健康点数没有上限。
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 *author:       alex
 *createDate:   2020/7/12 20:26
 *version:      1.0.0
 */
public class CalculateMinimumHP {

    private int min = Integer.MIN_VALUE;
    public int calculateMinimumHP1(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return -1;
        }
        int row = dungeon.length;
        int column = dungeon[0].length;
        find(dungeon, row - 1, column - 1, 0);
        return -min + 1;
    }

    private void find(int[][] dungeon, int i, int j, int hp) {
        hp = dungeon[i][j] + hp;
        hp =  hp > 0 ? 0 : hp;
        if (i == 0 && j == 0) {
            min = Math.max(hp, min);
            return;
        }
        if (i - 1 >= 0) {
            find(dungeon, i - 1, j, hp);
        }
        if (j - 1 >= 0) {
            find(dungeon, i, j - 1, hp);
        }
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return -1;
        }
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] map = new int[row][column];
        map[row - 1][column - 1] = dungeon[row - 1][column - 1] > 0 ? 0 : dungeon[row - 1][column - 1];
        for (int i = row - 2; i >= 0; i--) {
            int cur = dungeon[i][column - 1] + map[i + 1][column - 1];
            map[i][column - 1] = cur > 0 ? 0 : cur;
        }
        for (int i = column - 2; i >= 0; i--) {
            int cur = dungeon[row - 1][i] + map[row - 1][i + 1];
            map[row - 1][i] = cur > 0 ? 0 : cur;
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                int now = Math.max(map[i + 1][j], map[i][j + 1]) + dungeon[i][j];
                map[i][j] = now > 0 ? 0 : now;
            }
        }
        return -map[0][0] + 1;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return -1;
        }
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[row][column - 1] = dp[row - 1][column] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{0, -3}};
        CalculateMinimumHP calculateMinimumHP = new CalculateMinimumHP();
        System.out.println(calculateMinimumHP.calculateMinimumHP(dungeon));
    }
}
