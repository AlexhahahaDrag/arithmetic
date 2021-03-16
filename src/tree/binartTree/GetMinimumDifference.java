package tree.binartTree;

import listNode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 * 示例 :
 *
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/26 14:19
 * Version:     1.0
 *
*/
public class GetMinimumDifference {
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        getList(root, list);
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < min) {
                min = arr[i] - arr[i - 1];
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void getList(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            getList(node.left, list);
            getList(node.right, list);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
       getMin(root);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void getMin(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        getMin(treeNode.left);
        if (pre != null) {
            if (Math.abs(pre.val - treeNode.val) < min) {
                min = Math.abs(pre.val - treeNode.val);
            }
        }
        pre = treeNode;
        getMin(treeNode.right);

    }

    public static void main(String[] args) {
        Integer[] arr = {236,104,701,null,227,null,911};
        TreeNode treeNode = new TreeNode(236);
        treeNode.left = new TreeNode(104);
        treeNode.right = new TreeNode(701);
        treeNode.left.right = new TreeNode(227);
        treeNode.right.right = new TreeNode(911);
        GetMinimumDifference getMinimumDifference = new GetMinimumDifference();
        System.out.println(getMinimumDifference.getMinimumDifference(treeNode));
    }
}
