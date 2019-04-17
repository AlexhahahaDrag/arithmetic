import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * @Author:      alex
 * @CreateDate:  2019/2/15 11:44
 * @param
 * @return
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(containsDuplicate2(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set set=new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int len=set.size();
            set.add(nums[i]);
            if (len==set.size())
                return true;
        }
        return false;
    }
    public static boolean containsDuplicate1(int[] nums) {
        Set set=new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++)
            if (nums[i]==nums[i+1])
                return true;
        return false;
    }
}
