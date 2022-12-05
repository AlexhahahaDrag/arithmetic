package listNode;

/**
 * @description:
 * 6247. 从链表中移除节点
 * 中等
 * 7
 * 相关企业
 * 给你一个链表的头节点 head 。
 *
 * 对于列表中的每个节点 node ，如果其右侧存在一个具有 严格更大 值的节点，则移除 node 。
 *
 * 返回修改后链表的头节点 head 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 *
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 *
 *
 * 提示：
 *
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 * @author: alex
 * @createDate: 2022/11/27 21:17
 * @version: 1.0.0
 */
public class RemoveNodes {

    public ListNode removeNodes(ListNode head) {
        ListNode pre = new ListNode(100001);
        ListNode cur;
        while(head != null) {
            cur = pre.next;
            while(head != null && head.next != null && head.val < head.next.val) {
                head = head.next;
            }
            pre.next = head;
            head = head.next;
            pre.next.next = cur;
        }
        ListNode res = new ListNode(-1);
        pre = pre.next;
        ListNode h;
        while(pre != null) {
            cur = res.next;
            res.next = pre;
            h = pre;
            do {
                pre = pre.next;
            } while(pre != null && h.val > pre.val);
            res.next.next = cur;
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,13,3,8};
        ListNode head = ListNode.getListNodeByArr(arr);
        RemoveNodes removeNodes = new RemoveNodes();
        System.out.println(removeNodes.removeNodes(head));
    }
}
