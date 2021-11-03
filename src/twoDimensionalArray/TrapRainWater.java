package twoDimensionalArray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 407. 接雨水 II
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * 示例 2:
 *
 *
 *
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 *
 *
 * 提示:
 *
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 */
public class TrapRainWater {

    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        Queue<int[], Integer> queue = new PriorityQueue<>((o1, o2) -> o2 );
        for (int i = 0; i < heightMap.length; i++) {
            queue.add(new int[]{i, 0}, heightMap[i][0]);
            queue.add(heightMap[i][heightMap[i].length - 1]);
        }
        for (int j = 0; j < heightMap[0].length; j++) {
            queue.add(heightMap[0][j]);
            queue.add(heightMap[heightMap[0].length - 1][j]);
        }
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

        }
        return res;
    }

    private

    public static void main(String[] args) {
        int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        TrapRainWater trapRainWater = new TrapRainWater();
        System.out.println(trapRainWater.trapRainWater(heightMap));
    }
}
