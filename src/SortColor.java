/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColor {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
        for (int i:
             nums) {
            System.out.print(i+" ");
        }
    }
    public static void sortColors(int[] nums){
        int[] numsNew=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsNew[i]=nums[i];
            nums[i]=1;
        }
        int start=0;
        int end=nums.length-1;
        for (int i = 0; i < numsNew.length; i++) {
            if (numsNew[i]==0)
                nums[start++]=0;
            else if (numsNew[i]==2)
                nums[end--]=2;
        }
    }
}
