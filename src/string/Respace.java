package string;

/**
 * Description:
 * 面试题 17.13. 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 *
 *
 *
 * 示例：
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 *
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * Author:      alex
 * CreateDate:  2020/7/9 12:25
 * Version:     1.0
 *
*/
public class Respace {

    public int respace(String[] dictionary, String sentence) {
        Trie diction = new Trie();
        for (String dic : dictionary)
            diction.insert(dic);
        int len = sentence.length();
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            Trie trie = diction;
            dp[i] = dp[i - 1] + 1;
            for (int j = i; j >= 1; j--) {
                int in = sentence.charAt(j - 1) - 'a';
                if (trie.next[in] == null)
                    break;
                if (trie.next[in].isEnd)
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                if (dp[i] == 0)
                    break;
                trie = trie.next[in];
            }
        }
        return dp[len];
    }

    class Trie {

        Trie[] next;

        boolean isEnd;

        public Trie() {
            this.next = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String s) {
            Trie cur = this;
            int index = s.length() - 1;
            while(index >= 0) {
                int in = s.charAt(index--) - 'a';
                if (cur.next[in] == null)
                    cur.next[in] = new Trie();
                cur = cur.next[in];
            }
            cur.isEnd = true;
        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        Respace respace = new Respace();
        System.out.println(respace.respace(dictionary, sentence));
    }
}
