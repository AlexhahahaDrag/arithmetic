import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * @Author:      alex
 * @CreateDate:  2019/4/2 15:54
 * @param
 * @return
*/
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(1);
        listNode.next.next.next=new ListNode(1);
        listNode.next.next.next.next=new ListNode(2);
        listNode.next.next.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(listNode));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        boolean flag=false;
        while(fast!=null){
            if (fast.next==null){
                flag=true;
                break;
            }else
                fast=fast.next.next;
            ListNode nextNode=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nextNode;
        }
        slow=flag?slow.next:slow;
        while(prev!=null){
            if(prev.val!=slow.val)
                return false;
            slow=slow.next;
            prev=prev.next;
        }
        return true;
    }
    //空间大
    public boolean isPalindrome1(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode current=head;
        while(current!=null){
            list.add(current.val);
            current=current.next;
        }
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i).intValue()!=list.get(list.size()-1-i).intValue())
                return false;
        }
        return true;
    }
}
