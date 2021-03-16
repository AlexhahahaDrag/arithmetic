/**
 * @Description:
 * @Author:      alex
 * @CreateDate:  2019/3/26 10:59
 * @param
 * @return
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.right=new TreeNode(3);
        TreeNode q=new TreeNode(1);
        q.left=new TreeNode(2);
        q.right=new TreeNode(3);
        System.out.println(isSameTree(p,q));
    }
    public static  boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) {
            return true;
        } else if(p!=null&&q!=null){
            if(p.val==q.val){
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

