package math;

import java.util.Arrays;

/**
 * @description:
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * @author:      alex
 * @createTime:  2020/12/15 18:56
 * @version:     1.0
 */
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits1(int N) {
        int digit = digit(N);
        int[] map = new int[digit];
        int index = digit;
        while(N > 0) {
            map[--index] = N % 10;
            N /= 10;
        }
        int i = 0;
        for (; i < digit - 1; i++) {
            if (map[i] > map[i + 1])
                break;
        }
        if (i < digit - 1) {
            while(i > 0 && map[i] > map[i + 1] && map[i] - 1 < map[i - 1])
                map[i--]--;
            map[i]--;
        }

        Arrays.fill(map, i + 1, digit, 9);
        for (int j = 0; j < digit; j++)
            N = N * 10 + map[j];
        return N;
    }

    private int digit(int N) {
        int digit = 0;
        while(N > 0) {
            digit++;
            N /= 10;
        }
        return digit;
    }

    public int monotoneIncreasingDigits(int N) {
        int rs = 0, exp = 1, p = 10;
        while (N > 0) {
            int t = N % 10;
            if (t <= p) {
                rs += t * exp;
                p = t;
            }
            else {
                rs = t * exp - 1;
                p = t - 1;
            }
            N /= 10;
            exp *= 10;
        }
        return rs;
    }

    public static void main(String[] args) {
        //int N = 134532;
        int N = 1111111110;
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(N));
    }
}
