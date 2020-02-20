package listNode;

/**
 *description:
 * 面试题 02.04. 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的 节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之前(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *author:       alex
 *createDate:  2020/2/20 8:44
 *version:      1.0.0      
*/
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1);
        ListNode start = res;
        ListNode endRes = new ListNode(-1);
        ListNode end = endRes;
        while(head != null) {
            if (head.val < x) {
                start.next = head;
                start = start.next;
            } else {
                end.next = head;
                end = end.next;
            }
            head = head.next;
        }
        start.next = endRes.next;
        end.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNodeByArr(new int[]{1,4,3,2,5,2});
        Partition partition = new Partition();
        ListNode res = partition.partition(listNode, 3);
        ListNode.print(res);
    }
}
