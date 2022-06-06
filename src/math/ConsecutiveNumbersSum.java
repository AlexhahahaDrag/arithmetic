package math;

public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int n) {
        int res = 1;
        int end = (int)Math.sqrt(n << 1);
        //个数
        for(int i = 2; i <= end; i++) {
            if(judge(n, i)) {
                res++;
            }
        }
        return res;
    }

    private boolean judge(int n, int num) {
        n -= num * (num - 1) >> 1;
        int start = n / num;
        long cur;
        for(int i = start; i > 0; i--) {
            cur = i * num;
            if (cur == n) {
                return true;
            } else if (cur < n) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int n = 53965645;//8
//        int n = 15;//4
        int n = 472330709;//4
        ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();
        System.out.println(consecutiveNumbersSum.consecutiveNumbersSum(n));
    }
}
