/**
 * @Description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @Author:      alex
 * @CreateDate:  2019/4/3 13:54
 * @param
 * @return
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode resullts=addTwoNumbers(l1,l2);
        while(resullts!=null){
            System.out.print(resullts.val+"-->");
            resullts=resullts.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digit=0;
        ListNode results=new ListNode(0);
        ListNode curr=results;
        while(l1!=null||l2!=null||digit>0){
            int l1Num=0;
            int l2Num=0;
            if (l1!=null){
                l1Num=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                l2Num=l2.val;
                l2=l2.next;
            }
            int num=l1Num+l2Num+digit;
            digit=num/10;
            curr.next=new ListNode(num%10);
            curr=curr.next;
        }
        return results.next;
}
}
