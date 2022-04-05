package math;

/**
 *description:
 * 762. 二进制表示中质数个计算置位
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 *
 * 计算置位位数 就是二进制表示中 1 的个数。
 *
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 *
 *
 * 示例 1：
 *
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * 示例 2：
 *
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 *
 *
 * 提示：
 *
 * 1 <= left <= right <= 106
 * 0 <= right - left <= 104
 *author:       alex
 *createDate:   2022/4/5 15:07
 *version:      1.0.0
 */
public class CountPrimeSetBits {

    public int countPrimeSetBits1(int left, int right) {
        boolean[] map = new boolean[10001];
        int res = 0;
        boolean flag = false;
        for(int i = left; i <= right; i++) {
            if (!map[i - left]) {
                flag = judge(i);
                int c = i;
                while(c <= right) {
                    map[c - left] = true;
                    if (flag) {
                        res++;
                    }
                    c <<= 1;
                }
            }
        }
        return res;
    }

    private boolean judge(int i) {
        int cur = i;
        int count = 0;
        while(i > 0) {
            if (i % 2 == 1) {
                count++;
            }
            i >>= 1;
        }
        if (count == 0 || count == 1) {
            return false;
        }
        return zs(count);
    }

    private boolean zs(int num) {
        for(int i = 2; i <= num / 2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //二进制数2,3,5,7,9
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++) {
            if (((1 << Integer.bitCount(i)) & 0b10100010100010101100) != 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int left = 10;
        int right = 15;
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        System.out.println(countPrimeSetBits.countPrimeSetBits(left, right));
    }
}
