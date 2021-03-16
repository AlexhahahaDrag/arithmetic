package twoDimensionalArray;

import java.util.Arrays;

/**
 * @description:
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * @author:      alex
 * @createTime:  2020/11/4 10:33
 * @version:     1.0
 */
public class Insert {
    private int[][] res;
    private int size;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        size = 0;
        res = new int[intervals.length + 1][2];
        boolean flag = false;
        for(int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < left) {
                res[size++] = intervals[i];
            } else if (intervals[i][0] > right) {
                flag = true;
                res[size++] = new int[]{left, right};
                copy(res, intervals, i);
                break;
            } else {
                if (intervals[i][0] < left) {
                    left = intervals[i][0];
                }
                if (intervals[i][1] > right) {
                    right = intervals[i][1];
                }
            }
        }
        if (!flag) {
            res[size++] = new int[] {left, right};
        }
        return Arrays.copyOfRange(res, 0, size);
    }
    private void copy(int[][] res, int[][] source, int i) {
        while (i < source.length) {
            res[size++] = source[i++];
        }
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[][] intervals = {};
//        int[][] intervals = {{1, 2}};
//        int[][] intervals = {{10, 12}};
        int[][] intervals = {{5, 12}};
        int[] newInterval = {4,8};
        Insert insert = new Insert();
        int[][] res = insert.insert(intervals, newInterval);
        for (int[] i : res) {
            System.out.print("[" + i[0] + "," + i[1] + "]" + ",");
        }
    }
}
