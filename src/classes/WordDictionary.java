package classes;

import java.util.List;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 */
public class WordDictionary {
    private DicTree<Character> root;
    public WordDictionary() {
        root = new DicTree('-');
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, DicTree tree) {
        if (index == word.length()) {
            return tree.isEnd;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                DicTree child = tree.children[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        } else {
            DicTree child = tree.children[ch - 'a'];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }
        return false;
    }
}
class DicTree<T> {
    T val;
    DicTree<T>[] children;
    boolean isEnd;

    public DicTree(T val) {
        this.val = val;
        children = new DicTree[26];
    }

    public DicTree() {
    }

    public void insert(String word) {
        char[] words = word.toCharArray();
        DicTree<T> cur = this;
        for (int i = 0; i < words.length; i++) {
            if (cur.children[words[i] - 'a'] == null) {
                cur.children[words[i] - 'a'] = new DicTree(words[i]);
            }
            cur = cur.children[words[i] - 'a'];
        }
        cur.isEnd = true;
    };
}