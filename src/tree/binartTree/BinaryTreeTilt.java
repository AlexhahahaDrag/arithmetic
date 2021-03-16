package tree.binartTree;

/**
 * @Description: Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 *
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 * @Author:      alex
 * @CreateDate:  2019/5/21 14:58
 * @param
 * @return
*/
public class BinaryTreeTilt {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.right.left=new TreeNode(5);
        System.out.println(findTilt(treeNode));
    }
    static int tilt=0;
    public static int findTilt(TreeNode root) {
        getSum(root);
        return tilt;
    }
    public static int getSum(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left=getSum(root.left);
        int right=getSum(root.right);
        tilt+=Math.abs(left-right);
        return root.val+left+right;
    }
}
