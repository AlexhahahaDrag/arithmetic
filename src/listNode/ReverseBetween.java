package listNode;

/**
 * @description:
 * 92. 反转链表 II
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * @author:      alex
 * @createTime:  2021/3/18 12:27
 * @version:     1.0
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        while(index < left) {
            pre.next = head;
            pre = pre.next;
            head = head.next;
            index++;
        }
        pre.next = null;
        while(index <= right) {
            ListNode cur = pre.next;
            pre.next = head;
            head = head.next;
            pre.next.next = cur;
            index++;
        }
        while(pre != null && pre.next != null) {
            pre = pre.next;
        }
        while(head != null) {
            pre.next = head;
            pre = pre.next;
            head = head.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.getListNodeByArr(arr);
        int left = 1;
        int right = 5;
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode.print(reverseBetween.reverseBetween(head, left, right));
    }
}
