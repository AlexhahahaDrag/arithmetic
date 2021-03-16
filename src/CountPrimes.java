/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes2(10));
    }
    public static int countPrimes2(int n) {
        boolean[] prime=new boolean[n];
        int count=0;
        for (int i = 2; i < n; i++) {
            if (prime[i]==false){
                count++;
                for (int j = i; j*i < n; j++) {
                    prime[j*i]=true;
                }
            }
        }
        return count;
    }
    public static int countPrimes(int n){
        int count=0;
        for (int i = 2; i < n; i++) {
            boolean flag=true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j==0){
                    flag=false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
