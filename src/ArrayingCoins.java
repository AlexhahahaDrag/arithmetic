import java.util.Map;

/**
 * @Description: You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 * @Author:      alex
 * @CreateDate:  2019/2/13 17:02
 * @param
 * @return
*/
public class ArrayingCoins {
    public static void main(String[] args) {
        System.out.println(60070*(60070+1)>>1);
        long x=60070;
        System.out.println(x*(x+1)>>1);
        System.out.println(arrangeCoins(1804289383));
    }
    public static int arrangeCoins(int n) {
        long x=n;
        long count= (long)Math.sqrt(2*x);
        while((count*(count+1)>>1)<=x){
            count++;
        }
        return (int)(count-1);
    }
    public static int arrangeCoins1(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return ((int)(-1 + Math.sqrt(1 + 8 * (long)n))>>1);
    }
}
