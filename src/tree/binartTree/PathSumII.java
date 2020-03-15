package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *author:       alex
 *createDate:  2020/3/15 20:05
 *version:      1.0.0
*/
public class PathSumII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        path(root, sum, 0, new ArrayList<>());
        return res;
    }

    private void path(TreeNode root, int sum, int cur, List<Integer> list) {
        if(root == null)
            return;
        List<Integer> curList = new ArrayList<>();
        curList.addAll(list);
        cur += root.val;
        curList.add(root.val);
        if (root.left == null && root.right == null) {
            if (cur == sum)
                res.add(curList);
        }
        path(root.left, sum, cur, curList);
        path(root.right, sum, cur, curList);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        PathSumII pathSumII = new PathSumII();
        System.out.println(pathSumII.pathSum(treeNode, 22));
    }
}
