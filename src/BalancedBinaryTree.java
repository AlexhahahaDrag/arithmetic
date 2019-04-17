/**
 * @Description: Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * @Author:      alex
 * @CreateDate:  2019/4/4 15:02
 * @param
 * @return
*/
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.left.left=new TreeNode(4);
        treeNode.right.right=new TreeNode(3);
        treeNode.left.left.right=new TreeNode(4);
        System.out.println(isBalanced(treeNode));
    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        TreeNode curr=root;
        if(curr!=null)
            if(Math.abs(height(curr.left)-height(curr.right))>1)
                return false;
        return isBalanced(curr.left)&&isBalanced(curr.right);
    }
    public static int height(TreeNode node){
        if(node==null)
            return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
}
