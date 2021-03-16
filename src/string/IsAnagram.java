package string;

/**
 * @description:
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xar9lv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author:      alex
 * @createTime:  2020/8/7 16:58
 * @version:     1.0
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if(s == t) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for(char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        for(char ch : t.toCharArray()) {
            map[ch - 'a']--;
            if (map[ch - 'a'] < 0) {
                return false;
            }
        }

        for(int i : map) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "";
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram(s, t));
    }
}
