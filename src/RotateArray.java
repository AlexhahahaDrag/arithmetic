/**
 * @Description: Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * @Author:      alex
 * @CreateDate:  2019/2/14 15:12
 * @param
 * @return
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        rotate2(nums,3);
    }
    public static void rotate(int[] nums, int k) {
        while (k-->0){
            int a=nums[nums.length-1];
            for (int i = nums.length-2; i >=0 ; i--)
                nums[i+1]=nums[i];
            nums[0]=a;
        }
    }
    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    public static void rotate2(int[] nums, int k) {
       k%=nums.length;
       int count=0;
       int i=0;
        while(count < nums.length) {
            int current=i;
            int prev=nums[current];
            do {
                int next=(current+k)%nums.length;
                int temp=prev;
                prev=nums[next];
                nums[next]=temp;
                current=next;
                count++;
            }while (current!=i);
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }
}
