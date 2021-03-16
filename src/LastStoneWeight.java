/**
 * @Description: We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * @Author:      alex
 * @CreateDate:  2019/5/22 11:42
 * @param
 * @return
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight=new LastStoneWeight();
        int[] stones={0};
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
    }
    public int lastStoneWeight(int[] stones) {
            if (stones.length==1) {
                return stones[0];
            }
            int big = 0;
            int second = 1;
            if (stones[big] < stones[second]) {
                big = 1;
                second = 0;
            }
            int len = stones.length;
            while (len > 1) {
                for (int i = 0; i < stones.length; i++) {
                    if (stones[i] != -1) {
                        if (stones[big] < stones[i]) {
                            second = big;
                            big = i;
                        } else if (i!=big&&stones[second] < stones[i]) {
                            second = i;
                        }
                    }
                }
                stones[big] = stones[big] - stones[second];
                stones[second] = -1;
                len--;
            }
            return stones[big];
    }
}
