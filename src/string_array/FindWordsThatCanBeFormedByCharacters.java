package string_array;

import java.util.Arrays;

/**
 * @Description: You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 * @Author:     alex
 * @CreateDate: 2019/8/26 18:03
 * @Version:    1.0
 *
*/
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters = new FindWordsThatCanBeFormedByCharacters();
        String[] words = {"cat","bt","hat","tree"};
        System.out.println(findWordsThatCanBeFormedByCharacters.countCharacters(words, "atach"));
    }

    public int countCharacters(String[] words, String chars) {
        char[] ch = chars.toCharArray();
        int[] map = new int[26];
        int sum = 0;
        for(char c : ch)
            map[c - 'a']++;
        for(String word : words)
            if(find(map, word))
                sum += word.length();
        return sum;
    }
    private boolean find(int[] map, String st) {
        int[] newMap = Arrays.copyOf(map, map.length);
        int start = 0;
        while(start < st.length() && newMap[st.charAt(start) - 'a'] > 0)
            newMap[st.charAt(start++) - 'a']--;
        if(start == st.length()) {
            return true;
        } else
            return false;
    }
}
