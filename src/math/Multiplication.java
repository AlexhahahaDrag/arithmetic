package math;

/**
 * @Description: 乘法
 * 7 8 9 6 5 2 * 3 2 1 1
 * @Author:     alex
 * @CreateDate: 2019/10/16 13:39
 * @Version:    1.0
 *
 */
public class Multiplication {

    public static void main(String[] args) {
        Multiplication multiplication = new Multiplication();
        System.out.println(multiplication.getMultiply("1811111110111111111", "101112111111111"));
    }

    /**
     * @Description: 小学数学解法
     * @Author:      alex
     * @CreateDate:  2019/10/16 15:11
     * @param
     * @return
    */
    private String getMultiply(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        char[] nu1 = num1.toCharArray();
        char[] nu2 = num2.toCharArray();
        int digit;
        int numMul;
        int numAdd;
        int index;
        int count = 0;
        for (int i = nu2.length - 1; i >= 0; i--) {
            int[] list = new int[nu1.length + 1];
            digit  = 0;
            index = 0;
            for (int j = nu1.length - 1; j >= 0; j--) {
                numMul = (nu1[j] - '0') * (nu2[i] - '0') + digit;
                digit = numMul / 10;
                list[index++] = numMul % 10;
            }
            if (digit != 0) {
                list[nu1.length] = digit;
                digit = 0;
            }
            int add = count;
            for (int k = 0; k < list.length; k++, add++) {
                numAdd = list[k] + arr[add] + digit;
                digit = numAdd / 10;
                arr[add] = numAdd % 10;
            }
            count++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.insert(0, arr[i]);
        }
        int del = 0;
        while (stringBuilder.charAt(del++) == '0')
            stringBuilder.replace(0, 1, "");
        return stringBuilder.toString();
    }
}
