package listNode;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 *面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *author:       alex
 *createDate:  2020/2/18 20:04
 *version:      1.0.0      
*/
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null)
            return head;
        boolean[] map = new boolean[20001];
        map[head.val] = true;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            while(cur != null && map[cur.val])
                cur = cur.next;
            pre.next = cur;
            if (cur != null) {
                pre = cur;
                map[cur.val] = true;
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if(head == null)
            return head;
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            while (list.contains(cur.val))
                cur = cur.next;
             pre.next = cur;
             if (cur != null) {
                 pre = cur;
                 list.add(cur.val);
                 cur = cur.next;
             }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2};
        ListNode listNode = ListNode.getListNodeByArr(arr);
        RemoveDuplicateNodes removeDuplicateNodes = new RemoveDuplicateNodes();
        removeDuplicateNodes.removeDuplicateNodes(listNode);
        ListNode.print(listNode);
    }
}
