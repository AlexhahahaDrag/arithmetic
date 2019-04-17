/**
 * @Description: Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * @Author:      alex
 * @CreateDate:  2019/2/19 9:41
 * @param
 * @return
 *
 *
 * "mississippi"
 * "issip"
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issipi"));
    }
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
         else if (needle.length() > haystack.length())
            return -1;
        else
            for (int i = 0; i <= haystack.length() - needle.length(); i ++)
                if (needle.equals(haystack.substring(i, i + needle.length())))
                    return i;
        return -1;
    }
}
