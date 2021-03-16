/**
 * @Description: Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * @Author:      alex
 * @CreateDate:  2019/2/19 10:34
 * @param
 * @return
*/
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length()==0) {
            return true;
        }
        int len=s.length();
        for (int i = 2; i <= len; i++) {
            if (len%i==0){
                int index=len/i;
                while (index<len){
                    if (!s.substring(index-len/i,index).equals(s.substring(index,index+len/i))) {
                        break;
                    }
                   index+= len/i;
                }
                if (index==len) {
                    return true;
                }
            }
        }
        return false;
    }
}
