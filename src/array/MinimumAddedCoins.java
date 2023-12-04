package array;

import java.util.Arrays;

/**
 * @description:
 * 2952. 需要添加的硬币的最小数量
 * 尝试过
 * 中等
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
 *
 * 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
 *
 * 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
 *
 * 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1,4,10], target = 19
 * 输出：2
 * 解释：需要添加面值为 2 和 8 的硬币各一枚，得到硬币数组 [1,2,4,8,10] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 2 。
 * 示例 2：
 *
 * 输入：coins = [1,4,10,5,7,19], target = 19
 * 输出：1
 * 解释：只需要添加一枚面值为 2 的硬币，得到硬币数组 [1,2,4,5,7,10,19] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 1 。
 * 示例 3：
 *
 * 输入：coins = [1,1,1], target = 20
 * 输出：3
 * 解释：
 * 需要添加面值为 4 、8 和 16 的硬币各一枚，得到硬币数组 [1,1,1,4,8,16] 。
 * 可以证明从 1 到 20 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 3 。
 *
 *
 * 提示：
 *
 * 1 <= target <= 105
 * 1 <= coins.length <= 105
 * 1 <= coins[i] <= target
 * @author:       majf
 * @createDate:   2023/12/4 14:21
 * @version:      1.0.0
 */
public class MinimumAddedCoins {

    /**
     * @param coins
     * @param target
     * @description:
     * 为方便描述，把 000 也算作可以得到的数。
     *
     * 假设现在得到了 [0,s−1][0,s-1][0,s−1] 内的所有整数，如果此时新发现了一个整数 xxx，那么把 xxx 加到已得到的数字中，就得到了 [x,s+x−1][x,s+x-1][x,s+x−1] 内的所有整数。
     *
     * 分类讨论：
     *
     * 如果 x≤sx \le sx≤s，那么合并这两个区间，我们可以得到 [0,s+x−1][0,s+x-1][0,s+x−1] 内的所有整数。
     * 如果 x>sx > sx>s，这意味着我们无法得到 sss，那么就一定要把 sss 加到数组中（加一个比 sss 还小的数字就没法得到更大的数，不够贪），这样就可以得到 [s,2s−1][s,2s-1][s,2s−1] 内的所有整数，再与 [0,s−1][0,s-1][0,s−1] 合并，可以得到 [0,2s−1][0,2s-1][0,2s−1] 内的所有整数。然后再重新考虑 xxx 和 sss 的大小关系，继续分类讨论。
     * 把 coins\textit{coins}coins 排序，从小到大考虑 x=coins[i]x=\textit{coins}[i]x=coins[i]。按照上述分类讨论来看是否要添加数字。
     *
     * @author:      majf
     * @return:      int
    */
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int res = 0;
        int s = 1;
        int index = 0;
        while(s <= target) {
            if (index < coins.length && coins[index] <= s) {
                s += coins[index];
                index++;
            } else {
                s *= 2;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] coins = {1,4,10,5,7,19};
//        int target = 19;// 1
        int[] coins = {2,4,10,5,7,19};
        int target = 19;// 1
        MinimumAddedCoins minimumAddedCoins = new MinimumAddedCoins();
        System.out.println(minimumAddedCoins.minimumAddedCoins(coins, target));
    }
}
