package listNode;

/**
 *description:
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *author:       alex
 *createDate:  2020/3/27 21:00
 *version:      1.0.0      
*/
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        ListNode te = head;
        int len = 0;
        while(te != null) {
            te = te.next;
            len++;
        }
        k %= len;
        if (len < 2 || k == 0)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        while(len - k++ > 0) {
            pre = cur;
            cur = cur.next;
        }
        ListNode res = cur;
        pre.next = null;
        while(cur.next != null)
            cur = cur.next;
        cur.next = head;
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNodeByArr(new int[] {1});
        RotateRight rotateRight = new RotateRight();
        ListNode res = rotateRight.rotateRight(listNode, 2);
        ListNode.print(res);
    }
}
