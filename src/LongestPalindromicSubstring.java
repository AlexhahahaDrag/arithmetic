import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    private static int max;
    private static int startIndex;
    public static void main(String[] args) {
        System.out.println(longestPalindrome11("aba"));
    }

    private static String longestPalindrome11(String s) {
        int len = s.length();
        char[] ch = new char[(len << 1) + 2];
        int[] map = new int[ch.length];
        Arrays.fill(ch, '#');
        ch[0] = '*';
        int add;
        for ( int i = 0; i < len; i++)
            ch[i + 1 << 1] = s.charAt(i);
        int index = 0;
        for(int j = index + 1; j < ch.length; j++) {
            if (j > index + map[index]) {
                add = 0;
                while(j - add >=0 && j + add < ch.length && ch[j - add] == ch[j + add])
                    add++;
                map[j] = add;
                index = j;
            } else if (j + map[(index << 1) - j] < index + map[index])
                map[j] = map[(index << 1) - j];
            else {
                add = index - j + map[index];
                while(j - add >=0 && j + add < ch.length && ch[j - add] == ch[j + add])
                    add++;
                map[j] = add;
                index = j;
            }
        }
        int max = 0;
        for(int k = 0; k < ch.length; k++)
            if(map[max] < map[k])
                max = k;
        StringBuilder sb = new StringBuilder();
        for (int l = max - map[max] + 1; l <= max + map[max] - 1; l ++)
            if (ch[l] != '#')
                sb.append(ch[l]);
        return sb.toString();
    }

    public static String longestPalindrome1(String s){
        char[] strs=s.toCharArray();
        int start=0;
        int end=0;
        int index=0;
        while(index<strs.length){
            int len1=expandAroundCenter(strs,index,index);
            int len2=expandAroundCenter(strs,index,index+1);
            int len=Math.max(len1,len2);
            if (len > end - start) {
                start = index - ((len - 1) >> 1);
                end = index + (len >> 1);
            }
            index++;
        }
        return s.substring(start,end+1);
    }
    private static int expandAroundCenter(char[] strs,int start,int end){
        while(start>=0&&end<strs.length&&strs[start]==strs[end]){
            start--;
            end++;
        }
        return end-start-1;
    }

    public static String longestPalindrome2(String s) {
        // corner case
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int i = 0;
        while(i < array.length) {
            i = expand(array, i);
        }
        return s.substring(startIndex, startIndex + max);
    }
    private static int expand(char[] array, int i){
        int start = i - 1;
        int end = i;
        while(end + 1< array.length && array[end] == array[end + 1]){
            end++;
        }
        int newTail = end + 1;
        end++;
        while(start >= 0 && end < array.length && array[start] == array[end]){
            start--;
            end++;
        }
        if(end - start - 1 > max){
            max = end - start - 1;
            startIndex = start + 1;
        }
        return newTail;
    }
}
