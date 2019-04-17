/**
 * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 *
 * Example 1:
 *
 * Input: [2,1,2]
 * Output: 5
 * Example 2:
 *
 * Input: [1,2,1]
 * Output: 0
 * Example 3:
 *
 * Input: [3,2,3,4]
 * Output: 10
 * Example 4:
 *
 * Input: [3,6,2,3]
 * Output: 8
 *
 *
 * Note:
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */
import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] A={3,6,2,3,5};
        System.out.println(largestPerimeter(A));
    }
    public static int largestPerimeter(int[] A){
        Arrays.sort(A);
        int a,b,c;
        for (int i = 0; i < A.length-2; i++) {
            a=A[A.length-1-i];
            b=A[A.length-2-i];
            c=A[A.length-3-i];
            if (b+c>a)
                return a+b+c>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)(a+b+c);
        }
        return 0;
    }
}
