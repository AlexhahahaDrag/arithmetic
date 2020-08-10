package string;

/**
 * @description:
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * @author:      alex
 * @createTime:  2020/8/10 9:30
 * @version:     1.0
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char pre = s.charAt(0);
        int len = s.length();
        int[] map = new int[len];
        int size = 0;
        map[size] = 1;
        int start = 0;
        while(start < len - 1) {
            char cur = s.charAt(++start);
            if (cur == pre)
                map[size]++;
            else {
                map[++size]++;
                pre = cur;
            }
        }
        int res = 0;
        for(int i = 0; i < size; i++)
            res += Math.min(map[i], map[i + 1]);
        return res;
    }

    public static void main(String[] args) {
        String s = "10101";
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings(s));
    }
}
