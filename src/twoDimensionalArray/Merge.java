package twoDimensionalArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 *description:  56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *author:       alex
 *createDate:  2020/4/16 21:38
 *version:      1.0.0      
*/
public class Merge {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return intervals;
        sort(intervals);
        int size = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[size][1] >= intervals[i][0]) {
                if (intervals[size][1] >= intervals[i][1])
                    continue;
                else
                    intervals[size][1] = intervals[i][1];
            } else {
                size++;
                intervals[size][0] = intervals[i][0];
                intervals[size][1] = intervals[i][1];
            }

        }
        return Arrays.copyOfRange(intervals, 0, size + 1);
    }

    private void sort(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    }

    public static void main(String[] args) {
        int[][] intervals = {};
        Merge merge = new Merge();
        int[][] res = merge.merge(intervals);
        for (int[] i : res) {
            for (int ij : i)
                System.out.println(ij);
        }
    }
}
