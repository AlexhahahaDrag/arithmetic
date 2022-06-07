package array;

/**
 *description:
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 *
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 *
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 *author:       alex
 *createDate:   2022/6/7 22:17
 *version:      1.0.0
 */
public class MinEatingSpeed {

    public int minEatingSpeed1(int[] piles, int h) {
        long sum = 0;
        int max = 0;
        for(int i : piles) {
            sum += i;
            max = Math.max(max, i);
        }
        int start = (int)((sum + h - 1) / h);
        for(int i = start; i <= max; i++) {
            int need = 0;
            for(int p : piles) {
                need += (p + i - 1) / i;
            }
            if(need <= h) {
                return i;
            }
        }
        return -1;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        int max = 0;
        for(int i : piles) {
            sum += i;
            max = Math.max(max, i);
        }
        int start = (int)((sum + h - 1) / h);
        int end = max;
        int mid;
        int need;
        while(start < end) {
            mid = start + (end - start >> 1);
            need = 0;
            for(int p : piles) {
                need += (p + mid - 1) / mid;
            }
            if (need > h) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
