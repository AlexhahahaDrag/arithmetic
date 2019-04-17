import java.util.HashMap;

/**
 * @Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @Author:      alex
 * @CreateDate:  2019/3/22 10:09
 * @param
 * @return
*/
public class TwoSum {
    public static void main(String[] args) {
        System.out.println();
    }
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; ++i){
            int b = target - nums[i];
            if (map.containsKey(b) && i != map.get(b))
                return new int[]{i, map.get(b)};
        }
        return answer;
    }
}
