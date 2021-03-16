package listNode;

/**
 * Description:
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * Author:      alex
 * CreateDate:  2020/6/10 12:30
 * Version:     1.0
 *
*/
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode nextS = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nextS;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1};
        ListNode head = ListNode.getListNodeByArr(arr);
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(head));
    }
}
