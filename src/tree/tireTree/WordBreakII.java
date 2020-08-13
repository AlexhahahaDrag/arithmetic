package tree.tireTree;

import java.util.*;

/**
 * @description:
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * @author:      alex
 * @createTime:  2020/8/11 10:02
 * @version:     1.0
 */
public class WordBreakII {

    TrieTree<Character> root;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieTree<>('0');
        res = new ArrayList<>();
        for (String word : wordDict)
            build(word.toCharArray());
        char[] ch = s.toCharArray();
        List<Integer>[] dp = new List[ch.length + 1];
        for (int i = 0; i < ch.length; i++)
            dp[i] = search(ch, i);
        dfs(dp, "", 0, s);
        return res;
    }

    private void dfs(List<Integer>[] dp, String sb, int index, String s) {
        if (index >= dp.length || dp[index] == null)
            return;
        for (int i : dp[index]) {
            sb += s.substring(index, i + 1);
            if (i == s.length() - 1)
                res.add(sb);
            else
                sb += " ";
            dfs(dp, sb, i + 1, s);
        }
    }

    private List<Integer> search(char[] ch, int from) {
        TrieTree cur = root;
        List<Integer> res = new ArrayList<>();
        for (int i = from; i < ch.length; i++) {
            TrieTree tt = cur.children[ch[i]];
            if (tt == null)
                break;
            if (tt.isEnd)
                res.add(i);
            cur = tt;
        }
        return res;
    }

    private void build(char[] ch) {
        TrieTree cur = root;
        for (char c : ch) {
            if (cur.children[c] == null)
                cur.children[c] = new TrieTree<>(c);
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
     /*  String s = "pineapplepenapple";
        String[] words = {"apple", "pen", "applepen", "pine", "pineapple"};*/
        List<String> wordDict = Arrays.asList(words);
        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(wordBreakII.wordBreak(s, wordDict));
    }
}