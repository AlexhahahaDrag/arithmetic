package tree.binartTree;

/**
 *description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2019/12/29 12:16
 *version:      1.0.0      
*/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return is(root.left, root.right);
    }

    private boolean is(TreeNode root1, TreeNode root2) {
        if(root1 != null && root2 != null) {
            if(root1.val != root2.val) {
                return false;
            }
            return is(root1.left, root2.right) && is(root1.right, root2.left);
        } else if(root1 == null && root2 == null) {
            return true;
        } else {
            return false;
        }
    }
}
