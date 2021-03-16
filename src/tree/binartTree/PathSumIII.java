package tree.binartTree;

import java.math.BigDecimal;

/**
 *description:
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *author:       alex
 *createDate:  2020/3/10 8:31
 *version:      1.0.0
*/
public class PathSumIII {

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return count;
    }

    private void dfs(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        find(root, 0, sum);
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    private void find(TreeNode root, int cur, int sum) {
        if(root == null) {
            return;
        }
        cur += root.val;
        if(sum == cur) {
            count++;
        }
        find(root.left, cur, sum);
        find(root.right, cur, sum);
    }

    public static void main(String[] args) {
        Double d = new Double(565013.69);
        System.out.println(new BigDecimal("-565013.69").add(new BigDecimal(d.toString())));
        TreeNode treeNode = new TreeNode(1);
        System.out.println(treeNode.toString());
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(treeNode, 8));
    }
}
