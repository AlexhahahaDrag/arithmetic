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
    public static void main(String[] args) {
        System.out.println(getWordPattern("abba","dog dog dog dog"));
    }
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
}
