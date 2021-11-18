package tree.binartTree;

/**
 *description:  
 *author:       alex
 *createDate:   2021/11/18 12:40
 *version:      1.0.0
 */
public class FindTilt {

    private int res = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return res;
    }

    private int sum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int l = sum(node.left);
        int r = sum(node.right);
        res += l > r ? l -r : r - l;
        return node.val + l + r;
    }
}
