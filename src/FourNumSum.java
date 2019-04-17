import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourNumSum {
    public static void main(String[] args) {
        int[] arr={-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum(arr,0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            int sum=0;
            sum+=nums[i];
            for (int j = i+1; j < nums.length-2; j++) {
                sum+=nums[j];
                for (int k = j+1; k < nums.length-1; k++) {
                    sum+=nums[k];
                    for (int l = k+1; l < nums.length; l++) {
                        sum+=nums[l];
                        if (sum>target){
                            sum-=nums[l];
                            break;
                        }
                        if (sum==target){
                            List<Integer> list=new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            if (!lists.contains(list)){
                                lists.add(list);
                            }
                        }
                        sum-=nums[l];
                    }
                    sum-=nums[k];
                }
                sum-=nums[j];
            }
            sum-=nums[i];
        }
        return lists;
    }
}
