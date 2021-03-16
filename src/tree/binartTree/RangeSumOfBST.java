package tree.binartTree;

public class RangeSumOfBST {
    int resultSum = 0;
    boolean flag = true;
    public static void main(String[] args) {


        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right =new TreeNode(18);
        treeNode.left.left.left = new TreeNode(1);
        treeNode.left.right.left = new TreeNode(6);
        System.out.println(rangeSumOfBST.rangeSumBST(treeNode,6,10));
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        getSum(root, L, R);
        return resultSum;
    }
    private void getSum(TreeNode node, int L, int R) {
        if (node != null) {
            if (node.val >= L && node.val <= R) {
                resultSum += node.val;
            }
            if (node.val > L) {
                getSum(node.left, L , R);
            }
            if (node.val < R) {
                getSum(node.right, L , R);
            }
        }
    }
}
