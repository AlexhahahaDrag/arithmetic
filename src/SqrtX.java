/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(getSqrtX(2147395599));
    }
    public static int getSqrtX(int x){
        long z=x;
        while (z*z>x){
            z=(z+x/z)>>1;
        }
        return (int)z;
    }
}
