package array;

import java.util.*;

public class MinOperations {

    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int len = nums.length;
        long[] sum = new long[len + 1];
        for(int i = 0; i < nums.length; i++) {
            sum[i + 1] += sum[i] + nums[i];
        }
        long cur;
        List<Long> res = new ArrayList<>();
        for(int j : queries) {
            int cc = binary(nums, j);
            cur = sum[len] - sum[cc] * 2 - (long)j * (len - cc * 2);
            res.add(cur);
        }
        return res;
    }

    private int binary(int[] nums, int i) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end) {
            mid = start + (end - start >> 1);
            if (nums[mid] > i) {
                end = mid;
            } else if (nums[mid] < i) {
                start = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,6,8};
        int[] queries = {1, 5};
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(nums, queries));
    }
}
