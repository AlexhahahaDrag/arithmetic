package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/3/15 20:26
 *version:      1.0.0      
*/
public class BinaryTreePaths {

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths1(TreeNode root) {
        int[] dp = new int[depth(root)];
        if (root != null) {
            treePaths(root, dp, 0);
        }
        return res;
    }

    private void treePaths(TreeNode root, int[] dp, int index) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < index; i++) {
                sb.append(dp[i] + "->");
            }
            sb.append(root.val);
            res.add(sb.toString());
        } else {
            dp[index] = root.val;
            treePaths(root.left, dp, index + 1);
            treePaths(root.right, dp, index + 1);
        }
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        path(root, "");
        return res;
    }

    private void path(TreeNode root, String sb) {
        if(root == null) {
            return;
        }
        sb = sb + Integer.toString(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb = sb + "->";
            path(root.left, sb);;
            path(root.right, sb);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        path(root, new StringBuilder());
        return res;
    }

    private void path(TreeNode root, StringBuilder str) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            res.add(str.append(root.val).toString());
            return;
        }
        str.append(root.val);
        str.append("->");
        path(root.left, new StringBuilder(str));
        path(root.right, new StringBuilder(str));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.out.println(binaryTreePaths.binaryTreePaths(treeNode));
    }
}
