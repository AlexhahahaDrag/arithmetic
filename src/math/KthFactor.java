package math;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/11/4 7:36
 * @version: 1.0.0
 */
public class KthFactor {

    public int kthFactor(int n, int k) {
        boolean[] map = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            if (map[i]) {
                k--;
            } else {
                if (n % i == 0) {
                    k--;
                    map[i] = true;
                    map[n / i] = true;
                }
            }
            if (k == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        int k = 2;
        KthFactor kthFactor = new KthFactor();
        System.out.println(kthFactor.kthFactor(n, k));
    }
}
