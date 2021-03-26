package listNode;

/**
 * @description:
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * @author:      alex
 * @createTime:  2021/3/26 12:30
 * @version:     1.0
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        ListNode head = ListNode.getListNodeByArr(arr);
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode.print(deleteDuplicates.deleteDuplicates(head));
    }
}
