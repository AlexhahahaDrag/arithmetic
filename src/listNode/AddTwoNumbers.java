package listNode;

/**
 *description:
 * 面试题 02.05. 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *author:       alex
 *createDate:  2020/2/20 21:32
 *version:      1.0.0      
*/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digit = 0;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int num1;
        int num2;
        while(l1 != null || l2 != null || digit != 0) {
            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            } else
                num1 = 0;
            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            } else
                num2 = 0;
            int sum = num1 + num2 + digit;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            digit = sum / 10;
        }
        return res.next;
    }
}
