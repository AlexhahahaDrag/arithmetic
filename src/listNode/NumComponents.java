package listNode;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/10/12 6:45
 * @version: 1.0.0
 */
public class NumComponents {

    public int numComponents(ListNode head, int[] nums) {
        int[] map = new int[10001];
        for (int i : nums) {
            map[i] = 1;
        }
        int max = 0;
        boolean cut = true;
        while (head != null) {
            if (map[head.val] == 1) {
                if (cut) {
                    max++;
                }
                cut = false;
            } else {
                cut = true;
            }
            head = head.next;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3};
        int[] nums = {3, 4, 0, 2, 1};
        ListNode head = ListNode.getListNodeByArr(arr);
        NumComponents numComponents = new NumComponents();
        System.out.println(numComponents.numComponents(head, nums));
    }
}
