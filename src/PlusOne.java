import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * @Author:      alex
 * @CreateDate:  2019/2/12 17:38
 * @param
 * @return
*/
public class PlusOne {
    public static void main(String[] args) {
        int[] digits={9,9,9};
        System.out.println(plusOne(digits));
    }
    public static int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while (i>=0&&digits[i]==9) {
            digits[i--]=0;
        }
        if (i<0){
            int[] newDigits=new int[digits.length+1];
            for (int j = digits.length; j >0; j--) {
                newDigits[j]=digits[j-1];
            }
            newDigits[0]=1;
            return newDigits;
        }else {
            digits[i]++;
        }
        return digits;
    }
}
