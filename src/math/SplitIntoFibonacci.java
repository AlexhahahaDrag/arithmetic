package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 * @author:      alex
 * @createTime:  2020/12/8 20:05
 * @version:     1.0
 */
public class SplitIntoFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {
        int[] res = new int[S.length()];
        find(res, 0, S.toCharArray(), 0);
        List<Integer> list = new ArrayList<>();
        for(int i : res) {
            list.add(i);
        }
        return list;
    }

    private boolean find(int[] res, int index, char[] chs, int in) {
        if (!check(res, index - 1)) {
            return false;
        }

        if (in == chs.length) {
            return true;
        }
        if (in > chs.length || chs[in] == '0') {
            res[index] = 0;
            return false;
        }
        for (int i = in; i < chs.length; i++) {
            res[index] = res[index] * 10 + chs[i] - '0';
            if (find(res, index + 1, chs, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] res, int index) {
        if (index < 3) {
            return true;
        }
        return res[index] - res[index - 1] - res[index - 2] == 0;
    }

    public static void main(String[] args) {
        String S = "1101111";
        SplitIntoFibonacci splitIntoFibonacci = new SplitIntoFibonacci();
        System.out.println(splitIntoFibonacci.splitIntoFibonacci(S));
    }
}
