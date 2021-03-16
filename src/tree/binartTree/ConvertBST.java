package tree.binartTree;

/**
 * @description:
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 * @author:      alex
 * @createTime:  2020/9/21 12:00
 * @version:     1.0
 */
public class ConvertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        convert(root, 0);
        return root;
    }

    private int convert(TreeNode root, int right) {
        if (root == null) {
            return right;
        }
        root.val += convert(root.right, right);
        return convert(root.left, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        ConvertBST convertBST = new ConvertBST();
        System.out.println(convertBST.convertBST(root));
    }
}
