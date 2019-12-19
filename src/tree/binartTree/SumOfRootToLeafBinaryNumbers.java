package tree.binartTree;

/**
 * @Description: Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 * Example 1:
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 * @Author:      alex
 * @CreateDate:  2019/5/21 16:04
 * @param
 * @return
*/
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNodeByArr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println();
    }
    static int sum=0;
    public static int sumRootToLeaf(TreeNode root) {
        getSum(root,0);
        return sum;
    }
    public static void getSum(TreeNode root, int cur) {
        if(root!=null){
            cur<<=1;
            cur+=root.val;
            if(root.left==null&&root.right==null)
                sum+=cur;
            getSum(root.left,cur);
            getSum(root.right,cur);
        }
    }
}
