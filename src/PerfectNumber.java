/**
 * @Description: We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 * @Author:      alex
 * @CreateDate:  2019/2/27 16:33
 * @param
 * @return
*/
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
    public static boolean checkPerfectNumber1(int num) {
        if (num==1)
            return false;
        int sum=1;
        for(int i=2;i<=(int)Math.sqrt(num);i++)
            for(int j=2;j*i<=num;j++)
                if(i*j==num)
                    sum+=i+j;
        return sum==num;
    }
    public static boolean checkPerfectNumber2(int num) {
        int sum=1;
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0)
                sum += i+(num/i==i?0:num/i);
        return sum!=1&& sum == num;
    }
    public static int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
    public static boolean checkPerfectNumber(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime: primes)
            if (pn(prime) == num)
                return true;
        return false;
    }
}
