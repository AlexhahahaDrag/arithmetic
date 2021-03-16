package listNode;

/**
 * @description:
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @author:      alex
 * @createTime:  2020/10/20 20:36 
 * @version:     1.0
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode next = slow;
        slow.next = null;
        ListNode pre = null;
        while(next != null) {
            ListNode cur = next;
            next = next.next;
            cur.next = pre;
            pre = cur;
        }

        ListNode list = new ListNode(-1);
        if (fast != null) {
            System.out.println(11);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.getListNodeByArr(arr);
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(listNode);
        ListNode.print(listNode);
    }
}
