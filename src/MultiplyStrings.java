/**
 * @Description: Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @Author:      alex
 * @CreateDate:  2019/2/12 17:12
 * @param
 * @return
*/
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }
    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if ((len1 == 1 && num1.charAt(0) == '0') || (len2 == 1 && num2.charAt(0) == '0')) return "0";
        int[] nums = new int[len1+len2];
        char[] char_num1 = num1.toCharArray();
        char[] char_num2 = num2.toCharArray();
        for (int i = len1-1; i >= 0; i--)
            for (int j = len2-1; j>=0; j--)
                nums[i+j+1] += (char_num1[i] - '0') * (char_num2[j] - '0');
        for (int i = len1+len2-1; i >= 1; i--){
            nums[i-1] += nums[i]/10;
            nums[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        if (nums[0] != 0) sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++) sb.append(nums[i]);
        return sb.toString();
    }
}
