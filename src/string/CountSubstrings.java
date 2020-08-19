package string;

import java.util.Arrays;

/**
 * @description:
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 * @author:      alex
 * @createTime:  '2020/8/19' 9:37
 * @version:     1.0
 */
public class CountSubstrings {
    int[] res = null;
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        char[] map = new char[(ch.length << 1) + 2];
        Arrays.fill(map, '#');
        map[0] = '$';
        for(int i = 0; i < ch.length; i++) {
            map[i + 1 << 1] = ch[i];
        }
        res = new int[map.length];
        Arrays.fill(res, 1);
        int mid = 0;
        for(int i = 1; i < map.length; i++) {
            mid = find(map, mid, i);
        }
        int count = 0;
        for(int i = 0; i < map.length; i ++)
            count += res[i] >> 1;
        return count;
    }

    private int find(char[] map, int mid, int i) {
        if (res[mid] != 1 && res[mid] + mid > res[mid * 2 - i] + i)
            res[i] = res[mid * 2 - i];
        else {
            int l = 1;
            while(i - l >= 0 && i + l < map.length && map[i - l] == map[i + l])
                l++;
            res[i] = l;
            mid = i;
        }
        return mid;
    }

    public static void main(String[] args) {
        String s = "aaa";
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings(s));
    }
}
