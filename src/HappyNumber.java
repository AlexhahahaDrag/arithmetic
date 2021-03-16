import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(HappyNumber.isHappy(18));
    }
    public static boolean isHappy2(int n){
        List<Integer> list=new ArrayList<>();
        return isHappyList(n,list);
    }
    public static boolean isHappyList(int n, List list){
        int result = 0;
        while(n > 0) {
            result += Math.pow(n%10, 2);
            n /= 10;
        }
        if (result == 1) {
            return true;
        } else if (list.contains(result)) {
            return false;
        } else {
            list.add(result);
            return isHappyList(result, list);
        }
    }
    public static boolean isHappy(int n) {
        return isHappy(n);
    }
    public static boolean isHappy(long n) {
        long result;
        while(true) {
            result = 0;
            while(n > 0) {
                result += Math.pow(n%10, 2);
                n /= 10;
            }
            if (result == 1) {
                return true;
            }
            if (result == 4) {
                return false;
            }
            n = result;
        }
    }
}
