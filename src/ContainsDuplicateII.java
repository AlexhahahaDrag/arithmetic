/**
 * @Description: Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * @Author:      alex
 * @CreateDate:  2019/2/15 16:16
 * @param
 * @return
*/
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        System.out.println(containsNearbyDuplicate(nums,3));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int start=0;
        while(start<nums.length){
            int index=start+1;
            while (index<nums.length&&nums[start]!=nums[index]) {
                index++;
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    if (j-i<=k) {
                        return true;
                    } else {
                        break;
                    }
                }

            }
        }
        return false;
    }
}
