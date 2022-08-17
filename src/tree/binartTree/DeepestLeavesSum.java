package tree.binartTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *@description:
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 *@author:       alex
 *@createDate:   2022/8/17 21:38
 *@version:      1.0.0
 */
public class DeepestLeavesSum {

    public int deepestLeavesSum1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        int size;
        while(!queue.isEmpty()) {
            res = 0;
            size = queue.size();
            int i = 0;
            while(i++ < size) {
                TreeNode cur = queue.poll();
                res += cur.val;
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }

    private int res = 0;
    private int maxLevel = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            res = 0;
        }
        if(level == maxLevel) {
            res += root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
