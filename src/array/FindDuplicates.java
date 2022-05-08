package array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]){
                i++;
            } else {
                int j = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = j;
            }
        }
        for(int j = 0; j < nums.length; j++) {
            if(j + 1 != nums[j]) {
                res.add(nums[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDuplicates findDuplicates = new FindDuplicates();
        System.out.println(findDuplicates.findDuplicates(nums));
    }
}
