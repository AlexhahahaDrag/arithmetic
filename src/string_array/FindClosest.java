package string_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 * Author:      alex
 * CreateDate:  2020/7/13 12:23
 * Version:     1.0
 *
 */
public class FindClosest {

    public int findClosest1(String[] words, String word1, String word2) {
        int len = words.length;
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> cur;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(words[i])) {
                cur = map.get(words[i]);
                cur.add(i);
            } else {
                cur = new ArrayList<>();
                cur.add(i);
                map.put(words[i], cur);
            }
        }
        if (!map.containsKey(word1) || !map.containsKey(word2)) {
            return -1;
        }
        List<Integer> re1 = map.get(word1);
        List<Integer> re2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int in1 = 0;
        int in2 = 0;
        while(in1 < re1.size() && in2 < re2.size()) {
            int num = re1.get(in1) - re2.get(in2);
            if (num == 1) {
                return 1;
            } else if (num < 0){
                min = Math.min(min, -num);
                in1++;
            } else {
                min = Math.min(min, num);
                in2++;
            }
        }
        return min;
    }

    public int findClosest(String[] words, String word1, String word2) {
        int len = words.length;
        int in1 = -1;
        int in2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) {
                in1 = i;
                if (in2 != -1) {
                    res = Math.min(res, in1 - in2);
                }
            } else if (words[i].equals(word2)) {
                in2 = i;
                if (in1 != -1) {
                    res = Math.min(res, in2 - in1);
                }
            }
            if (res == 1) {
                return 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "university";
        String word2 = "student";
        FindClosest findClosest = new FindClosest();
        System.out.println(findClosest.findClosest(words, word1, word2));
    }
}
