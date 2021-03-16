import java.util.Arrays;
/**
 * @Description: Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * @Author:      alex
 * @CreateDate:  2019/5/7 17:43
 * @param
 * @return
*/
public class MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
        int[] nums={203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143};
        System.out.println(minMoves2(nums));
    }
    public static int minMoves2(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        for(int x:nums) {
            if(min>x) {
                min = x;
            } else if(max<x) {
                max = x;
            }
        }
        long minMoves=Integer.MAX_VALUE;
        out: for(int i=min;i<=max;i++){
            long moves=0;
            for(int y:nums){
                moves+=Math.abs(y-i);
                if(moves<0||moves>=minMoves) {
                    continue out;
                }
            }
            minMoves=Math.min(minMoves,moves);
        }
        return minMoves>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)minMoves;
    }
    public static int minMoves21(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }
}
