package string;

import java.util.*;

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
class DicTree<T> {
    public T val;
    public boolean isEnd;
    public DicTree<T>[] children;

    public DicTree(T val) {
        this.val = val;
        children = new DicTree[256];
    }
}
public class WordBreak {

    DicTree<Character> root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new DicTree(0);
        for(String word : wordDict)
            build(word.toCharArray());
        return bfs(0, s.toCharArray());
    }

    private boolean bfs(int i, char[] ch) {
       Queue<Integer> queue = new LinkedList<>();
       queue.add(0);
       boolean[] visited = new boolean[ch.length + 1];
       while(!queue.isEmpty()) {
           int index = queue.poll();
           Set<Integer> set = searchPrefixes(ch, index);
           for(int se : set) {
               if (se == ch.length - 1)
                   return true;
               if (visited[se])
                   continue;
               visited[se] = true;
               queue.add(se + 1);
           }
       }
       return false;
    }

    private void build(char[] ch) {
        DicTree<Character> cur = root;
        for(char c : ch) {
            if (cur.children[c] == null) {
                cur.children[c] = new DicTree<>(c);
            }
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }

    private Set<Integer> searchPrefixes(char[] ch, int from) {
        DicTree<Character> cur = root;
        Set<Integer> res = new HashSet<>();
        for (int i = from; i < ch.length; i++) {
            cur = cur.children[ch[i]];
            if (cur == null)
                break;
            else if (cur.isEnd)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
       /* String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaba";
        String[] words = {"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"};*/
        String s = "aaaaaaa";
        String[] words = {"aa", "aaaa"};
        List<String> wordDict = Arrays.asList(words);
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, wordDict));
    }
}

