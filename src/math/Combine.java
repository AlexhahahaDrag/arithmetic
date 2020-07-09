package math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Author:      alex
 * CreateDate:  2020/7/8 10:29
 * Version:     1.0
 *
*/
public class Combine {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine1(int n, int k) {
        if (n < k)
            return res;
        com(n, 0, new Integer[k], 0, k);
        return res;
    }

    private void com(int n, int start, Integer[] list, int index,  int k) {
        if (k == index) {
            res.add(Arrays.asList(list));
            return;
        }
        for (int i = start + 1; i <= n - k + index + 1; i++) {
            Integer[] cur = Arrays.copyOfRange(list, 0, k);
            cur[index] = i;
            com(n, i, cur, index + 1, k);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k)
            return res;
        comb(n, 0, k);
        return res;
    }

    private void comb(int n, int start, int k) {
        if (k == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start + 1; i <= n - k + 1; i++) {
            list.add(i);
            comb(n, i, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combine combine = new Combine();
        System.out.println(combine.combine1(n, k));
    }
}
