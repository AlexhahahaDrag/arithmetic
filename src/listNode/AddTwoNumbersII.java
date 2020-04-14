package listNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * Author:      alex
 * CreateDate:  2020/4/14 18:56
 * Version:     1.0
 *
*/
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        int len1 = list1.size() - 1;
        int len2 = list2.size() - 1;
        int sum ;
        int digit = 0;
        List<Integer> res = new ArrayList<>();
        while(len1 >= 0 || len2 >= 0 || digit != 0) {
            sum = (len1 >= 0 ? list1.get(len1) : 0) + (len2 >= 0 ? list2.get(len2) : 0) + digit;
            digit = sum / 10;
            res.add(sum % 10);
            len1--;
            len2--;
        }
        ListNode lis = new ListNode(-1);
        ListNode cur = lis;
        int start = 0;
        while(start < res.size()) {
            cur.next = new ListNode(res.get(start));
            start++;
            cur = cur.next;
        }
        return lis.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.getListNodeByArr(new int[] {7, 2, 4, 3});
        ListNode listNode2 = ListNode.getListNodeByArr(new int[] {5, 6, 4});
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        ListNode.print(addTwoNumbersII.addTwoNumbers(listNode1, listNode2));
    }
}
