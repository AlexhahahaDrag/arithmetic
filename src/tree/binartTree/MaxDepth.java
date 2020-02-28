package tree.binartTree;

/**
 *description:
 * 面试题55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *author:       alex
 *createDate:  2020/2/28 22:00
 *version:      1.0.0
*/
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(10);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(treeNode));
    }
}
