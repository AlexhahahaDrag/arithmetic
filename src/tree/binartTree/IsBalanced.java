package tree.binartTree;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return (left - right <= 1 && left - right >= -1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        return 1 + Math.max(depth(treeNode.left), depth(treeNode.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(10);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(-1);
        IsBalanced isBalanced = new IsBalanced();
        System.out.println(isBalanced.isBalanced(treeNode));
    }
}
