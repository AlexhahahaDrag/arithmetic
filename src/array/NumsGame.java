package array;

import java.util.PriorityQueue;

/**
 * @description:
 * LCP 24. 数字游戏
 * 小扣在秋日市集入口处发现了一个数字游戏。主办方共有 N 个计数器，计数器编号为 0 ~ N-1。每个计数器上分别显示了一个数字，
 * 小扣按计数器编号升序将所显示的数字记于数组 nums。每个计数器上有两个按钮，分别可以实现将显示数字加一或减一。小扣每一次操作可以选择一个计数器，按下加一或减一按钮。
 *
 * 主办方请小扣回答出一个长度为 N 的数组，第 i 个元素(0 <= i < N)表示将 0~i 号计数器 初始 所示数字操作成满足所有条件 nums[a]+1 == nums[a+1],(0 <= a < i) 的最小操作数。
 * 回答正确方可进入秋日市集。
 *
 * 由于答案可能很大，请将每个最小操作数对 1,000,000,007 取余。
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,6,7]
 *
 * 输出：[0,0,0,5,6,7]
 *
 * 解释：
 * i = 0，[3] 无需操作
 * i = 1，[3,4] 无需操作；
 * i = 2，[3,4,5] 无需操作；
 * i = 3，将 [3,4,5,1] 操作成 [3,4,5,6], 最少 5 次操作；
 * i = 4，将 [3,4,5,1,6] 操作成 [3,4,5,6,7], 最少 6 次操作；
 * i = 5，将 [3,4,5,1,6,7] 操作成 [3,4,5,6,7,8]，最少 7 次操作；
 * 返回 [0,0,0,5,6,7]。
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5]
 *
 * 输出：[0,0,0,0,0]
 *
 * 解释：对于任意计数器编号 i 都无需操作。
 *
 * 示例 3：
 *
 * 输入：nums = [1,1,1,2,3,4]
 *
 * 输出：[0,1,2,3,3,3]
 *
 * 解释：
 * i = 0，无需操作；
 * i = 1，将 [1,1] 操作成 [1,2] 或 [0,1] 最少 1 次操作；
 * i = 2，将 [1,1,1] 操作成 [1,2,3] 或 [0,1,2]，最少 2 次操作；
 * i = 3，将 [1,1,1,2] 操作成 [1,2,3,4] 或 [0,1,2,3]，最少 3 次操作；
 * i = 4，将 [1,1,1,2,3] 操作成 [-1,0,1,2,3]，最少 3 次操作；
 * i = 5，将 [1,1,1,2,3,4] 操作成 [-1,0,1,2,3,4]，最少 3 次操作；
 * 返回 [0,1,2,3,3,3]。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^3
 * @author:      alex
 * @createTime:  2020/11/5 19:30
 * @version:     1.0
 */
public class NumsGame {

    private int mod = 1000000007;
    public int[] numsGame(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
            int mid = getMid();
            res[i] = (int)(mid * lo.size() - minValue + maxValue - mid * hi.size()) % mod;
        }
        return res;
    }

    private long minValue;
    private long maxValue;
    private PriorityQueue<Integer> hi = new PriorityQueue<>();
    private PriorityQueue<Integer> lo = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private void addNum(int i) {
        hi.offer(i);
        maxValue += i;
        i = hi.poll();
        maxValue -= i;
        minValue += i;
        lo.offer(i);
        if (lo.size() > hi.size() + 1) {
            i = lo.poll();
            minValue -= i;
            hi.offer(i);
            maxValue += i;
        }
    }

    private int getMid() {
        return lo.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,6,7};
        NumsGame numsGame = new NumsGame();
        int[] res = numsGame.numsGame(nums);
        for (int i : res) {
            System.out.print(i +"   ");
        }
    }
}
