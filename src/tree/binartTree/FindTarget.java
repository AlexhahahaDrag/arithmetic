package tree.binartTree;

/**
 *description:
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *author:       alex
 *createDate:   2020/6/1 21:25
 *version:      1.0.0
 */
public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        TreeNode res = root;
        return findInfo(res, root, k);
    }

    private boolean findInfo(TreeNode res, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return find(res.left, k - root.val) || find(res.right, k - root.val)
                || findInfo(res, root.left, k) || findInfo(res, root.right, k);
    }

    private boolean find(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        } else if (root.val > target) {
            return find(root.left, target);
        } else {
            return find(root.right, target);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        FindTarget findTarget = new FindTarget();
        System.out.println(findTarget.findTarget(treeNode, 6));
    }
}
