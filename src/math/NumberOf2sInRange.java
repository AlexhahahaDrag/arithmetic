package math;

/**
 * @description:
 * 面试题 17.06. 2出现的次数
 * 难度
 * 中等
 *
 * 19
 *
 *
 *
 *
 *
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * 示例:
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 * n <= 10^9
 * @author:      alex
 * @createTime:  2020/7/16 18:48
 * @version:     1.0
 */
public class NumberOf2sInRange {
    private int count = 0;
    public int numberOf2sInRange(int n) {
        return find(n, getDigit(n));
    }

    private int find(int n, int digit) {
        if (n < 2)
            return 0;
        else if (n < 10)
            return 2;
        int ten = (int) Math.pow(10, digit - 1);
        int cur = n / ten;
        int add = (int)Math.pow(ten, digit);
        if (cur < 2) {
            count += add;
        } else if (cur == 2) {
            count += n % ten + cur * add;
        } else {
            count += Math.pow(10, digit - 1) + add;
        }
        return count;
    }

    private int getDigit(int n) {
        int digit = 0;
        while(n > 0) {
            digit++;
            n /= 10;
        }
        return digit;
    }

    public static void main(String[] args) {
        NumberOf2sInRange numberOf2sInRange = new NumberOf2sInRange();
        System.out.println(numberOf2sInRange.numberOf2sInRange(25));
    }
}
