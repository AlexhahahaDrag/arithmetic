package tree.binartTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *description:
 *145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *author:       alex
 *createDate:  2020/2/24 21:53
 *version:      1.0.0
 */
public class PostorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal1(TreeNode root) {
        postor(root);
        return list;
    }

    private void postor(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postor(treeNode.left);
        postor(treeNode.right);
        list.add(treeNode.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.size() > 0) {
            TreeNode treeNode = stack.pop();
            res.add(0, treeNode.val);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        return res;
    }

    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == pre) {
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.add(root);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        System.out.println(postorderTraversal.postorderTraversal(treeNode));
    }
}
