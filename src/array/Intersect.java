package array;

import java.util.Arrays;

/**
 *description:
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *author:       alex
 *createDate:  2020/3/14 22:11
 *version:      1.0.0      
*/
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int size = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        while(i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] > nums2[i2])
                i2++;
            else if (nums1[i1] < nums2[i2])
                i1++;
            else {
                res[size++] = nums1[i1];
                i1++;
                i2++;
            }
        }
        return Arrays.copyOfRange(res, 0, size);
    }

    /*public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int[] res = new int[nums2.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums1) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int[] map = new int[max - min + 1];
        for (int j : nums1)
            map[j - min]++;
        int size = 0;
        for (int k : nums2) {
            if (k >= min && k <= max && map[k - min] > 0) {
                map[k - min]--;
                res[size++] = k;
            }
        }
        return Arrays.copyOfRange(res, 0, size);
    }*/

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Intersect intersect = new Intersect();
        int[] res = intersect.intersect(nums1, nums2);
        for(int i : res)
            System.out.print(i + "    ");;
    }
}
