package listNode;

/**
 * @Description: Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 * @Author:     alex
 * @CreateDate: 2019/7/25 15:58
 * @Version:    1.0
 *
*/
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        boolean change = true;
        change = !change;
        System.out.println(change);
        System.out.println(false ^ false);
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.getListNodeByArr(arr);
        removeNthNodeFromEndOfList.removeNthFromEnd(listNode, 2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int a = n;
        ListNode cur = head;
        while(a-- > 0) {
            if(cur == null)
                return head;
            cur = cur.next;
        }
        if (cur == null)
            return head.next;
        ListNode li = head;
        while(cur.next != null) {
            cur = cur.next;
            li = li.next;
        }
        li.next = li.next.next;
        return head;
    }
}
