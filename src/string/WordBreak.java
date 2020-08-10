package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa503c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author:      alex
 * @createTime:  2020/8/10 17:27
 * @version:     1.0
 */
public class WordBreak {

    DicTree<Character> root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new DicTree(0);
        for(String word : wordDict)
            build(root, word.toCharArray());
        return dfs(root, 0, s.toCharArray());
    }

    private boolean dfs(DicTree<Character> dicTree, int i, char[] ch) {
        if (i == ch.length)
            return true;
        if (dicTree == null || dicTree.children == null || dicTree.children.size() == 0)
            return false;
        List<DicTree<Character>> dicTreeList = dicTree.children;
        for (DicTree<Character> dicTree1 : dicTreeList) {
            if (ch[i] == dicTree1.val) {
                if (dicTree1.isEnd)
                    return dfs(dicTree1, i + 1, ch) || dfs(root, i + 1, ch);
                else
                    return dfs(dicTree1, i + 1, ch);
            }
        }
        return false;
    }

    private void build(DicTree<Character> node, char[] ch) {
        DicTree<Character> cu = null;
        for(char c : ch) {
            if (node.children == null) {
                List<DicTree<Character>> list = new ArrayList<>();
                cu = new DicTree(c);
                list.add(cu);
                node.children = list;
            } else {
                boolean flag = false;
                for(DicTree<Character> cn : node.children) {
                    if (cn.val == c) {
                        flag = true;
                        cu = cn;
                        break;
                    }
                }
                if (!flag) {
                    cu = new DicTree<>(c);
                    node.children.add(cu);
                }
            }
            node = cu;
        }
        cu.isEnd = true;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        String[] words = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = Arrays.asList(words);
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, wordDict));
    }
}
class DicTree<T> {
    public T val;
    public boolean isEnd;
    public List<DicTree<T>> children;
    public DicTree(T _val) {
        val = _val;
    }
}
