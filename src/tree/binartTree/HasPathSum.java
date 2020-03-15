package tree.binartTree;

/**
 *description:
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *author:       alex
 *createDate:  2020/3/15 16:58
 *version:      1.0.0
*/
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return dfs(root, sum, 0);
    }

    private boolean dfs(TreeNode root, int sum, int cur) {
        if(root == null)
            return false;
        cur += root.val;
        if (root.left == null && root.right == null)
            return sum == cur;
        return dfs(root.left, sum, cur) || dfs(root.right, sum, cur);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        HasPathSum hasPathSum = new HasPathSum();
        System.out.println(hasPathSum.hasPathSum(treeNode, 22));
    }
}
