/**
 * @Description: Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * @Author:      alex
 * @CreateDate:  2019/3/29 14:18
 * @param
 * @return
 */
public class SumOfLeftLeaves {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        return getSum(root.left,true)+getSum(root.right,false);
    }
    public int getSum(TreeNode root,boolean isLeft){
        if(root==null)
            return 0;
        if(isLeft&&root.left==null&&root.right==null)
            return root.val;
        else
            return getSum(root.left,true)+getSum(root.right,false);
    }
}
