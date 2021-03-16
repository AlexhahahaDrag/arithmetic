/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums={9,6,4,2,3,5,7,1,0};
        System.out.println(missingNumber1(nums));
    }
    public static int missingNumber(int[] nums){
        int[] container=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            container[nums[i]]++;
        }
        for (int i = 0; i < container.length; i++) {
            if (container[i]==0) {
                return i;
            }
        }
        return -1;
    }
    public static int missingNumber1(int[] nums){
        int len=nums.length;
        int target=len*(len+1)/2;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return target-sum;
    }
}
