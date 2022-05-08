package tree.binartTree;

/**
 *description:
 * 6057. 统计值等于子树平均值的节点数
 * 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
 *
 * 注意：
 *
 * n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
 * root 的 子树 由 root 和它的所有后代组成。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,8,5,0,1,null,6]
 * 输出：5
 * 解释：
 * 对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
 * 对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
 * 对值为 0 的节点：子树的平均值 0 / 1 = 0 。
 * 对值为 1 的节点：子树的平均值 1 / 1 = 1 。
 * 对值为 6 的节点：子树的平均值 6 / 1 = 6 。
 * 示例 2：
 *
 *
 * 输入：root = [1]
 * 输出：1
 * 解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 100
 *author:       alex
 *createDate:   2022/5/8 19:01
 *version:      1.0.0
 */
public class AverageOfSubtree {private int res;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(0, 0);
        }
        Result left = dfs(node.left);
        Result right = dfs(node.right);
        int sum = left.sum + right.sum + node.val;
        int num = left.num + right.num + 1;
        if (sum / num == node.val) {
            res++;
        }
        return new Result(num, sum);
    }
}
class Result{
    int num;
    int sum;
    public Result(int num, int sum) {
        this.num = num;
        this.sum = sum;
    }
}

