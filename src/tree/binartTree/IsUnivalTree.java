package tree.binartTree;

public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        return judge(root, root.val);
    }

    private boolean judge(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && judge(node.left, val) && judge(node.right, val);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 1, null, 1, 1, null};
        TreeNode root = TreeNode.getTreeNodeByArr(arr);
        IsUnivalTree isUnivalTree = new IsUnivalTree();
        System.out.println(isUnivalTree.isUnivalTree(root));
    }
}
