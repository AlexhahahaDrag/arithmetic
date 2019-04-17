/**
 * @Description: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * @Author:      alex
 * @CreateDate:  2019/4/2 9:48
 * @param
 * @return
 */
public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree symmetricTree=new SymmetricTree();
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(2);
        t.left.left=new TreeNode(3);
        t.right.right=new TreeNode(3);
        t.left.right=new TreeNode(4);
        t.right.left=new TreeNode(4);
        System.out.println(isSymmetric(t));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public static boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null)
            return true;
        if(t1==null||t2==null)
            return false;
        return t1.val==t2.val&&isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
