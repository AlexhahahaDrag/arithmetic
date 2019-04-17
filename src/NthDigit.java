/**
 * @Description: Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * @Author:      alex
 * @CreateDate:  2019/2/19 14:11
 * @param
 * @return
 */
public class NthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit1(29));
    }
    public static int findNthDigit(int n) {
        int index=0;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
            if (stringBuilder.length()+index>n)
                break;
            if (stringBuilder.length()>10000){
                index+=stringBuilder.length();
                stringBuilder=new StringBuilder();
            }
        }
        return stringBuilder.toString().charAt(n-index-1)-'0';
    }
    public static int findNthDigit1(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len++ * count;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
