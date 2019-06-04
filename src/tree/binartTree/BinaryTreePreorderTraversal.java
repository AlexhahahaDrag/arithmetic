package tree.binartTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        System.out.println(binaryTreePreorderTraversal.preorderTraversal(treeNode));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
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
