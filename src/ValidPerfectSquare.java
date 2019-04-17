/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(getValidPerfectSquare2(16));
    }
    public static boolean getValidPerfectSquare(int num){
        if (num<23170*23170){
            for (int i = 0; i*i <= num&&i<23171; i++) {
                if (i*i==num)
                    return true;
                else if (i*i>num)
                    return false;
            }
        }else{
            for (int i = 23171; i*i <= num&&i<=46341; i++) {
                if (i*i==num)
                    return true;
                else if (i*i>num)
                    return false;
            }
        }
        return false;
    }
    public static boolean getValidPerfectSquare2(int num){
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
