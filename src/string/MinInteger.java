package string;

/**
 *description:
 * 5455. 最多 K 次交换相邻数位后得到的最小整数
 *  显示英文描述
 * 我的提交
 * 返回竞赛
 *
 * 通过的用户数
 * 12
 * 尝试过的用户数
 * 36
 * 用户总通过次数
 * 12
 * 用户总提交次数
 * 47
 * 题目难度
 * Hard
 * 给你一个字符串 num 和一个整数 k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个 数位 。
 * 你可以交换这个整数相邻数位的数字 最多 k 次。
 * 请你返回你能得到的最小整数，并以字符串形式返回。
 *
 * 示例 1：
 *
 * 输入：num = "4321", k = 4
 * 输出："1342"
 * 解释：4321 通过 4 次交换相邻数位得到最小整数的步骤如上图所示。
 * 示例 2：
 * 输入：num = "100", k = 1
 * 输出："010"
 * 解释：输出可以包含前导 0 ，但输入保证不会有前导 0 。
 * 示例 3：
 * 输入：num = "36789", k = 1000
 * 输出："36789"
 * 解释：不需要做任何交换。
 * 示例 4：
 * 输入：num = "22", k = 22
 * 输出："22"
 * 示例 5：
 * 输入：num = "9438957234785635408", k = 23
 * 输出："0345989723478563548"
 *
 * 提示：
 * 1 <= num.length <= 30000
 * num 只包含 数字 且不含有 前导 0 。
 * 1 <= k <= 10^9
 *author:       alex
 *createDate:   2020/7/5 11:04
 *version:      1.0.0
 */
public class MinInteger {

    public String minInteger(String num, int k) {
        char[] res = num.toCharArray();
        findMin(res, 0, k);
        return new String(res);
    }

    private void findMin(char[] num, int start, int k) {
        if (start > num.length || k <= 0) {
            return;
        }
        int len = Math.min(num.length - start - 1, k);
        int index = find(num, start, len + start);
        if (index != start) {
            swap(num, start, index);
            k -= index - start;
        }
        findMin(num, start + 1, k);
    }

    private void swap(char[] num, int i, int j) {
        char temp = num[j];
        while(i <= --j) {
            num[j + 1] = num[j] ;
        }
        num[i] = temp;
    }

    private int find(char[] ches, int start, int end) {
        Integer min = start;
        for (int i = start; i <= end; i++) {
            if (ches[min] > ches[i]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String num = "9438957234785635408";
        int k = 23;
        MinInteger minInteger = new MinInteger();
        System.out.println(minInteger.minInteger(num, k));
        System.out.println("0345989723478563548".equals(minInteger.minInteger(num, k)));
    }
}
