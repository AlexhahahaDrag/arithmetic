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
    private int res = 0;
    private boolean[][] visited;
    PriorityQueue<Info> queue = new PriorityQueue<>();
    int[][] dictionary = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int trapRainWater(int[][] heightMap) {
        visited = new boolean[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            queue.add(new Info(i, 0, heightMap[i][0]));
            queue.add(new Info(i, heightMap[i].length - 1, heightMap[i][heightMap[i].length - 1]));
            visited[i][0] = true;
            visited[i][heightMap[i].length - 1] = true;
        }
        for (int j = 0; j < heightMap[0].length; j++) {
            queue.add(new Info(0, j, heightMap[0][j]));
            queue.add(new Info(heightMap.length - 1, j, heightMap[heightMap.length - 1][j]));
            visited[0][j] = true;
            visited[heightMap.length - 1][j] = true;
        }
        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            dfs(heightMap, cur.row, cur.column, cur.val);
        }
        return res;
    }

    private void dfs (int[][] heightMap, int x, int y, int val) {
        for(int[] i : dictionary) {
            visit(heightMap, x + i[0], y + i[1], val);
        }
    }

    private void visit(int[][] heightMap, int x, int y, int val) {
        if(x < 0 || y < 0 || x >= heightMap.length || y >= heightMap[x].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (val > heightMap[x][y]) {
            res += val - heightMap[x][y];
            heightMap[x][y] = val;
            dfs(heightMap, x, y, val);
        } else {
            queue.add(new Info(x, y, heightMap[x][y]));
        }
    }

    private static class Info implements Comparable<Info>{
        int row;
        int column;
        int val;
        public Info(int row, int column, int val){
            this.row = row;
            this.column = column;
            this.val = val;
        }

        @Override
        public int compareTo(Info o) {
            return val - o.val;
        }
    }

    public static void main(String[] args) {
//        int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        int[][] heightMap = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        TrapRainWater trapRainWater = new TrapRainWater();
        System.out.println(trapRainWater.trapRainWater(heightMap));
    }
}
