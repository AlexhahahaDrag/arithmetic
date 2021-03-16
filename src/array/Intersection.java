package array;

/**
 * @Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @Author:     alex
 * @CreateDate: 2019/12/6 11:03
 * @Version:    1.0
 *
*/
public class Intersection {

    int min;
    int max;

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        min = nums1[0];
        max = nums1[0];
        findMinAndMax(nums1);
        findMinAndMax(nums2);
        int[] map1 = new int[max - min + 1];
        for(int i : nums1) {
            map1[i - min]++;
        }
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        int size = 0;
        for(int i : nums2) {
            if (map1[i -min] != 0) {
                result[size++] = i;
                map1[i -min] = 0;
            }
        }
        int[] fi = new int[size];
        for(int i = 0; i < size; i++) {
            fi[i] = result[i];
        }
        return fi;
    }
    private void findMinAndMax(int[] nums) {
        for(int i : nums){
            if (min > i) {
                min = i;
            }
            if(max < i) {
                max =i;
            }
        }
    }

    public static void main(String[] args) {
        Intersection interSection = new Intersection();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] arr = interSection.intersection(nums1, nums2);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
