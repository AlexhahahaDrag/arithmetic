package listNode;

/**
 * @Description: Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * @Author:     alex
 * @CreateDate: 2019/7/19 16:31
 * @Version:    1.0
 *
 */
public class RotateList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.getListNodeByArr(arr);
        RotateList rotateList = new RotateList();
        rotateList.rotateRight(listNode, 1);
        System.out.println(1);
    }
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode l = head;
        while(l != null) {
            l = l.next;
            size++;
        }
        k %= size;
        ListNode l1 = head;
        int x = size - k;
        while(x > 0){
            l1 = l1.next;
            x--;
        }

        ListNode l2 = l1;
        while(k-- > 1)
            l2 = l2.next;
        ListNode l3 = head;
        l2.next = l3;
        while(size - k > 0)
            l3 = l3.next;
        l3.next = null;

        return l1;
    }
}
