package listNode;

/**
 * @description:
 * @author: alex
 * @create: 2019-09-21 08:37:04
 * @version: 1.0
 **/
public class DeleteRepeatNodeLeftOne {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 5};
        ListNode listNode = ListNode.getListNodeByArr(arr);
        DeleteRepeatNodeLeftOne deleteRepeatNodeLeftOne = new DeleteRepeatNodeLeftOne();
        listNode = deleteRepeatNodeLeftOne.deleteRepeatNodeLeftNone(listNode);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        ListNode listNode2 = ListNode.getListNodeByArr(arr);
        listNode2 = deleteRepeatNodeLeftOne.deleteRepeatNodeLeftOne(listNode2);
        while(listNode2 != null) {
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }

    private ListNode deleteRepeatNodeLeftNone(ListNode listNode) {
        if (listNode == null)
            return null;
        ListNode pre = listNode;
        ListNode cur = listNode.next;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                pre.next = cur.next.next;
            } else {
                pre = cur;
            }
            cur = cur.next;

        }
        return listNode;
    }

    private ListNode deleteRepeatNodeLeftOne(ListNode listNode) {
        if (listNode == null)
            return null;
        ListNode cur = listNode.next;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        return listNode;
    }
}
