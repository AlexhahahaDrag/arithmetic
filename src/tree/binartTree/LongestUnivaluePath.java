package tree.binartTree;

/**
 *@description:  
 *@author:       alex
 *@createDate:   2022/9/2 10:50
 *@version:      1.0.0
 */
public class LongestUnivaluePath {

    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left != null && root.left.val == root.val) {
            left += 1;
        } else {
            left = 0;
        }
        if (root.right != null && root.right.val == root.val) {
            right += 1;
        } else {
            right = 0;
        }
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
