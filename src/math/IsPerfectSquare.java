package math;

/**
 *description:
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= num <= 2^31 - 1
 *author:       alex
 *createDate:   2021/11/4 11:13
 *version:      1.0.0
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare1(int num) {
        if (num < 0) {
            return false;
        }
        int start = 0;
        int end = num + 1 >> 1;
        int mid;
        long res;
        while(start <= end) {
            mid = start + (end - start >> 1);
            res = (long)mid * mid;
            if(res > num) {
                end = mid - 1;
            } else if (res < num) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 2147395600;
        System.out.println(Math.sqrt(808201));
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        System.out.println(isPerfectSquare.isPerfectSquare1(num));
    }
}
