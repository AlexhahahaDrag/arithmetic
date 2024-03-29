package array;

/**
 * Description:
 * 496. 下一个更大元素 I
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 * 提示：
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * Author:      alex
 * CreateDate:  2020/6/11 12:58
 * Version:     1.0
 *
 */
public class NextGreaterElement {

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = findMore(nums2, findNum(nums2, nums1[i]), nums1[i]);
        }
        return nums1;
    }

    private int findNum(int[] num, int nu) {
        for(int i = 0; i < num.length; i++) {
            if(num[i] == nu) {
                return i;
            }
        }
        return -1;
    }

    private int findMore(int[] num, int start, int nu) {
        for(int i = start + 1; i < num.length; i++) {
            if(num[i] > nu) {
                return num[i];
            }
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int tt = 0;
        int[] hash = new int[1001];
        int[] map = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            while(tt != 0 && nums2[i] >= map[tt]) {
                tt--;
            }
            hash[nums2[i]] = tt == 0 ? -1 : map[tt];
            map[++tt] = nums2[i];
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hash[nums1[i]];
        }
        return nums1;
    }

    public int[] nextGreaterElement4(int[] nums1, int[] nums2) {
        int index;
        for(int i = 0 ; i< nums1.length; i++) {
            index = -1;
            for(int j = nums2.length - 1; j >= 0; j--) {
                if(nums2[j] == nums1[i]) {
                    nums1[i] = index;
                    break;
                } else if (nums1[i] < nums2[j]) {
                    index = nums2[j];
                }
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] res = nextGreaterElement.nextGreaterElement(nums1, nums2);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
