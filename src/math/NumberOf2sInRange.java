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
    public int numberOf2sInRange(int n) {
        return find(n);
    }

    private int find(int n) {
        if (n < 2) {
            return 0;
        }
        int digit = getDigit(n);
        int ten = (int) Math.pow(10, digit - 1);
        int count = 0;
        if (n / ten == 2) {
            count =  n % ten + 1;
        } else if (n / ten > 2) {
            count = (int)Math.pow(10, digit - 1) ;
        }
        return count + find(n % ten) + n / ten * (digit - 1) * (int)Math.pow(10, digit - 2);
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
//        int n = 25; //9
//        int n = 2; //1
//        int n = 123;
//        int n = 100; //20
        int n = 9; //160
//        int n = 1000; //300
//        int n = 10000; //4000
        System.out.println(numberOf2sInRange.numberOf2sInRange(n));
    }
}
