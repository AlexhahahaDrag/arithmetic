package string;


import twoDimensionalArray.Insert;

import java.util.*;

/**
 * @description:
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * @author:      alex
 * @createTime:  2020/11/5 15:43
 * @version:     1.0
 */
public class LadderLength {

//    private boolean[] visited;
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord))
//            return 0;
//        visited = new boolean[wordList.size()];
//        Queue<char[]> queue = new LinkedList<>();
//        queue.add(beginWord.toCharArray());
//        return bfs(queue, endWord, wordList, 1);
//    }
//
//    private int bfs(Queue<char[]> queue, String endWord, List<String> wordList, int i) {
//        Queue<char[]> next = new LinkedList<>();
//        while(!queue.isEmpty()) {
//            char[] poll = queue.poll();
//            if (endWord.equals(new String(poll)))
//                return i;
//            for (int j = 0; j < wordList.size(); j++) {
//                char cur[] = wordList.get(j).toCharArray();
//                if (!visited[j] && similar(poll, cur)) {
//                    visited[j] = true;
//                    next.add(cur);
//                }
//            }
//        }
//        if (!next.isEmpty())
//            return bfs(next, endWord, wordList, i + 1);
//        return 0;
//    }
//
//    private boolean similar(char[] c1, char[] c2) {
//        int diff = 0;
//        for (int i = 0; i < c1.length; i++) {
//            if (c1[i] != c2[i])
//                diff++;
//        }
//        return diff == 1;
//    }


//    Map<String, Integer> wordId = new HashMap<>();
//    List<List<Integer>> edge = new ArrayList<>();
//    int nodeNum = 0;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        for (String word : wordList) {
//            addEdge(word);
//        }
//        addEdge(beginWord);
//        if (!wordId.containsKey(endWord)) {
//            return 0;
//        }
//
//        int[] disBegin = new int[nodeNum];
//        Arrays.fill(disBegin, Integer.MAX_VALUE);
//        int beginId = wordId.get(beginWord);
//        disBegin[beginId] = 0;
//        Queue<Integer> queBegin = new LinkedList<>();
//        queBegin.offer(beginId);
//
//        int[] disEnd = new int[nodeNum];
//        Arrays.fill(disEnd, Integer.MAX_VALUE);
//        int endId = wordId.get(endWord);
//        disEnd[endId] = 0;
//        Queue<Integer> queEnd = new LinkedList<Integer>();
//        queEnd.offer(endId);
//
//        while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
//            int queBeginSize = queBegin.size();
//            for (int i = 0; i < queBeginSize; ++i) {
//                int nodeBegin = queBegin.poll();
//                if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
//                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
//                }
//                for (int it : edge.get(nodeBegin)) {
//                    if (disBegin[it] == Integer.MAX_VALUE) {
//                        disBegin[it] = disBegin[nodeBegin] + 1;
//                        queBegin.offer(it);
//                    }
//                }
//            }
//
//            int queEndSize = queEnd.size();
//            for (int i = 0; i < queEndSize; ++i) {
//                int nodeEnd = queEnd.poll();
//                if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
//                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
//                }
//                for (int it : edge.get(nodeEnd)) {
//                    if (disEnd[it] == Integer.MAX_VALUE) {
//                        disEnd[it] = disEnd[nodeEnd] + 1;
//                        queEnd.offer(it);
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//    public void addEdge(String word) {
//        addWord(word);
//        int id1 = wordId.get(word);
//        char[] array = word.toCharArray();
//        int length = array.length;
//        for (int i = 0; i < length; ++i) {
//            char tmp = array[i];
//            array[i] = '*';
//            String newWord = new String(array);
//            addWord(newWord);
//            int id2 = wordId.get(newWord);
//            edge.get(id1).add(id2);
//            edge.get(id2).add(id1);
//            array[i] = tmp;
//        }
//    }
//
//    public void addWord(String word) {
//        if (!wordId.containsKey(word)) {
//            wordId.put(word, nodeNum++);
//            edge.add(new ArrayList<Integer>());
//        }
//    }

    private Map<String, Integer> wordId;
    List<List<Integer>> edge = new ArrayList<>();
    private Integer nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordId = new HashMap<>();
        for (String word : wordList) {
            addEdge(word);
        }
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        addEdge(beginWord);
        int[] disBegin = new int[nodeNum];
        int[] disEnd = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);;
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        Queue<Integer> beginId = new LinkedList<>();
        Queue<Integer> endId = new LinkedList<>();
        int sti = wordId.get(beginWord);
        beginId.add(sti);
        disBegin[sti] = 0;
        int eni = wordId.get(endWord);
        endId.add(eni);
        disEnd[eni] = 0;
        return bfs(beginId, disBegin, endId, disEnd);
    }

    private int bfs(Queue<Integer> begin, int[] disBegin, Queue<Integer> end, int[] disEnd) {
        while(!begin.isEmpty() && !end.isEmpty()) {
            int size = begin.size();
            for (int i = 0; i < size; i++) {
                int in = begin.poll();
                if (disEnd[in] != Integer.MAX_VALUE) {
                    return (disBegin[in] + disEnd[in] >> 1) + 1;
                } else {
                    for (int de : edge.get(in)) {
                        if (disBegin[de] == Integer.MAX_VALUE) {
                            disBegin[de] = disBegin[in] + 1;
                            begin.offer(de);
                        }
                    }
                }
            }
            size = end.size();
            for (int i = 0; i < size; i++) {
                int in = end.poll();
                if (disBegin[in] != Integer.MAX_VALUE) {
                    return (disBegin[in] + disEnd[in] >> 1) + 1;
                } else {
                    for (int de : edge.get(in)) {
                        if (disEnd[de] == Integer.MAX_VALUE) {
                            disEnd[de] = disEnd[in] + 1;
                            end.offer(de);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char temp = ch[i];
            ch[i] = '*';
            String newWord = new String(ch);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            ch[i] = temp;
        }
    }

    private void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
//        String beginWord = "hot";
//        String endWord = "dog";
//        String[] arr = {"hot","dog"};
        String beginWord = "hit";
        String endWord = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(arr);
        LadderLength ladderLength = new LadderLength();
        System.out.println(ladderLength.ladderLength(beginWord, endWord, wordList));
    }
}
