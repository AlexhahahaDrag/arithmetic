package math;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 1 <= n <= 5 * 104
 *author:       alex
 *createDate:   2022/4/18 21:46
 *version:      1.0.0
 */
public class LexicalOrder {

    private List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for(int i = 1; i <= 9 && i <= n; i++) {
            res.add(i);
            if (i * 10 <= n) {
                find(i * 10, n);
            }
        }
        return res;
    }

    private void find(int i, int n) {
        for(int j = i; j <= i + 9 && j <= n; j++) {
            res.add(j);
            if(j * 10 <= n) {
                find(j * 10, n);
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        LexicalOrder lexicalOrder = new LexicalOrder();
        System.out.println(lexicalOrder.lexicalOrder(n));
    }
}
