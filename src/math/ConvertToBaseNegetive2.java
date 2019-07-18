package math;

/**
 * @Description: Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
 *
 * The returned string must have no leading zeroes, unless the string is "0".
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: "110"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
 * Example 2:
 *
 * Input: 3
 * Output: "111"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * Example 3:
 *
 * Input: 4
 * Output: "100"
 * Explantion: (-2) ^ 2 = 4
 * @Author:     alex
 * @CreateDate: 2019/7/18 17:48
 * @Version:    1.0
 *
*/
public class ConvertToBaseNegetive2 {
    public static void main(String[] args) {
        ConvertToBaseNegetive2 convertToBaseNegetive2 = new ConvertToBaseNegetive2();
        System.out.println(convertToBaseNegetive2.baseNeg21(0));
    }
    public String baseNeg2(int N) {
        //1431655765  (2^2+1)(2^4+1)(2^8+1)(2^16+1)的化简结果
        return Integer.toBinaryString(1431655765 ^ (1431655765 - N));
    }
    public String baseNeg21(int N) {
        String res = "";
        while (N != 0) {
            //res = Integer.toString(N & 1) + res;
            res = (N & 1) + res;
            N = - (N >> 1);
        }

        return res == "" ? "0" : res;
    }
}
