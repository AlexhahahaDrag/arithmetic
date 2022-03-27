package array;

/**
 *description:
 * 5253. 找到指定长度的回文数
 * 给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。
 *
 * 回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = [1,2,3,4,5,90], intLength = 3
 * 输出：[101,111,121,131,141,999]
 * 解释：
 * 长度为 3 的最小回文数依次是：
 * 101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 201, ...
 * 第 90 个长度为 3 的回文数是 999 。
 * 示例 2：
 *
 * 输入：queries = [2,4,6], intLength = 4
 * 输出：[1111,1331,1551]
 * 解释：
 * 长度为 4 的前 6 个回文数是：
 * 1001, 1111, 1221, 1331, 1441 和 1551 。
 *
 *
 * 提示：
 *
 * 1 <= queries.length <= 5 * 104
 * 1 <= queries[i] <= 109
 * 1 <= intLength <= 15
 *author:       alex
 *createDate:   2022/3/27 15:04
 *version:      1.0.0
 */
public class KthPalindrome {

    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] res = new long[queries.length];
        for(int i = 0; i < queries.length; i++) {
            res[i] = getPalindrome(intLength, queries[i]);
        }
        return res;
    }

    //生成第index位的长度为len的回文数
    private long getPalindrome(int len, int index) {
        //判断当前位数是否超过len的最大回文数
        if(index > 9 * Math.pow(10, len - 1 >> 1)) {
            return -1;
        }
        int[] map = new int[len];
        map[0] = 1;
        map[len - 1] = 1;
        int mid = len - 1 >> 1;
        int mid1 = len >> 1;
        int d;
        index--;
        while(mid >= 0 && index > 0) {
            d = index % 10;
            map[mid] = mid == 0 ? d + 1 : d;
            map[mid1] = mid == 0 ? d + 1 : d;
            mid--;
            mid1++;
            index /= 10;
        }
        long res = 0;
        for(int i = 0; i < len; i++) {
            res *= 10;
            res += map[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] queries = {1,2,3,4,5,90};
        int intLength = 5;
        KthPalindrome kthPalindrome = new KthPalindrome();
        long[] res = kthPalindrome.kthPalindrome(queries, intLength);
        for (long r : res) {
            System.out.print(r + ", ");
        }
    }
}
