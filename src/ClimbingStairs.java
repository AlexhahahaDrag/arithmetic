/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs1(3));
    }
    public static int climbStairs(int n){
        switch (n){
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return climbStairs(n-1)+climbStairs(n-2);
        }
    }
    public static int climbStairs1(int n){
        if (n==1) {
            return 1;
        }
        int start=1;
        int second=2;
        while(n>2){
            int sum=start+second;
            start=second;
            second=sum;
            n--;
        }
        return second;
    }

    public int climbStairs3(int n) {
        if(n == 1) {
            return 1;
        }
        long a = 1;
        long b = 2;
        long c;
        while(--n > 0) {
            c = a + b;
            a = b;
            b = c;
        }
        return (int)a;
    }
}
