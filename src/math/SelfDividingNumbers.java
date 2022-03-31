package math;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 728. 自除数
 * 自除数 是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 示例 2:
 *
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 *
 *
 * 提示：
 *
 * 1 <= left <= right <= 104
 *author:       alex
 *createDate:   2022/4/1 7:07
 *version:      1.0.0
 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(judge(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean judge(Integer num) {
        int i = num;
        while(num > 0) {
            int cur = num % 10;
            if(cur == 0 || i % cur != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int left = 1;
        int right = 22;//[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        System.out.println(selfDividingNumbers.selfDividingNumbers(left, right));
    }
}
