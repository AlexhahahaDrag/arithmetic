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
        rotateList.rotateRight1(listNode, 2);
        System.out.println(1);
    }
    public ListNode rotateRight1(ListNode head, int k) {
        int size = 0;
        ListNode l = head;
        while(l != null) {
            l = l.next;
            size++;
        }
        k %= size;
        ListNode end = head;
        int x = size - k;
        while(x > 1){
            end = end.next;
            x--;
        }
        ListNode result = end.next;
        ListNode start = result;
        while(k-- > 1)
            result = result.next;
        result.next = head;
        end.next = null;
        return start;
    }
    public ListNode findendposition(ListNode l,int n) {
        int i;
        for(i=0;i<n-1;i++)
            l=l.next;
        return l;
    }

    public int findlength(ListNode l) {
        int count=0;
        while(l.next!=null)
        {
            l=l.next;
            count++;
        }
        return ++count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return head;
        RotateList s=new RotateList();
        ListNode start;
        start=head;
        int len;
        len=s.findlength(start);

        k=k%len;
        if(k==0)
        {
            return head;
        }

        ListNode result;
        ListNode end;

        start=head;
        end=s.findendposition(start,len-k);
        result=end.next;
        start=result;

        while(result.next!=null)
        {
            result=result.next;
        }

        result.next=head;
        end.next=null;

        return start;

    }
}
