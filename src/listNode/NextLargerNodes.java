package listNode;

/**
 * Description:
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 * Author:      alex
 * CreateDate:  2019/12/17 11:46
 * Version:     1.0
 *
*/
public class NextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[] {};
        }
        int[] fi = new int[10001];
        ListNode find = head;
        int count = 1;
        int size = 0;
        int pre = find.val;
        find = find.next;
        while (find != null) {
            if (find.val > pre) {
                fi[size++] = find.val;
            }
            pre = find.val;
            find = find.next;
            count++;
        }

        int index = 0;
        int[] result = new int[count];
        int start = 0;
        while(head != null) {
            if(head.val < fi[index]) {
                result[start++] = fi[index];
            } else if (head.val > fi[index]) {
                result[start++] = 0;
            } else if (head.val == fi[index]) {
                if (head.val > fi[index + 1]) {
                    result[start++] = 0;
                } else {
                    result[start++] = fi[index + 1];
                }
                index++;
            }
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        NextLargerNodes nextLargerNodes = new NextLargerNodes();
        int[] nums = {5, 2, 5};
        ListNode listNode = ListNode.getListNodeByArr(nums);
        int[] result = nextLargerNodes.nextLargerNodes(listNode);
        for (int i : result) {
            System.out.print(i + "  ");
        }
    }
}
