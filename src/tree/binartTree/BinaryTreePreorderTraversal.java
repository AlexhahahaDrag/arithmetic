package tree.binartTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * @Author:      alex
 * @CreateDate:  2019/5/23 13:54
 * @param
 * @return
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal binaryTreePreorderTraversal=new BinaryTreePreorderTraversal();
        TreeNode treeNode=new TreeNode(1);
        treeNode.right=new TreeNode(3);
        treeNode.right.left=new TreeNode(2);
        System.out.println(binaryTreePreorderTraversal.preorderTraversal(treeNode));
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        pre(root);
        return res;
    }

    private void pre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode != null) {
                res.add(treeNode.val);
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<Integer> list=new LinkedList<>();
        preorder(root,list);
        return list;
    }
    private void preorder(TreeNode node,LinkedList<Integer> list){
        if(node!=null){
            preorder(node.left,list);
            list.add(node.val);
            preorder(node.right,list);
        }
    }
}
