package tree.binartTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 * @Author:      alex
 * @CreateDate:  2019/5/21 16:17
 * @param
 * @return
*/
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(4);
        treeNode.add(2,treeNode);treeNode.add(7,treeNode);treeNode.add(9,treeNode);
        treeNode.add(6,treeNode);
        treeNode.add(3,treeNode);treeNode.add(1,treeNode);
        System.out.println(treeNode);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            if(root.left!=null&&root.right!=null){
                TreeNode temp=root.left;
                root.left=root.right;
                root.right=temp;
                invertTree(root.left);
                invertTree(root.right);
            }else if(root.left==null){
                root.left=root.right;
                root.right=null;
                invertTree(root.left);
            }else if(root.right==null){
                root.right=root.left;
                root.left=null;
                invertTree(root.right);
            }

        }
        return root;
    }
}
