package string;

import java.util.Arrays;

/**
 * Description:
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * Author:      alex
 * CreateDate:  2020/6/11 19:37
 * Version:     1.0
 *
*/
public class FrequencySort {

    public String frequencySort1(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] st = s.toCharArray();
        int[] map = new int[256];
        for(char ch : st) {
            map[ch]++;
        }
        int[] copy = Arrays.copyOf(map, map.length);
        Arrays.sort(copy);
        StringBuilder sb = new StringBuilder();
        for(int i = copy.length - 1; i >= 0; i--) {
            if (copy[i] > 0) {
                for(int j = 0; j < map.length; j++) {
                    if (map[j] != 0 && copy[i] == map[j]) {
                        while(map[j]-- > 0) {
                            sb.append((char)j);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public String frequencySort(String s) {
        int[][] map = new int[256][2];
        int len = s.length();
        int i = -1;
        char[] res = s.toCharArray();
        while(++i < len) {
            map[res[i]][0]++;
            map[res[i]][1] = res[i];
        }
        Arrays.sort(map, (o1, o2) -> o2[0] - o1[0]);
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < map.length; i++) {
            while(map[i][0]-- > 0) {
                sb.append((char)map[i][1]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        System.out.println(frequencySort.frequencySort("#2a554442f544asfasssffffasss"));
    }
}
