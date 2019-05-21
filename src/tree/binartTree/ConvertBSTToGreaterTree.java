package tree.binartTree;
/**
 * @Description: Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * @Author:      alex
 * @CreateDate:  2019/5/21 17:05
 * @param
 * @return
*/
public class ConvertBSTToGreaterTree {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(13);
        treeNode.left.left=new TreeNode(1);
        treeNode.left.right=new TreeNode(4);
        treeNode.right.right=new TreeNode(17);
        treeNode.right.left=new TreeNode(8);
        System.out.println(treeNode);
        ConvertBSTToGreaterTree convertBSTToGreaterTree=new ConvertBSTToGreaterTree();
        System.out.println(convertBSTToGreaterTree.convertBST(treeNode));
    }
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }
}
