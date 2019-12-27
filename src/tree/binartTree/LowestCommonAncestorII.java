package tree.binartTree;

import listNode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Description:
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/27 14:39
 * Version:     1.0
 *
*/
public class LowestCommonAncestorII {

    TreeNode treeNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findList(root, p, q);
        return treeNode;
    }

    private int findList(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return  0;
        int le = findList(root.left, p, q);
        int ri = findList(root.right, p, q);
        int res = le + ri + ((p.val == root.val || q.val == root.val) ? 1 : 0);
        if (res > 1) {
            treeNode = root;
            res = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LowestCommonAncestorII lowestCommonAncestorII = new LowestCommonAncestorII();
        TreeNode treeNode = lowestCommonAncestorII.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }
}
