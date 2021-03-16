package array;

import java.util.Arrays;

/**
 * @Description: Students are asked to stand in non-decreasing order of heights for an annual photo.
 *
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 *
 *
 * Note:
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * @Author:      alex
 * @CreateDate:  2019/5/27 9:54
 * @param
 * @return
 */
public class HeightChecker {
    public static void main(String[] args) {
        HeightChecker heightChecker=new HeightChecker();
        int[] heigths={1,2,1,2,1,1,1,2,1};
        System.out.println(heightChecker.heightChecker(heigths));
    }
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int count = 0;
        for(int i = 0; i < copy.length; i++){
            if(heights[i]!=copy[i]) {
                count++;
            }
        }
        return count;
    }
}
