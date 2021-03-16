package listNode;

/**
 * @description:
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author:      alex
 * @createTime:  2020/11/20 11:15
 * @version:     1.0
 */
public class InsertionSortList {

    public ListNode insertionSortList1(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode cur = head;
        while(cur != null) {
            ListNode li = res;
            while (li.next != null && li.next.val < cur.val) {
                li = li.next;
            }
            ListNode ln = li.next;
            ListNode cn = cur.next;
            li.next = cur;
            cur.next = ln;
            cur = cn;
        }
        return res.next;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode prefix = insertionSortList(head);
        ListNode suffix = insertionSortList(slow);
        ListNode merge = merge(prefix, suffix);
        return merge;
    }

    private ListNode merge(ListNode prefix, ListNode suffix) {
        ListNode res = new ListNode(-1);
        ListNode re = res;
        while(prefix != null && suffix != null) {
            ListNode cur;
            if (prefix.val > suffix.val) {
                cur = suffix;
                suffix = suffix.next;
            } else {
                cur = prefix;
                prefix = prefix.next;
            }
            re.next = cur;
            re = re.next;
        }
        if (prefix != null) {
            re.next = prefix;
        }
        if (suffix != null) {
            re.next = suffix;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 4, 3, 0, 1};
        ListNode head = ListNode.getListNodeByArr(arr);
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode res = insertionSortList.insertionSortList(head);
        ListNode.print(res);
    }
}
