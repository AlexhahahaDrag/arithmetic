/**
 * @Description: Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @Author:      alex
 * @CreateDate:  2019/4/2 15:41
 * @param
 * @return
*/
public class ReverseLinkedList {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode nextNode=current.next;
            current.next=prev;
            prev=current;
            current =nextNode;
        }
        return prev;
    }
}
