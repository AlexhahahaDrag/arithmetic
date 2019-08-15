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
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        PerfectShuffle perfectShuffle = new PerfectShuffle();
        int[] result = perfectShuffle.getPerfectShuffle(arr);
        for(int i : result)
            System.out.print(i + " ");
    }

    private int[] getPerfectShuffle(int[] arr) {
        int n = arr.length / 2;
        int n2, k, m;
        int start = 0;
        while(n > 1) {
            n2 = 2 * n + 1;
            for(k = 0, m = 1; n2 / m >= 3;k++, m *= 3);
            m >>= 1;
            reverse(arr, start + m + 1, start + n);
            reverse(arr, start + n + 1, start + m + n);
            reverse(arr, start + m + 1, start + m + n);
            for (int i = 0, t = 1; k > i ; i++, t *= 3)
                cycle(arr, t, 2 * m + 1, start);
            start = start + 2 * m;
            n = n - m;
        }
        if (n == 1) {
            int temp = arr[arr.length - 1];
            arr[arr.length - 1] = arr[arr.length - 2];
            arr[arr.length -  2] = temp;
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

    private void cycle(int arr[], int start, int mod, int index) {
        for (int i = (start << 1) % mod; i != start; i = (i << 1) % mod) {
            int temp = arr[start + index];
            arr[start + index] = arr[i + index];
            arr[i + index] = temp;
        }
    }

}
