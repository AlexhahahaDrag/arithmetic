package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 229. Majority Element II
 * Medium
 *
 * 864
 *
 * 104
 *
 * Favorite
 *
 * Share
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * @Author:     alex
 * @CreateDate: 2019/6/21 16:34
 * @Version:    1.0
 *
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {0,3,4,0};
        MajorityElementII majorityElementII = new MajorityElementII();
        System.out.println(majorityElementII.majorityElement(arr));
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int firstNum =  0;
        int secondeNum = 1;
        int firstCount = 0;
        int secondCount = 0;
        for (int num : nums) {
            if (firstNum == num)
                firstCount++;
            else if (secondeNum == num)
                secondCount++;
            else if (firstCount == 0) {
                firstNum = num;
                firstCount++;
            } else if (secondCount == 0) {
                secondeNum = num;
                secondCount++;
            } else {
                firstCount--;
                secondCount--;
            }
        }
        firstCount = 0;
        secondCount = 0;
        for (int num1 : nums) {
            if (firstNum == num1)
                firstCount++;
            if (secondeNum == num1)
                secondCount++;
        }
        if (firstCount > nums.length/3)
            list.add(firstNum);
        if (secondCount > nums.length/3)
            list.add(secondeNum);
        return list;
    }
}
