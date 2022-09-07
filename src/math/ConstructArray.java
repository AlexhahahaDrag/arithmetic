package math;

public class ConstructArray {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;
        int i = k + 1;
        res[0] = 1;
        while (k > 0) {
            res[index + 1] = index % 2 == 0 ? res[index] + k : res[index] - k;
            index++;
            k--;
        }
        while (++i <= n) {
            res[++index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 18;
        int k = 17;
        ConstructArray constructArray = new ConstructArray();
        int[] res = constructArray.constructArray(n, k);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }
}
