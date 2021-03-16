package string;

/**
 * @Description: Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @Author:      alex
 * @CreateDate:  2019/5/21 11:33
 * @param
 * @return
*/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcdfe"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring1("abcdfe"));
    }
    private int lengthOfLongestSubstring(String s) {
        int[] seen = new int[128];
        for(int i = 0; i < 128; i++){
            seen[i] = -1;
        }
        int i, j, max;
        i = j = max = 0;

        while(j < s.length()){
            char c = s.charAt(j);
            if(seen[c] >=i){
                i = seen[c] + 1;
            }
            seen[c] = j;
            j++;
            max = Math.max(max, j-i);
        }

        return max;
    }
    private int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0, leftIndex = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
                if (chars[innerIndex] == chars[j]) {
                    maxLength = Math.max(maxLength, j - leftIndex);
                    leftIndex = innerIndex + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);
    }
    private int lengthOfLongestSubstring1(String s) {
        int start = 0;
        int[] map = new int[256];
        int i = 0;
        int len = s.length();
        int maxlen = 0;
        while (i < len) {
            if (map[s.charAt(i)] == 1) {
                maxlen = i - start > maxlen ? i - start: maxlen;
                while(map[s.charAt(i)] == 1) {
                    map[s.charAt(start++)]--;
                }
            }
            map[s.charAt(i++)]++;
        }
        return i - start > maxlen ? i - start: maxlen;
    }
}
