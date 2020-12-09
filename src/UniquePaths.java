/**
 * @Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 * @Author:      alex
 * @CreateDate:  2019/5/13 17:40
 * @param
 * @return
*/
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
    public static int uniquePaths(int m, int n) {
        if(m==1&&n==1)
            return 1;
        else if((m==1&&n==2)||(m==2&&n==1))
            return 1;
        else if(n==1)
            return uniquePaths(m-1,n);
        else if(m==1)
            return uniquePaths(m,n-1);
        else
            return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
    public static int uniquePaths2(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++)
            map[i][0] = 1;
        for(int j= 1;j<n;j++)
            map[0][j]=1;
        for(int i = 1;i<m;i++)
            for(int j = 1;j<n;j++)
                map[i][j] = map[i-1][j]+map[i][j-1];
        return map[m-1][n-1];
    }

    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        while(m-- > 0)
            for(int i = 1; i < n; i++)
                dp[i] +=  dp[i - 1];
        return dp[n - 1];
    }
}
