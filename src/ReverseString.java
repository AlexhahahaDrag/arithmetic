/**
 * @Description: Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ['h','e','l','l','o']
 * Output: ['o','l','l','e','h']
 * Example 2:
 *
 * Input: ['H','a','n','n','a','h']
 * Output: ['h','a','n','n','a','H']
 * @Author:      alex
 * @CreateDate:  2019/1/24 10:52
 * @param
 * @return
*/
public class ReverseString {
    public static void main(String[] args) {
        char[] s={'H','a','n','n','a','h'};
        reverseString1(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
    }
    public static void reverseString(char[] s){
        for (int i = 0; i < s.length>>1; i++) {
            s[i]=(char)( s[s.length-1-i]^s[i]);
            s[s.length-1-i]=(char) (s[i]^s[s.length-1-i]);
            s[i]=(char)( s[i]^s[s.length-1-i]);
        }
    }
    public static void reverseString1(char[] s){
        boolean hasSurrogates = false;
        int n = s.length-1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = s[j];
            char ck = s[k];
            s[j] = ck;
            s[k] = cj;
            if (Character.isSurrogate(cj) ||
                    Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            for (int i = 0; i < n; i++) {
                char c2 = s[i];
                if (Character.isLowSurrogate(c2)) {
                    char c1 = s[i + 1];
                    if (Character.isHighSurrogate(c1)) {
                        s[i++] = c1;
                        s[i] = c2;
                    }
                }
            }
        }
    }
}
