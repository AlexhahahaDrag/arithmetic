package twoDimensionalArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 *@description:
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *@author:       alex
 *@createDate:   2022/9/3 16:28
 *@version:      1.0.0
 */
public class FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int res = 1;
        int pre = pairs[0][1];
        for(int[] i : pairs) {
            if (i[0] > pre) {
                res++;
                pre = i[1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] pairs = {};
        FindLongestChain findLongestChain = new FindLongestChain();
        System.out.println(findLongestChain.findLongestChain(pairs));
    }
}
