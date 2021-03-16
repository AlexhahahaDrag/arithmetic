package array;

/**
 * @Description: Given an array of integers A and let n to be its length.
 *
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 *
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 *
 * Note:
 * n is guaranteed to be less than 105.
 *
 * Example:
 *
 * A = [4, 3, 2, 6]
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 *
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * @Author:     alex
 * @CreateDate: 2019/7/29 13:58
 * @Version:    1.0
 *
 *
 * [-2147483648,-2147483648]
*/
public class RotateFunction {
    public static void main(String[] args) {
        RotateFunction rotateFunction = new RotateFunction();
        int[] arr = {4, 3, 2, 6};
        System.out.println(rotateFunction.maxRotateFunction(arr));
    }
    public int maxRotateFunction(int[] A) {
        //f(n) = 0 * b(0) + 1* b(1) + ... + (n-1) * b(n-1);
        //f(n + 1) = 0 * b(n -1) + 1 * b(0) + ... + (n - 1) * b(n - 2);
        //f(n + 1) - f(n) = b(0) + b(1) + ... + b(n - 2) - (n - 1) b(n - 1);
        //f(n + 1)  = sum(b) - n * b(n-1) + f(n);
        if (A == null || A.length == 0) {
            return 0;
        }
        long pre = 0;
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            pre += i * A[i];
            sum += A[i];
        }
        long max = pre;
        long cur;
        for (int i = A.length - 1; i > 0; i--) {
            cur = sum + pre - A.length * A[i];
            max = max >= cur ? max : cur;
            pre = cur;
        }
        if (max > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (max < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)max;
    }
}
