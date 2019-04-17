import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description:Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * * Input: nums1 =  * [4,7,9,7,6,7], nums2 = [5, 0, 0, 6, 1, 6, 2, 2, 4]
 *  * Output: [6,4]
 *
 * @Author:      alex
 * @CreateDate:  2019/2/26 11:45
 * @param
 * @return
*/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1={4,7,9,7,6,7};
        int[] nums2={5, 0, 0, 6, 1, 6, 2, 2, 4};
        int[] aaaa=intersection(nums1,nums2);
        for (int i:aaaa
             ) {
            System.out.println(i);
        }
    }
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums1)
            set.add(i);
        Set<Integer> setResult=new HashSet<>();
        int index=0;
        for(int j:nums2)
            if(set.contains(j))
                setResult.add(j);
        int[] results=new int[setResult.size()];
        Iterator<Integer> it=setResult.iterator();
        while(it.hasNext())
            results[index++]=it.next().intValue();
        return results;
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums1) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        boolean[] exist = new boolean[max - min + 1];
        for (int num : nums1)
            exist[num - min] = true;
        int[] res = new int[nums2.length];
        int idx = 0;
        for (int num : nums2) {
            if (num <= max && num >= min && exist[num - min]) {
                res[idx++] = num;
                exist[num - min] = false; //remove from exist array to avoid duplicate
            }
        }
        return Arrays.copyOf(res, idx);
    }
}
