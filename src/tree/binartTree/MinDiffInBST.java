package tree.binartTree;

/**
 * @description:
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 * @author:      alex
 * @createTime:  2021/4/13 12:40
 * @version:     1.0
 */
public class MinDiffInBST {

    private int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        min(root);
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    private void min(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.left != null) {
            TreeNode r = root.left;
            while(r.right != null) {
                r = r.right;
            }
            min = Math.min(root.val - r.val, min);
            min(root.left);
        }
        if(root.right != null) {
            TreeNode l = root.right;
            while(l.left != null) {
                l = l.left;
            }
            min = Math.min(l.val - root.val, min);
            min(root.right);
        }
    }
}
