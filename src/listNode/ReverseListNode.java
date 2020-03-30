package listNode;

/**
 * @Description:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @Author:     alex
 * @CreateDate: 2019/11/26 14:20
 * @Version:    1.0
 *
*/
public class ReverseListNode {

    public ListNode reverseList1(ListNode head) {
        ListNode re = new ListNode(-1);
        ListNode pre = re;
        while(head != null) {
            ListNode nextCur = head.next;
            head.next = pre.next;
            pre.next = head;
            head = nextCur;
        }
        return re.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.getListNodeByArr(arr);
        ReverseListNode reverseListNode = new ReverseListNode();
        listNode = reverseListNode.reverseList(listNode);
        ListNode.print(listNode);
    }
}
