/**
 * @Description: Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 * @Author:      alex
 * @CreateDate:  2019/1/17 16:46
 * @param
 * @return
*/
public class UglyNumberTwo {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n){
        int[] nums=new int[n];
        nums[0]=1;
        int count2=0;
        int count3=0;
        int count5=0;
        int prime2=2;
        int prime3=3;
        int prime5=5;
        int count=1;
        while (count<n){
            nums[count]=Math.min(prime2,Math.min(prime3,prime5));
            if (nums[count]==prime2)
                prime2=2*nums[++count2];
            if (nums[count]==prime3)
                prime3=3*nums[++count3];
            if (nums[count]==prime5)
                prime5=5*nums[++count5];
            count++;
        }
        return nums[n-1];
    }

}
