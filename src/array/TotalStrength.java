package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class TotalStrength {

    public int totalStrength1(int[] strength) {
        int len = strength.length;
        int[] sum = new int[len + 1];
        for(int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + strength[i];
        }
        int[] min = new int[len];
        Arrays.fill(min, Integer.MAX_VALUE);
        int mod = 1000000007;
        long res = 0;
        for(int j = 0; j < len; j++) {
            for(int k = 0; k <= j; k++) {
                min[k] = Math.min(min[k], strength[j]);
                res = (res + (long)(sum[j + 1] - sum[k]) * min[k] % mod ) % mod;
            }
        }
        return (int)res;
    }

    public int totalStrength2(int[] strength) {
        final int mod = (int) 1e9 + 7;
        int n = strength.length;
        int[] left = new int[n];  // left[i] 为左侧严格小于 strength[i] 的最近元素位置（不存在时为 -1）
        int[] right = new int[n]; // right[i] 为右侧小于等于 strength[i] 的最近元素位置（不存在时为 n）
        Arrays.fill(right, n);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && strength[st.peek()] >= strength[i]) right[st.pop()] = i;
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long s = 0L; // 前缀和
        int[] ss = new int[n + 2]; // 前缀和的前缀和
        for (int i = 1; i <= n; ++i) {
            s += strength[i - 1];
            ss[i + 1] = (int) ((ss[i] + s) % mod);
        }

        long ans = 0L;
        for (int i = 0; i < n; ++i) {
            int l = left[i] + 1, r = right[i] - 1; // [l,r] 左闭右闭
            long tot = ((long) (i - l + 1) * (ss[r + 2] - ss[i + 1]) - (long) (r - i + 1) * (ss[i + 1] - ss[l])) % mod;
            ans = (ans + strength[i] * tot) % mod; // 累加贡献
        }
        return (int) (ans + mod) % mod; // 防止算出负数（因为上面算 tot 有个减法）
    }


    public int totalStrength(int[] strength) {
        int len = strength.length;
        int mod = (int)1e9 + 7;
        //前缀和
        int[] sum = new int[len + 1];
        for(int i = 0; i < len; i++) {
            sum[i + 1] = (sum[i] + strength[i]) % mod;
        }
        int[] sums = new int[len + 2];
        //前缀和的和
        for (int j = 1; j <= len + 1; j++) {
            sums[j] += (sums[j - 1] + sum[j - 1]) % mod;
        }
        //左面的最近一个小于元素
        int[] left = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        //右面最近一个小于等于的元素
        int[] right = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }


        long res = 0;
        for (int i = 0; i < len; i++) {
            int l = left[i] + 1;
            int r = right[i] - 1;
            long tot = ((long)(sums[r + 2] - sums[i + 1]) * (i - l + 1) - (long)(sums[i + 1] - sums[l]) * (r - i + 1)) % mod;
            res = (res + tot * strength[i]) % mod;
        }
        return (int)(res + mod) % mod;
    }


    public static void main(String[] args) {
//        int[] strength = {1, 3, 1, 2};//44
        int[] strength = {45435,5345345,435345345,655654,57657,435,435,435345,34,543,5,7876,345,435435};
        TotalStrength totalStrength = new TotalStrength();
        System.out.println(totalStrength.totalStrength(strength));
        System.out.println(totalStrength.totalStrength1(strength));
        System.out.println(totalStrength.totalStrength2(strength));
    }
}
