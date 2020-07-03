package tree.binartTree;

/**
 * Description:
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * Author:      alex
 * CreateDate:  2020/7/3 12:30
 * Version:     1.0
 *
*/
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return toBst(nums, 0, nums.length - 1);
    }

    private TreeNode toBst(int[] nums, int start, int end) {
        if (start > end)
            return null;
        //右子树多
       /* int mid = start + (end - start + 1 >> 1);*/
        //左子树多
        int mid = start + (end - start + 1 >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBst(nums, start, mid - 1);
        root.right = toBst(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode res = sortedArrayToBST.sortedArrayToBST(nums);
        System.out.println(res.toString());
    }
}
