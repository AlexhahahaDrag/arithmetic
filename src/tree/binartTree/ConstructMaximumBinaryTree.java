package tree.binartTree;

/**
 *description:
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *author:       alex
 *createDate:  2020/3/31 14:20
 *version:      1.0.0      
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        TreeNode root = null;
        for(int i : nums) {
            root = maxTree1(root, i);
        }
        return root;
    }

    private TreeNode maxTree1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode ro = new TreeNode(val);
            ro.left = root;
            return ro;
        } else {
            root.right = maxTree1(root.right, val);
        }
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums,0, nums.length - 1);
    }

    private TreeNode maxTree(int nums[], int l, int r) {
        if (l > r) {
            return null;
        }
        int bounds = getMax(nums, l, r);
        TreeNode root = new TreeNode(nums[bounds]);
        root.left = maxTree(nums,l, bounds - 1);
        root.right = maxTree(nums, bounds + 1, r);
        return root;
    }

    private int getMax(int[] nums, int l, int r) {
        int max = l;
        for (int i = l; i <= r; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode res = constructMaximumBinaryTree.constructMaximumBinaryTree(nums);
        System.out.println(res.toString());
    }
}
