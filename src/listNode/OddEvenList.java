package listNode;

/**
 * @description:
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * @author:      alex
 * @createTime:  2020/11/13 9:16
 * @version:     1.0
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode even = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = even;
        while(cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            pre = pre.next;
            cur.next = temp;
            if (temp != null) {
                cur = temp;
            }
        }
        cur.next = even.next;
        return head;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4};
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.getListNodeByArr(arr);
        OddEvenList oddEvenList = new OddEvenList();
        ListNode res = oddEvenList.oddEvenList(head);
        ListNode.print(res);
    }
}
