package string_array;

/**
 *description:
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *author:       alex
 *createDate:  2020/3/16 16:46
 *version:      1.0.0
*/
public class LongestCommonPrefix {

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int len = strs[0].length();
        String common = strs[0];
        for (String str : strs) {
            len = check(str, common, len);
            if (len == 0) {
                break;
            }
        }
        return common.substring(0, len);
    }

    private int check(String str1, String str2, int len) {
        int index = 0;
        len = Math.min(Math.min(str1.length(), str2.length()), len);
        while(index < len) {
            if (str1.charAt(index) == str2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return index;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (String str : strs) {
            while(str.indexOf(common) != 0) {
                common = common.substring(0, common.length() - 1);
            }
        }
        return common;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
