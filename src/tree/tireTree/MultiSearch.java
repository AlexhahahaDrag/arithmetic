package tree.tireTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 面试题 17.17. 多次搜索
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 *
 * 示例：
 *
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 *
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 * @author:      alex
 * @createTime:  2020/9/27 14:04
 * @version:     1.0
 */
public class MultiSearch {
    private Tree<Character> tree;
    private int len;
    public int[][] multiSearch(String big, String[] smalls) {
        len = big.length();
        tree = new Tree('-');
        for (int i = big.length() - 1; i >= 0; i--) {
            getTree(big, i, tree);
        }
        int[][] res = new int[smalls.length][];
        for(int j = 0; j < smalls.length; j++) {
            Tree<Character> cur = tree;
            int i = smalls[j].length() - 1;
            for (;i >= 0; i--) {
                if(cur.childern[smalls[j].charAt(i) - 'a'] == null) {
                    break;
                }
                cur = cur.childern[smalls[j].charAt(i) - 'a'];
            }
            if (i == -1 && cur.index != null) {
                res[j] = new int[cur.index.size()];
                int in = 0;
                for (int k = cur.index.size() - 1; k >= 0; k--) {
                    res[j][in++] = cur.index.get(k);
                }
            } else {
                res[j] = new int[0];
            }
        }
        return res;
    }

    private void getTree(String big, int index, Tree tree) {
        for (int i = index; i >= 0; i--) {
            if(tree.childern[big.charAt(i) - 'a'] == null) {
                tree.childern[big.charAt(i) - 'a'] = new Tree(big.charAt(i));
            }
            tree = tree.childern[big.charAt(i) - 'a'];
            if (tree.index == null) {
                tree.index = new ArrayList();
            }
            tree.index.add(i);
        }
    }
    class Tree<T>
    {
        T val;
        Tree[] childern = new Tree[26];
        List<Integer> index;
        public Tree(T val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        String big = "mississippi";
//        String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
        String big = "abc";
        String[] smalls = {""};
        MultiSearch multiSearch = new MultiSearch();
        int[][] res = multiSearch.multiSearch(big, smalls);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
    }
}


