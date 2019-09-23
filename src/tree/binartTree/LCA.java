package tree.binartTree;

/**
 * @Description: LCA（Least Common Ancestors），即最近公共祖先，是指在有根树中，找出某两个结点u和v最近的公共祖先。
 * @Author:     alex
 * @CreateDate: 2019/9/23 12:42
 * @Version:    1.0
 *
*/
public class LCA {

    public static void main(String[] args) {
        LCA lca = new LCA();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        System.out.println(lca.getCommonAncestor(treeNode, new TreeNode(2),new TreeNode(4)));
    }

    private TreeNode getCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root != null) {
            if (node1.val == root.val || node2.val == root.val)
                return root;
            TreeNode left = getCommonAncestor(root.left, node1, node2);
            TreeNode right = getCommonAncestor(root.right, node1, node2);
            if (left != null) {
                if (right != null)
                    return root;
                else
                    return left;
            } else
            if (right != null)
                return right;
            else
                return null;
        }
        return null;
    }
}

