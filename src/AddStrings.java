/**
 * @Description: Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @Author:      alex
 * @CreateDate:  2019/2/12 16:56
 * @param
 * @return
*/
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("123","213345"));
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder=new StringBuilder();
        int carry=0;
        int i=num1.length()-1;
        int j=num2.length()-1;
        while(i>=0||j>=0||carry>0){
            int a=i>=0?num1.charAt(i--)-'0':0;
            int b=j>=0?num2.charAt(j--)-'0':0;
            int sum=a+b+carry;
            carry=sum/10;
            stringBuilder.append(sum%10);
        }
        return stringBuilder.reverse().toString();
    }
}
