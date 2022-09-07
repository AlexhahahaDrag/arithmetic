package array;

import java.util.HashMap;
import java.util.Map;

public class LongestNiceSubarray {

    public int longestNiceSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 1; j < nums.length; j++) {
                if((nums[i] & nums[j]) == 0) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                }
            }
        }
        int res = 1;
        for(Integer i : map.values()) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,8,48,10};
        LongestNiceSubarray longestNiceSubarray = new LongestNiceSubarray();
        System.out.println(longestNiceSubarray.longestNiceSubarray(nums));
    }
}
