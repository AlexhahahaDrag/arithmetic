/**
 * @Description: Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * @Author:      alex
 * @CreateDate:  2019/2/14 10:45
 * @param
 * @return
*/
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords(" a  b ").equals("b a"));
    }
    public static String reverseWords(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        String[] strings=s.trim().split(" ");
        for (int i = strings.length-1; i >= 0 ; i--) {
            if (!"".equals(strings[i])) {
                stringBuilder.append(strings[i]);
                if (i!=0) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
