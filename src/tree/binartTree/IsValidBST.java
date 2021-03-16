package tree.binartTree;


/**
 *description:
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *author:       alex
 *createDate:  2020/2/24 22:56
 *version:      1.0.0
*/
public class IsValidBST {

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return findLeft(root.left, root.val) && findRight(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean findRight(TreeNode treeNode, int val) {
        if (treeNode == null) {
            return true;
        }
        return treeNode.val > val && findRight(treeNode.left, val) && findRight(treeNode.right, val);
    }

    private boolean findLeft(TreeNode treeNode, int val) {
        if (treeNode == null) {
            return true;
        }
        return treeNode.val < val && findLeft(treeNode.left, val) && findLeft(treeNode.right, val);
    }

    Long cur = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left) && cur < (cur = (long)root.val)  && isValidBST(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));
    }
}
