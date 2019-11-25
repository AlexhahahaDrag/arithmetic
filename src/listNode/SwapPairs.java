package listNode;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/11/25 17:42
 * @Version:    1.0
 *
*/
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode sw = new ListNode(-1);
        sw.next = head;
        swap(sw);
        return sw.next;
    }

    private void swap(ListNode cur) {
        while(cur.next != null && cur.next.next != null) {
            ListNode t = cur.next.next;
            cur.next.next = t.next;
            t.next = cur.next;
            cur.next = t;
            cur = t.next;
        }
    }
}
