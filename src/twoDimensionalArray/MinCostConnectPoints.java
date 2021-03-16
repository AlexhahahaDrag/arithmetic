package twoDimensionalArray;

import java.util.Arrays;

/**
 *description:
 * 5513. 连接所有点的最小费用 显示英文描述
 * 通过的用户数716
 * 尝试过的用户数1065
 * 用户总通过次数722
 * 用户总提交次数1710
 * 题目难度Medium
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 *author:       alex
 *createDate:   2020/9/13 11:47
 *version:      1.0.0
 */
public class MinCostConnectPoints {

    private int[] map;
    public int minCostConnectPoints(int[][] points) {
        int res = 0;
        map = new int[points.length];
        Arrays.fill(map, -1);
        for (int i = 0; i < points.length; i++) {
            res += findMin(points, i);
        }
        return res;
    }

    private int findMin(int[][] points, int i) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < points.length ; j++) {
            if (j == i) {
                continue;
            }
            int cur = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            if (cur < min && map[j] != i) {
                min = cur;
                map[i] = j;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] points = {{11,-6},{9,-19},{16,-13},{4,-9},{20,4},{20,7},{-9,18},{10,-15},{-15,3},{6,6}};
        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
        System.out.println(minCostConnectPoints.minCostConnectPoints(points));
    }
}
