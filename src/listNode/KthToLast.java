package listNode;

/**
 *description:
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *author:       alex
 *createDate:  2020/2/18 20:41
 *version:      1.0.0      
*/
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        int index = 0;
        ListNode cur = head;
        while(index++ < k && cur != null)
            cur = cur.next;
        if(index != k + 1)
            return -1;
        ListNode kln = head;
        while(cur != null) {
            kln = kln.next;
            cur = cur.next;
        }
        return kln.val;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.getListNodeByArr(arr);
        KthToLast kthToLast = new KthToLast();
        System.out.println(kthToLast.kthToLast(listNode, 2));
    }
}
