package listNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以不用额外空间解决此题？
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 * @author:      alex
 * @createTime:  2020/10/10 17:22
 * @version:     1.0
 */
public class DetectCycle {

    public ListNode detectCycle1(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        while(head != null) {
            if(map.containsKey(head))
                return head;
            map.put(head, index++);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if(head==null)
            return null;
        while (head.next != null){
            if(head.next.val == -1999999)
                return head.next;
            else {
                head.val = -1999999;
                head=head.next;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true) {
            if(fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            //获取快慢指针的差值
            if (fast == slow)
                break;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
