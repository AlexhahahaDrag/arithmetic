package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * Author:      alex
 * CreateDate:  2020/7/14 12:30
 * Version:     1.0
 *
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] cur = new int[triangle.size() + 1];
        Arrays.fill(cur, Integer.MAX_VALUE);
        cur[1] = 0;
        for (List<Integer> integers : triangle) {
            for (int j = integers.size() - 1; j >= 0; j--) {
                cur[j + 1] = integers.get(j) + Math.min(cur[j + 1], cur[j]);
            }
        }
        int min = cur[0];
        for (int i : cur) {
            min = Math.min(min, i);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
       List<Integer> li1 = new ArrayList<>();
        li1.add(2);
        List<Integer> li2 = new ArrayList<>();
        li2.add(3);
        li2.add(4);
        List<Integer> li3 = new ArrayList<>();
        li3.add(6);
        li3.add(5);
        li3.add(7);
        List<Integer> li4 = new ArrayList<>();
        li4.add(4);
        li4.add(1);
        li4.add(8);
        li4.add(3);
        triangle.add(li1);
        triangle.add(li2);
        triangle.add(li3);
        triangle.add(li4);
        MinimumTotal minimumTotal = new MinimumTotal();
        System.out.println(minimumTotal.minimumTotal(triangle));
    }
}
