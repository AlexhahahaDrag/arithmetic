/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits1(382));
    }
    public static int addDigits(int num){
        int numCount=num;
        int count=0;
       while(numCount>0){
           count++;
           numCount/=10;
       }
       int[] nums=new int[count];
       int i=0;
       while (num>0){
           nums[i++]=num%10;
           num/=10;
       }
        int sum=0;
        for (int j = 0; j < nums.length; j++)
            sum+=nums[j];
        if (sum>10)
            return addDigits(sum);
        else
            return sum;
    }
    public static int addDigits1(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
