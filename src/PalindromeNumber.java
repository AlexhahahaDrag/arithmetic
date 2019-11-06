/**
 * @Description: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * @Author:      alex
 * @CreateDate:  2019/2/19 9:20
 * @param
 * @return
*/
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
    private static boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int reverseX = 0;
        while (x > reverseX) {
            reverseX = reverseX * 10 + x % 10;
            x /= 10;
        }
        return x == reverseX || x == reverseX / 10;
    }
    private static boolean isPalindrome1(int x) {
        if (x<0)
            return false;
        String s=x+"";
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if (s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
