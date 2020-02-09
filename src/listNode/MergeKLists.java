package listNode;

/**
 *description:
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/7 18:59
 *version:      1.0.0
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return new ListNode(-1).next;
        int len = lists.length;
        while(len > 1) {
            for (int i = 0; i < (len >> 1); i++)
                lists[i] = mergeTwoList(lists[i], lists[len - 1 - i]);
            len = len + 1 >> 1;
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(-1);
        ListNode cur = list;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;
        return list.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.getListNodeByArr(new int[]{1, 4, 5});
        ListNode listNode2 = ListNode.getListNodeByArr(new int[]{1, 3, 4});
        ListNode listNode3 = ListNode.getListNodeByArr(new int[]{2, 6});
        ListNode[] list = {};
        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(list);
        ListNode.print(listNode);
    }
}
