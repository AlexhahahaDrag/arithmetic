package array;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/15 15:52
 * @Version:    1.0
 *
 */
public class PerfectShuffle {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        PerfectShuffle perfectShuffle = new PerfectShuffle();
        int[] result = perfectShuffle.getPerfectShuffle(arr);
        for(int i : result)
            System.out.print(i + " ");
    }

    private int[] getPerfectShuffle(int[] arr) {
        int n = arr.length / 2;
        int start = 0;
        while(n > 1) {
            int k = (int)Math.cbrt(arr.length + 1);
            int m = (int)Math.pow(3, k) >> 1;
            reverse(arr, m + 1, n);
            reverse(arr, n + 1, m + n);
            reverse(arr, m + 1, m + n);
            for (int i = 1; k > 0 ; k--, i *= 3)
                cycle(arr, i, 2 * m + 1);
            start = start + 2 * m;
            n = n - m;
        }
        if (n == 1) {
            int temp = arr[arr.length - 1];
            arr[arr.length - 1] = arr[arr.length - 2];
            arr[arr.length - 2] = temp;
        }

        return arr;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    private void cycle(int arr[], int start, int mod) {
        for (int i = (start << 1) % mod; i != start; i = (i << 1) % mod) {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
        }
    }

   /* public void CycleLeader(String[] A, int start, int mod) {
        for(int i = start * 2 % mod;i != start;i = i * 2 % mod) {
            String temp = A[i];
            A[i] = A[start];
            A[start] = temp;
        }
        return;
    }

    public void Reverse(String[] A, int start, int end) {
        while(start < end) {
            String temp = A[start];
            A[start++] = A[end];
            A[end--] = temp;
        }
        return;
    }

    public void RightRotate(String[] A, int start, int m, int n) {
        Reverse(A, start + m + 1, start + n);
        Reverse(A, start + n + 1, start + n + m);
        Reverse(A, start + m + 1, start + n + m);
        return;
    }

    public void PerfectShuffle(String[] A) {
        int len = A.length;
        int n = (len - 1) / 2;
        int start = 0;
        while(n > 1) {
            //第1步：找到2*m = 3^k - 1，使得3^k <= len - 1 < 3^(k + 1)
            int k = 0, m = 1;
            for(;(len - 1) / m >= 3;k++, m = m * 3);
            m = m / 2;

            //第2步：把数组中的A[m + 1,...,n + m]那部分循环右移m位
            RightRotate(A, start, m, n);

            //第3步：对于长度为2*m的数组，刚好有k个圈，每个圈的头部为3^i
            for(int i = 0, t = 1;i < k;i++, t = t * 3)
                CycleLeader(A, t, m * 2 + 1);

            //第4步：对数组后面部分A[2m + 1,...,2n]继续递归上面3步
            start = start + m * 2;
            n = n - m;

        }
        //n == 1时
        String temp = A[1 + start];
        A[1 + start] = A[2 + start];
        A[2 + start] = temp;
        for(int i = 1;i < len;i = i + 2) {
            String a1 = A[i];
            A[i] = A[i + 1];
            A[i + 1] = a1;
        }
        return;
    }

    public static void main(String[] args) {
        PerfectShuffle test = new PerfectShuffle();
        String[] A = {"", "a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b5"};
        *//*test.PerfectShuffle(A);*//*
        test.CycleLeader(A, 1, 2 * 5 + 1);
        for(int i = 1;i < A.length;i++)
            System.out.print(A[i]+" ");
    }*/
}
