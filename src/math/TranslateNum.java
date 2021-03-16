package math;

/**
 *description:
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 *author:       alex
 *createDate:   2020/6/9 20:42
 *version:      1.0.0
 */
public class TranslateNum {

    private int count = 0;
    public int translateNum(int num) {
        if(num == 0) {
            return 1;
        }
        getCount(num);
        return count;
    }

    private void getCount(int num) {
        if (num == 0) {
            count++;
            return;
        }
        if(num % 100 > 9 && num % 100 <= 25) {
            getCount(num / 100);
        }
        getCount(num / 10);
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(12258));
    }
}
