package string;

/**
 * @Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 * @Author:     alex
 * @CreateDate: 2019/8/19 9:58
 * @Version:    1.0
 *
*/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for(int i = 1; i < strs.length; i++) {
            s = getCommonSubstring(s, strs[i]);
            if("".equals(s)) {
                return "";
            }
        }
        return s;
    }

    private String getCommonSubstring(String s, String t) {
        if(s == null || t == null || "".equals(s) || "".equals(t)) {
            return "";
        }
        int index = 0;
        int sLen = s.length();
        int tLen = t.length();
        while(index < sLen && index < tLen && s.charAt(index) == t.charAt(index)) {
            index++;
        }
        return s.substring(0,index);
    }
}
