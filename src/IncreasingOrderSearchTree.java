public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        System.out.println();
    }
    TreeNode cur=new TreeNode(0);
    TreeNode r=cur;
    public TreeNode increasingBST(TreeNode root) {
        if(root!=null){
            increasingBST(root.left);
            r.right=root;
            r=r.right;
            increasingBST(root.right);
        }
        return cur.right;
    }
}
