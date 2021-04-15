package listNode;

/**
 * @Description: ListNode 链表
 * @Author:     alex
 * @CreateDate: 2019/7/19 16:32
 * @Version:    1.0
 *
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int x, ListNode li) { val = x; next = li;}
    public static ListNode getListNodeByArr(int[] arr) {
        ListNode first = new ListNode(0);
        if (arr.length > 0){
            ListNode l = first;
            for (int i = 0; i < arr.length; i++) {
                l.next = new ListNode(arr[i]);
                l = l.next;
            }
        }
        return first.next;
    }

    public static void print(ListNode listNode) {
        while(listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
