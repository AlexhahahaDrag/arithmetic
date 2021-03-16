package tree.binartTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *description:
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 *
 * 提示：
 *author:       alex
 *createDate:   2020/9/12 9:57
 *version:      1.0.0
 */
public class AverageOfLevels {

    Map<Integer, List<Integer>> map = new HashMap<>();
    public List<Double> averageOfLevels1(TreeNode root) {
        getAverage(root, 0);
        List<Double> res = new ArrayList<>();
        for(List<Integer> li : map.values()) {
            double sum = 0.0;
            for(Integer i : li) {
                sum += i;
            }
            res.add(sum / li.size());
        }
        return res;
    }

    private void getAverage(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        List<Integer> li;
        if(map.get(level) == null) {
            li = new ArrayList<>();
            li.add(root.val);
            map.put(level, li);
        } else {
            li = map.get(level);
            li.add(root.val);
        }
        getAverage(root.left, level + 1);
        getAverage(root.right, level + 1);
    }

    List<Double> res;
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> parents = new ArrayList<>();
        parents.add(root);
        res = new ArrayList<>();
        average(parents);
        return res;
    }

    private void average(List<TreeNode> parents) {
        if (parents == null || parents.isEmpty()) {
            return;
        }
        List<TreeNode> cur = new ArrayList<>();
        double sum = 0;
        int count = 0;
        for (TreeNode treeNode : parents) {
            count++;
            sum += treeNode.val;
            if (treeNode.left != null) {
                cur.add(treeNode.left);
            }
            if (treeNode.right != null) {
                cur.add(treeNode.right);
            }
        }
        res.add(sum / count);
        average(cur);
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 20, 15, 7};
        TreeNode root = TreeNode.getTreeNodeByArr(arr);
        AverageOfLevels averageOfLevels = new AverageOfLevels();
        System.out.println(averageOfLevels.averageOfLevels(root));
    }
}
