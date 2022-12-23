package string;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 * 1805. 字符串中不同整数的数目
 * 简单
 * 66
 * 相关企业
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 *
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 *
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 *
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 *
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 *
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 * author:       majf
 * createDate:   2022/12/6 17:49
 * version:      1.0.0
 */
public class NumDifferentIntegers {

    public int numDifferentIntegers(String word) {
        int len = word.length();
        int i = -1;
        Set<String> set = new HashSet<>();
        while (++i < len) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                int j = i;
                while(j < len && word.charAt(j) >= '0' && word.charAt(j) <= '9') {
                    j++;
                }
                while(i + 1 < j && word.charAt(i) == '0') {
                    i++;
                }
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        String word = "a123bc34d8ef0034";//3
//        String word = "035985750011523523129774573439111590559325a1554234973";//2
//        String word = "192383183928778851682383a2089984061937879119";//2
        NumDifferentIntegers numDifferentIntegers = new NumDifferentIntegers();
        System.out.println(numDifferentIntegers.numDifferentIntegers(word));
    }
}
