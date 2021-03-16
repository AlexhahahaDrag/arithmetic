package array;

import java.util.Arrays;

/**
 *description:
 * 846. 一手顺子 显示英文描述
 * 题目难度Medium
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *
 *
 * 提示：
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 *
 *author:       alex
 *createDate:  2020/2/4 14:13
 *version:      1.0.0      
*/
public class IsNStraightHand {
    int index = 0;
    public boolean isNStraightHand(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) {
            return false;
        }
        Arrays.sort(hand);
        clear(hand, W);
        return index == len;
    }

    private void clear(int[] hand, int W) {
        if (hand == null || hand.length == 0) {
            return;
        }
        int num = 1;
        int pre = hand[0];
        hand[0] = -2;
        index++;
        for (int i = 0; i < hand.length; i++) {
            if (pre + 1 == hand[i]) {
                pre = hand[i];
                hand[i] = -2;
                index++;
                num++;
            }
            if (num == W) {
                int[] newHand = new int[hand.length - W];
                int in = 0;
                for (int j = 0; j < hand.length; j++) {
                    if (hand[j] != -2) {
                        newHand[in++] = hand[j];
                    }
                }
                clear(newHand, W);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,4,5,3};
        int W = 3;
        IsNStraightHand isNStraightHand = new IsNStraightHand();
        System.out.println(isNStraightHand.isNStraightHand(hand, W));
    }
}
