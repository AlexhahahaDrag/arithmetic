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
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        /*String s1 = "123456789";
        String s2 = "987654321";*/
        String s1 = "23650399";
        String s2 = "1148";
        System.out.println(multiplyStrings.multiply(s1, s2));
        System.out.println("121932631112635269");
    }

    public String multiply1(String num1, String num2) {
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

    public String multiply(String num1, String num2) {
        return multiplyTwoBigNums(num1, num2);
    }

    private String multiplyTwoBigNums(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 < 3) {
            if (l2 < 3) {
                return Integer.parseInt(s1) * Integer.parseInt(s2) + "";
            } else {
                int mid2 = s2.length() >> 1;
                return add(addDigit(multiplyTwoBigNums(s1, s2.substring(0, mid2)), s2.length() - mid2) , multiplyTwoBigNums(s1, s2.substring(mid2)));
            }
        } else {
            int mid1 = s1.length() >> 1;
            if (l2 < 3) {
                return add(addDigit(multiplyTwoBigNums(s2, s1.substring(0, mid1)), s1.length() - mid1), multiplyTwoBigNums(s2, s1.substring(mid1)));
            } else {
                int mid2 = s2.length() >> 1;
                String res1 = addDigit(multiplyTwoBigNums(s1.substring(0, mid1), s2.substring(0, mid2)), s2.length() - mid2 + s1.length() - mid1);
                String res2 = addDigit(multiplyTwoBigNums(s1.substring(0, mid1), s2.substring(mid2)),s1.length() - mid1);
                String res3 = addDigit(multiplyTwoBigNums(s1.substring(mid1), s2.substring(0, mid2)), s2.length() - mid2);
                String res4 = multiplyTwoBigNums(s1.substring(mid1), s2.substring(mid2));
                return add(add(add(res1, res2), res3), res4);
            }
        }
    }

    private String addDigit(String s, int digit) {
        StringBuilder sb = new StringBuilder(s);
        while(--digit >= 0)
            sb.append("0");
        return sb.toString();
    }

    private String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        int digit = 0;
        while(len1 >= 0 || len2 >= 0 || digit > 0) {
            int l1 = len1 >= 0 ? s1.charAt(len1--) - '0' : 0;
            int l2 = len2 >= 0 ? s2.charAt(len2--) - '0' : 0;
            int sum = l1 + l2 + digit;
            sb.append(sum % 10);
            digit = sum / 10;
        }
        while(sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
            sb.replace(sb.length() - 1, sb.length(), "");
        return sb.reverse().toString();
    }
}
