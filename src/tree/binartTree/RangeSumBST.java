package tree.binartTree;

/**
 *description:
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 *
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *author:       alex
 *createDate:  2020/2/25 17:35
 *version:      1.0.0
*/
public class RangeSumBST {

    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        find(root, L, R);
        return sum;
    }

    private void find(TreeNode root, int l, int r) {
        if (root != null) {
            if (root.val >= l && root.val <= r) {
                sum += root.val;
            }
            if (root.val > l) {
                find(root.left, l, r);
            }
            if (root.val < r) {
                find(root.right, l, r);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.right =new TreeNode(18);
        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(treeNode, 7, 15));
    }
}
