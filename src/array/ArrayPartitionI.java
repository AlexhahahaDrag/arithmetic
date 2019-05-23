package array;

import java.util.Arrays;
/**
 * @Description: Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * @Author:      alex
 * @CreateDate:  2019/5/23 16:08
 * @param
 * @return
*/
public class ArrayPartitionI {
    public static void main(String[] args) {
        ArrayPartitionI arrayPartitionI=new ArrayPartitionI();
        int[] arr={1,4,3,2};
        System.out.println(arrayPartitionI.arrayPairSum1(arr));
    }
    public int arrayPairSum1(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2)
            sum+=nums[i];
        return sum;
    }
    public int arrayPairSum(int[] nums) {
        int[] buckets=new int[10000*2+1];
        for (int num:nums)
            buckets[num+10000]++;
        int is_odd=0;
        int sum=0;
        for (int i = 0; i < 20000; i++) {
            if (buckets[i]!=0){
                sum+=(i-10000)*((buckets[i]-is_odd)>>1);
                is_odd=(buckets[i]-is_odd)&1;
                if (is_odd==1)
                    sum+=i-10000;
            }
        }
        return sum;
    }
}
