package string;

import java.util.*;

/**
 *description:  
 *author:       alex
 *createDate:   2020/10/23 8:01
 *version:      1.0.0
 */
public class FindLadders {

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        boolean isTrue = false;
        for (String str : wordList) {
            if (endWord.equals(str)) {
                isTrue = true;
                break;
            }
        }
        if (!isTrue) {
            return res;
        }
        boolean[] visited = new boolean[wordList.size()];
        Map<String, String> map = new HashMap<>();
        Queue<String> quene = new LinkedList<>();
        quene.add(beginWord);
        while(!quene.isEmpty()) {
            String s = quene.poll();
            for(int i = 0; i < wordList.size(); i++) {
                String cur = wordList.get(i);
                if (!visited[i] && judge(cur.toCharArray(), s.toCharArray())) {
                    map.put(cur, s);
                    quene.add(cur);
                    visited[i] = true;
                    if (endWord.equals(cur)) {
                        break;
                    }
                }
            }
        }

        if (map.containsKey(endWord)) {
            String cu = endWord;
            res.add(0, cu);
            while(!cu.equals(beginWord)) {
                cu = map.get(cu);
                res.add(0, cu);
            }
        }
        return res;
    }

    private boolean judge(char[] str1, char[] str2) {
        int diff = 0;
        for(int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(arr);
        FindLadders findLadders = new FindLadders();
        System.out.println(findLadders.findLadders(beginWord, endWord, wordList));
    }
}
