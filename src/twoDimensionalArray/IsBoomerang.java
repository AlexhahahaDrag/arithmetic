package twoDimensionalArray;

/**
 *description:
 * 1037. 有效的回旋镖
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 *
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 *
 *
 * 提示：
 *
 * points.length == 3
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 *author:       alex
 *createDate:   2022/6/8 6:53
 *version:      1.0.0
 */
public class IsBoomerang {

    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0])
                != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        IsBoomerang isBoomerang = new IsBoomerang();
        System.out.println(isBoomerang.isBoomerang(points));
    }
}
