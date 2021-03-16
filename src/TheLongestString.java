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
        TheLongestString theLongestString = new TheLongestString();
        String[] strs={"flower","fllw","flowight","fqq"};
        System.out.println(theLongestString.longestCommonPrefix(strs));
    }
    private static boolean  sameCharAtPos(String[] strs, char c, int pos) {
        // start with i = 1, since c is from strs[0]
        for (int i = 1; i < strs.length; i++) {
            if (pos >= strs[i].length() || strs[i].charAt(pos) != c) {
                return false;
            }
        }
        return true;
    }
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        char[] chars = strs[0].toCharArray();
        for (char c : chars) {
            if (sameCharAtPos(strs, c, i) == false) {
                break;
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String commonStr = strs[0];
        for(int i = 1; i < strs.length; i++) {
            commonStr = getCommon(strs[i], commonStr);
            if ("".equals(commonStr)) {
                return "";
            }
        }
        return commonStr;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (String str : strs) {
           while(str.indexOf(common) != 0) {
               common = common.substring(0, common.length() - 1);
               if (common.isEmpty()) {
                   return "";
               }
           }
        }
        return common;
    }


    private String getCommon(String str1, String str2) {
        if(judgeString(str1) || judgeString(str2)) {
            return "";
        }
        int index = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        while(index < len1 && index < len2 && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    private Boolean judgeString(String strs) {
        if(strs == null || strs.length() == 0) {
            return true;
        }
        return false;
    }
}
