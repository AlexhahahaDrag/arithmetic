package math;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/10/30 11:20
 * @version: 1.0.0
 */
public class MakeIntegerBeautiful {

    public long makeIntegerBeautiful(long n, int target) {
        long ans = 0;
        long lastN = n;
        long i = 10;
        while(!judge(n, target)) {
            lastN = n;
            n = (n / i + 1) * i;
            i *= 10;
            ans += n - lastN;
        }
        return ans;
    }

    private boolean judge(long n, int target) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum <= target;
    }

    public static void main(String[] args) {
//        long n = 1992;
//        int target = 11;//8
        long n = 467;
        int target = 6;//8
        MakeIntegerBeautiful makeIntegerBeautiful = new MakeIntegerBeautiful();
        System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(n, target));
    }
}
