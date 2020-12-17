import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */
public class WordPattern {

    public static boolean getWordPattern(String pattern,String str){
        String[] strs=str.split(" ");
        if (pattern.length()!=strs.length){
            return false;
        }
        Map< Character,String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (map.get(pattern.charAt(i))!=null&&!strs[i].equals(map.get(pattern.charAt(i)))){
                return false;
            }
            if (!map.containsKey(pattern.charAt(i))&&map.containsValue(strs[i])){
                return false;
            }else {
                map.put(pattern.charAt(i),strs[i]);
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        if ((pattern == null || pattern.length() == 0) && (s == null || s.length() == 0))
            return true;
        if (pattern == null || pattern.length() == 0 || s == null || s.length() == 0)
            return false;
        String[] st = s.split(" ");
        int len = pattern.length();
        if(st.length != len)
            return false;
        String[] map = new String[26];
        int index = -1;
        while(++index < len) {
            char ch = pattern.charAt(index);
            if (map[ch - 'a'] == null) {
                for (int i = 0; i < 26; i++) {
                    if (st[index].equals(map[i]))
                        return false;
                }
                map[ch - 'a'] = st[index];
            }

            else if (!map[ch - 'a'].equals(st[index]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
    }
}
