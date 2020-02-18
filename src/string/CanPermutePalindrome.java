package string;

import java.util.HashSet;
import java.util.Set;

/**
 *description:
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例：
 *
 * 输入：tact coa
 * 输出：True（排列有"taco cat"、"atco cta"，等等）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/17 19:35
 *version:      1.0.0      
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        int index = 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        while(index < len)
                map[ch[index++]]++;
        boolean flag = true;
        for(int i : map)
            if((i & 1) == 1) {
                if (flag)
                    flag = false;
                else
                    return false;
            }
        return true;
    }

    /*public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }*/


    public static void main(String[] args) {
        CanPermutePalindrome canPermutePalindrome = new CanPermutePalindrome();
        System.out.println(canPermutePalindrome.canPermutePalindrome("AaBb//a"));
    }
}
