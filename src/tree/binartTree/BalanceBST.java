package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 5179. 将二叉搜索树变平衡
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *
 *
 * 提示：
 *
 * 树节点的数目在 1 到 10^4 之间。
 * 树节点的值互不相同，且在 1 到 10^5 之间。
 *author:       alex
 *createDate:  2020/3/15 20:26
 *version:      1.0.0      
*/
public class BalanceBST {
    List<Integer> res = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        midOrder(root);
        if (res.size() < 3) {
            return root;
        }
        root = build(0, res.size() - 1);
        return root;
    }

    private TreeNode build(int start, int end) {
        if(start <= end) {
            int mid = (end - start >> 1) + start;
            TreeNode root = new TreeNode(res.get(mid));
            root.left = build(start, mid - 1);
            root.right = build(mid + 1, end);
            return root;
        }
        return null;
    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        res.add(root.val);
        midOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        BalanceBST balanceBST = new BalanceBST();
        TreeNode root = balanceBST.balanceBST(treeNode);
        System.out.println(root.toString());
    }
}
