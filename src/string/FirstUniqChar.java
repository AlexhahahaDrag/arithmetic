package string;

/**
 *description:
 * 面试题50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *author:       alex
 *createDate:  2020/3/31 6:23
 *version:      1.0.0      
*/
public class FirstUniqChar {

    public char firstUniqChar1(String s) {
        int[] map = new int[256];
        char[] ch = s.toCharArray();
        for (int i : ch)
            map[i]++;
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                int in = s.indexOf((char)i);
                if (in < index)
                    index = in;
            }
        }
        return index == Integer.MAX_VALUE ? ' ' : ch[index];
    }

    public char firstUniqChar(String s) {
        int[] map = new int[256];
        char[] ch = s.toCharArray();
        for (int i : ch)
            map[i]++;
        for(int i = 0; i < ch.length; i++){
            if(map[(int)ch[i]] == 1){
                return ch[i];
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar(""));
    }
}
