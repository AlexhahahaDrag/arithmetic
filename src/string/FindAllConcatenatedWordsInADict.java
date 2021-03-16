package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 472. 连接词
 * 给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。
 *
 * 连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
 *
 * 示例:
 *
 * 输入: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 *
 * 输出: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 *
 * 解释: "catsdogcats"由"cats", "dog" 和 "cats"组成;
 *      "dogcatsdog"由"dog", "cats"和"dog"组成;
 *      "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
 * 说明:
 *
 * 给定数组的元素总数不超过 10000。
 * 给定数组中元素的长度总和不超过 600000。
 * 所有输入字符串只包含小写字母。
 * 不需要考虑答案输出的顺序。
 * @author:      alex
 * @createTime:  2020/10/23 16:27
 * @version:     1.0
 */
public class FindAllConcatenatedWordsInADict {

    private TrieTree<Character> trieTree;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        trieTree = new TrieTree<>();
        for (String word : words) {
            build(word);
        }
        for (String word : words) {
            if (find(word.toCharArray(), trieTree, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean find(char[] chars, TrieTree<Character> cur, int index, int count) {
        if (index == chars.length && cur.isEnd && count > 0) {
            return true;
        }
        if (index >= chars.length || cur.children == null || cur.children[chars[index] - 'a'] == null) {
            return false;
        }
        if (cur.children[chars[index] - 'a'].isEnd) {
            return find(chars, cur.children[chars[index] - 'a'], index + 1, count) || find(chars, trieTree, index + 1, count + 1);
        } else {
            return find(chars, cur.children[chars[index] - 'a'], index + 1, count);
        }
    }

    private void build(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        TrieTree<Character> cur = trieTree;
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieTree<>(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    class TrieTree<Character> {
        public Character val;
        public boolean isEnd;
        public TrieTree<Character>[] children;

        public TrieTree(Character val) {
            this.val = val;
            children = new TrieTree[26];
        }

        public TrieTree() {
            children = new TrieTree[26];
        }
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        FindAllConcatenatedWordsInADict findAllConcatenatedWordsInADict = new FindAllConcatenatedWordsInADict();
        System.out.println(findAllConcatenatedWordsInADict.findAllConcatenatedWordsInADict(words));
    }
}
