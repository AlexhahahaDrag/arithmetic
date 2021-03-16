/**
 * @Description: Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * @Author:      alex
 * @CreateDate:  2019/4/2 17:46
 * @param
 * @return
*/
public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }
    static char[] charsMap=new char[256];
    static boolean flag=true;
    public static boolean validPalindrome(String s) {
        if(s.length()<3) {
            return true;
        }
        for(int i=0;i<26;i++) {
            charsMap[i+'a']=(char)i;
        }
        return isPalindrome(s,0,s.length()-1);
    }
    public static boolean isPalindrome(String s,int i, int j){
        char[] strs=s.toCharArray();
        char cs;
        char ce;
        while(i<j){
            cs=charsMap[strs[i]];
            ce=charsMap[strs[j]];
            if(i<j){
                if(cs==ce){
                    i++;
                    j--;
                }else if(flag){
                    flag=false;
                    return isPalindrome(s,i+1,j)||isPalindrome(s,i,j-1);
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
