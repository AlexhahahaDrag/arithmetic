package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * 一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成
 * 的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
 * 注意在计算时，只算本质不同的串的个数。
 * 请问，字符串0100110001010001 有多少个不同的非空子串？
 * @Author:     alex
 * @CreateDate: 2019/8/14 10:35
 * @Version:    1.0
 *
*/
public class DifferenceString {
    public static void main(String[] args) {
        DifferenceString differenceString = new DifferenceString();
        System.out.println(differenceString.findDifferenceString("0100110001010001"));
    }
    private int findDifferenceString(String str) {
        int len = str.length();
        Set<String> set = new HashSet<>();
        int start =0;
        int end ;
        while (start < len) {
            end = start + 1;
            while (end <= len)
                set.add(str.substring(start,end++));
            start++;
        }
        return set.size();
    }
}
