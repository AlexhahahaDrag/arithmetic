package tree.binartTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *description:
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *author:       alex
 *createDate:  2020/2/24 22:20
 *version:      1.0.0
*/
public class InorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal1(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        inorder(treeNode.left);
        res.add(treeNode.val);
        inorder(treeNode.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res1 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res1.add(cur.val);
            cur = cur.right;
        }
        return res1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(root));
    }
}
