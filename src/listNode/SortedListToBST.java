package listNode;

import tree.binartTree.TreeNode;

/**
 * @description:
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author:      alex
 * @createTime:  2020/8/18 9:21
 * @version:     1.0
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
            treeNode.left = sortedListToBST(head);
        }
        treeNode.right = sortedListToBST(slow.next);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] arr = {};
        ListNode head = ListNode.getListNodeByArr(arr);
        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode treeNode = sortedListToBST.sortedListToBST(head);
        System.out.println(treeNode == null ? "" : treeNode.toString());
    }
}
