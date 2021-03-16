package tree.fieldTree;

/**
 * @description:
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 * @author:      alex
 * @createTime:  2020/8/5 18:52
 * @version:     1.0
 */
public class ReversePairs {

    int count = 0;
    //归并排序
    public int reversePairs1(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start >> 1);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p = 0;
        int p1 = start;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= end) {
            if (nums[p1] <= nums[p2]) {
                temp[p++] = nums[p1++];
            } else {
                count += mid - p1 + 1;
                temp[p++] = nums[p2++];
            }
        }
        while(p1 <= mid) {
            temp[p++] = nums[p1++];
        }
        while(p2 <= end) {
            temp[p++] = nums[p2++];
        }
        for (int i = 0; i < end - start + 1; i++) {
            nums[start + i] = temp[i];
        }
    }

    //字段树
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count1 = 1;
        int count2 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count1 != 1 && count2 != 1) {
                break;
            }
            if (nums[i - 1] > nums[i]) {
                count1++;
            } else {
                count2++;
            }
        }
        if (count1 == nums.length) {
            return (int)((double)nums.length * (nums.length - 1) / 2);
        }
        if (count1 == 1) {
            return 0;
        }
        FieldTree fieldTree = new FieldTree(nums[nums.length - 1]);
        fieldTree.dup = 1;
        int ret = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            ret += build(fieldTree, nums[i]);
        }
        return ret;
    }

    private int build(FieldTree fieldTree, int value) {
        int ret = 0;
        while(fieldTree.value != value) {
            if (fieldTree.value >= value) {
                fieldTree.count++;
                if (fieldTree.left == null) {
                    fieldTree.left = new FieldTree(value);
                }
                fieldTree = fieldTree.left;
            } else {
                ret += fieldTree.count + fieldTree.dup;
                if(fieldTree.right == null) {
                    fieldTree.right = new FieldTree(value);
                }
                fieldTree = fieldTree.right;
            }
        }
        ret += fieldTree.count;
        fieldTree.dup++;
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1 , 1, 1};
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(nums));
    }
}
