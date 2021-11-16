package twoDimensionalArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *description:
 * 391. 完美矩形
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 *
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 * 示例 2：
 *
 *
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 * 示例 3：
 *
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
 * 输出：false
 * 解释：图形顶端留有空缺，无法覆盖成一个矩形。
 * 示例 4：
 *
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 *
 *
 * 提示：
 *
 * 1 <= rectangles.length <= 2 * 104
 * rectangles[i].length == 4
 * -105 <= xi, yi, ai, bi <= 105
 *author:       alex
 *createDate:   2021/11/16 12:38
 *version:      1.0.0
 */
public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        int xMin =  Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int aMax = Integer.MIN_VALUE;
        int bMax = Integer.MIN_VALUE;
        Map<Point, Integer> map = new HashMap<>();
        long area = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int x = rectangles[i][0];
            int y = rectangles[i][1];
            int a = rectangles[i][2];
            int b = rectangles[i][3];
            area += (long)(a - x) * (b - y);
            xMin = Math.min(x, xMin);
            yMin = Math.min(y, yMin);
            aMax = Math.max(a, aMax);
            bMax = Math.max(b, bMax);
            Point leftDown = new Point(x, y);
            Point leftTop = new Point(x, b);
            Point rightDown = new Point(a, y);
            Point rightTop = new Point(a, b);
            map.put(leftDown, map.getOrDefault(leftDown, 0) + 1);
            map.put(leftTop, map.getOrDefault(leftTop, 0) + 1);
            map.put(rightDown, map.getOrDefault(rightDown, 0) + 1);
            map.put(rightTop, map.getOrDefault(rightTop, 0) + 1);
        }
        Point leftDownMin = new Point(xMin, yMin);
        Point leftTopMin = new Point(xMin, bMax);
        Point rightDownMax = new Point(aMax, yMin);
        Point rightTopMax = new Point(aMax, bMax);
        if (area != (long)(aMax - xMin) * (bMax - yMin) || map.getOrDefault(leftDownMin, 0) != 1
                || map.getOrDefault(leftTopMin, 0) != 1 || map.getOrDefault(rightDownMax, 0) != 1
                || map.getOrDefault(rightTopMax, 0) != 1) {
            return false;
        }
        map.remove(leftDownMin);
        map.remove(leftTopMin);
        map.remove(rightDownMax);
        map.remove(rightTopMax);
        for(Integer value : map.values()) {
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }
    }

    public static void main(String[] args) {
        int[][] rectangles = {{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        IsRectangleCover isRectangleCover = new IsRectangleCover();
        System.out.println(isRectangleCover.isRectangleCover(rectangles));
    }
}
