package tree.binartTree;

/**
 *description:
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *author:       alex
 *createDate:   2022/5/16 7:18
 *version:      1.0.0
 */
public class InorderSuccessor {


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return find(root, p);
    }

    private TreeNode find(TreeNode node, TreeNode p) {
        if (node == null) {
            return null;
        }
        if (node.val > p.val) {
            TreeNode cur = find(node.left, p);
            return cur == null ? node : cur;
        } else {
            return find(node.right, p);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        TreeNode p = null;
        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        System.out.println(inorderSuccessor.inorderSuccessor(root, p));
    }
}
