package array;

import java.util.Arrays;

/**
 *description:
 * 5172. 形成三的最大倍数 显示英文描述
 * 用户通过次数133
 * 用户尝试次数251
 * 通过次数136
 * 提交次数501
 * 题目难度Hard
 * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
 *
 * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
 *
 * 如果无法得到答案，请返回一个空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [8,1,9]
 * 输出："981"
 * 示例 2：
 *
 * 输入：digits = [8,6,7,1,0]
 * 输出："8760"
 * 示例 3：
 *
 * 输入：digits = [1]
 * 输出：""
 * 示例 4：
 *
 * 输入：digits = [0,0,0,0,0,0]
 * 输出："0"
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 10^4
 * 0 <= digits[i] <= 9
 * 返回的结果不应包含不必要的前导零。
 *author:       alex
 *createDate:  2020/2/23 11:22
 *version:      1.0.0
 */
public class LargestMultipleOfThree {
    public String largestMultipleOfThree(int[] digits) {
        int two = 0;
        int one = 0;
        for (int i = 0; i < digits.length; i++) {
            switch (digits[i] % 3) {
                case 2 : two++; break;
                case 1 : one++; break;
            }
        }
        Arrays.sort(digits);
        if (digits[digits.length - 1] == 0) {
            return "0";
        }
        int more1 = two % 3 - one % 3;
        int more2 = (two - one) % 3;
        int more = Math.abs(more1) <= Math.abs(more2) ? more1 : more2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (more > 0 && digits[i] % 3 == 2) {
                more--;
            } else if (more < 0 && digits[i] % 3 == 1) {
                more++;
            } else {
                stringBuilder.insert(0, digits[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] digits = {2, 2, 1, 1, 1};
        LargestMultipleOfThree largestMultipleOfThree = new LargestMultipleOfThree();
        System.out.println(largestMultipleOfThree.largestMultipleOfThree(digits));
    }
}
