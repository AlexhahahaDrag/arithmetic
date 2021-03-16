/**
 * @Description: A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: [2,2,2,5,2]
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 * @Author:      alex
 * @CreateDate:  2019/4/2 13:41
 * @param
 * @return
*/
public class UnivaluedBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(1);
        treeNode.left.left=new TreeNode(1);
        treeNode.left.right=new TreeNode(1);
        treeNode.right.right=new TreeNode(1);
        System.out.println(isUnivalTree(treeNode));
    }
    public static boolean isUnivalTree(TreeNode root) {
        if(root==null) {
            return true;
        }
        if(root.left==null&&root.right==null) {
            return true;
        }
        return (root.left==null||(root.left.val==root.val&&isUnivalTree(root.left)))&&
                (root.right==null||(root.right.val==root.val&&isUnivalTree(root.right)));
    }
}
