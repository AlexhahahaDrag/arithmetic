package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 988. 从叶结点开始的最小字符串
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 *
 *
 *
 * 输入：[25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 *
 *
 *
 * 输入：[2,2,1,null,1,0,null,0]
 * 输出："abc"
 *
 *
 * 提示：
 *
 * 给定树的结点数介于 1 和 8500 之间。
 * 树中的每个结点都有一个介于 0 和 25 之间的值。
 *author:       alex
 *createDate:  2020/3/15 20:55
 *version:      1.0.0      
*/
public class SmallestFromLeaf {

    List<List<Integer>> lists = new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        path(root, new ArrayList<>());
        int min = 0;
        for (int i = 1; i < lists.size(); i++) {
            if (!judge(lists.get(min), lists.get(i))) {
                min = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = lists.get(min).size() - 1; i >= 0; i--) {
            res.append((char)(lists.get(min).get(i) + 'a'));
        }
        return res.toString();
    }

    private boolean judge(List<Integer> l1, List<Integer> l2) {
        int len1 = l1.size();
        int len2 = l2.size();
        while(--len1 >= 0 && --len2 >= 0) {
            if (l1.get(len1) < l2.get(len2)) {
                return true;
            } else if (l1.get(len1) > l2.get(len2)) {
                return false;
            }
        }
        return len1 == 0;
    }

    private void path(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        List<Integer> cur = new ArrayList<>();
        cur.addAll(list);
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            lists.add(cur);
        }
        path(root.left, cur);
        path(root.right, cur);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        SmallestFromLeaf smallestFromLeaf = new SmallestFromLeaf();
        System.out.println(smallestFromLeaf.smallestFromLeaf(treeNode));
    }
}
