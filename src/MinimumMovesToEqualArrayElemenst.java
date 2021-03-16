/**
 * @Description: Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * Accepted
 * 56,450
 * Submissions
 * 114,963
 * @Author:      alex
 * @CreateDate:  2019/5/7 18:05
 * @param
 * @return
 */
public class MinimumMovesToEqualArrayElemenst {
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(minMoves(nums));
    }
    public static int minMoves(int[] nums) {
        int minMoves=0;
        int min=nums[0];
        for(int x:nums) {
            if(min>x) {
                min = x;
            }
        }
        for (int y:
             nums) {
            minMoves+=y-min;
        }
        return minMoves;
    }
}
