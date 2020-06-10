package tree.binartTree;

import listNode.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *description:
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *author:       alex
 *createDate:   2020/6/10 21:35
 *version:      1.0.0
 */
public class FindDuplicateSubtrees {

    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        collect1(root);
        return res;
    }

    private String collect1(TreeNode root) {
        if (root == null)
            return "#";
        String serial = root.val + "," + collect1(root.left) + "," + collect1(root.right);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2)
            res.add(root);
        return serial;
    }

    List<TreeNode> result;
    Map<Integer, Integer> counts;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList();
        counts = new HashMap();
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 1111;
        int id = ((dfs(node.left) ^ 3) * 1111 + (dfs(node.right) ^ 5)) * 1111 + node.val;
        int count = counts.getOrDefault(id, 0) + 1;
        if (count == 2) {
            result.add(node);
        }
        counts.put(id, count);
        return id;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        System.out.println(findDuplicateSubtrees.findDuplicateSubtrees(root));
    }
}
