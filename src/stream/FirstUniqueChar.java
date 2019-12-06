package stream;

/**
 * @Description:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 * @Author:     alex
 * @CreateDate: 2019/12/6 15:58
 * @Version:    1.0
 *
*/
public class FirstUniqueChar {

    public int firstUniqChar1(String s) {
        int[] map = new int[26];
        char[] ch = s.toCharArray();
        for(char c : ch)
            map[c - 'a']++;
        int index = Integer.MAX_VALUE;
        for(int i = 0; i < map.length; i++) {
            if(map[i] == 1) {
                int in = s.indexOf((char)(i + 'a'));
                if (in != -1 && in < index)
                    index = in;
            }
        }
        return index;
    }

    public int firstUniqChar(String s) {
        int result = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch))
                result = (result == -1 || result > index ? index : result);
        }
        return result;
    }

    public static void main(String[] args) {
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        System.out.println(firstUniqueChar.firstUniqChar("loveleetcode"));
    }
}
