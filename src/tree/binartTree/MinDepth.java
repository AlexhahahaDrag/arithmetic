package tree.binartTree;

/**
 *description:
 *author:       alex
 *createDate:  2020/3/24 20:19
 *version:      1.0.0
*/
public class MinDepth {

    public int minDepth(TreeNode root) {
        return findMin(root);
    }

    private int findMin(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findMin(root.left);
        int right = findMin(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
