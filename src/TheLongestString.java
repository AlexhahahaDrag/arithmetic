/**Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".

        Example 1:

        Input: ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.*/
public class TheLongestString {
    public static void main(String[] args) {
        String[] strs={"flower","fllw","flowight","fqq"};
        System.out.println(longestCommonPrefix(strs));
    }
    private static boolean  sameCharAtPos(String[] strs, char c, int pos) {
        // start with i = 1, since c is from strs[0]
        for (int i = 1; i < strs.length; i++) {
            if (pos >= strs[i].length() || strs[i].charAt(pos) != c)
                return false;
        }
        return true;
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int i = 0;
        char[] chars = strs[0].toCharArray();
        for (char c : chars) {
            if (sameCharAtPos(strs, c, i) == false)
                break;
            i++;
        }
        return strs[0].substring(0, i);
    }
}
