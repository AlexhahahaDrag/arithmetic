package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *description:
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *author:       alex
 *createDate:  2020/3/6 8:15
 *version:      1.0.0
*/
public class FindContinuousSequence {

    public int[][] findContinuousSequence1(int target) {
        List<int[]> list = new ArrayList<>();
        int len = target + 1 >> 1;
        int start = 1;
        int sum;
        int index;
        while(start < len) {
            sum = start;
            index = start + 1;
            while(sum < target) {
                sum += index++;
            }
            if(sum == target) {
                int[] res = new int[index - start];
                for (int i = start; i < index; i++) {
                    res[i - start] = i;
                }
                list.add(res);
            }
            start++;
        }
        int[][] map = new int[list.size()][];
        return list.toArray(map);
    }

    public int[][] findContinuousSequence(int target) {
        int end = target + 1 >> 1;
        int[][] map = new int[end][];
        int start = 1;
        int sum = 0;
        int[] or = new int[(target + 1 >> 1) + 1];
        int count = 0;
        for (int i = 0; i < or.length; i++) {
            or[i] = i;
            sum += i;
        }
        int le = end;
        while(start < end) {
            int cur = sum;
            while(cur > target) {
                cur -= end--;
            }
            if (cur == target) {
                map[count++] = Arrays.copyOfRange(or, start, end + 1);
            }
            sum -= start++;
            end = le;
        }
        return Arrays.copyOf(map, count);
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        int[][] res = findContinuousSequence.findContinuousSequence1(15);
        for(int[] re : res) {
            for(int i : re) {
                System.out.print(i + "    ");
            }
            System.out.println();
        }

    }
}
