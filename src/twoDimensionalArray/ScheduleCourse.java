package twoDimensionalArray;

import java.util.*;

/**
 * @description:
 * 630. 课程表 III
 * 提示
 * 困难
 * 444
 * 相关企业
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 *
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 *
 * 返回你最多可以修读的课程数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出：3
 * 解释：
 * 这里一共有 4 门课程，但是你最多可以修 3 门：
 * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
 * 示例 2：
 *
 * 输入：courses = [[1,2]]
 * 输出：1
 * 示例 3：
 *
 * 输入：courses = [[3,2],[4,3]]
 * 输出：0
 *
 *
 * 提示:
 *
 * 1 <= courses.length <= 104
 * 1 <= durationi, lastDayi <= 104
 * @author:       majf
 * @createDate:   2023/9/11 9:31
 * @version:      1.0.0
 */
public class ScheduleCourse {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return  a[1] - b[1];
        });
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        for (int[] c : courses) {
            if (c[0] > c[1]) {
                continue;
            }
            if (res + c[0] <= c[1] ) {
                res += c[0];
                queue.add(c[0]);

            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                res -= queue.poll() - c[0];
                queue.add(c[0]);
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
//        int[][] courses = {{5,5},{4,6},{2,6}}; // 2
        int[][] courses = {{100, 100}, {200, 300}, {950, 1250}, {2000, 3200}}; // 4
//        int[][] courses =  {{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}}; // 4
        ScheduleCourse scheduleCourse = new ScheduleCourse();
        System.out.println(scheduleCourse.scheduleCourse(courses));
    }
}
