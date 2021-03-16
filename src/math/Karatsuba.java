package math;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @Description: Karatsuba乘法是一种快速乘法。此算法在1960年由Anatolii Alexeevitch Karatsuba 提出，并于1962年得以发表。
 * [1]  此算法主要用于两个大数相乘。普通乘法的复杂度是n2，而Karatsuba算法的复杂度仅为3n^log3≈3n^1.585（log3是以2为底的）
 * @Author:     alex
 * @CreateDate: 2019/10/17 10:26
 * @Version:    1.0
 *
 */
public class Karatsuba {

    public static void main(String[] args) {
        BigInteger bigInteger1 = new BigInteger("32");
        System.out.println(bigInteger1.shiftLeft(2));
        System.out.println(bigInteger1);
        Karatsuba karatsuba = new Karatsuba();
        String str1 = "11111111111187967967891117658567856755611233111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111143435111111";
        String str2 = "22222222222222222222222222222222222222222000000000000000000000000333333333333333331111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111113333333333333333333333333322222999999999999999999999999999999999999999999999999999999999999999999999999999999999992222222222222222222";
        int[] num1 = karatsuba.getInt(str1);
        int[] num2 = karatsuba.getInt(str2);
        BigInteger bigInteger = new BigInteger(str1);
        System.out.println(LocalDateTime.now());
        System.out.println(bigInteger.multiply(new BigInteger(str2)));
        System.out.println(LocalDateTime.now());
        System.out.println(karatsuba.getString(num1, num2));
        System.out.println(LocalDateTime.now());
        System.out.println(karatsuba.getResultByKaratsuba(str1, str2));
        System.out.println(LocalDateTime.now());
        System.out.println(karatsuba.getResultByKaratsuba(num1, num2));
        System.out.println(LocalDateTime.now());
    }

    private int[] getInt(String str) {
        int[] res = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res[i] = str.charAt(i) - '0';
        }
        return res;
    }

    private String getResultByKaratsuba(String num1, String num2) {
        if (num1 == null || num2 == null || "".equals(num1) || "".equals(num2)) {
            return "0";
        }
        if (num1.length() < 2 || num2.length() < 2) {
            return Long.parseLong(num1) * Long.parseLong(num2) + "";
        }
        int di1 = num1.length();
        int di2 = num2.length();
        int sub = di1 >= di2 ? di1 >> 1 : di2 >> 1;
        int subIndex1 = di1 - sub > 0 ? di1 - sub : 0;
        String a = num1.substring(0, subIndex1);
        String b = num1.substring(subIndex1);
        int subIndex2 = di2 - sub > 0 ? di2 - sub : 0;
        String c = num2.substring(0, subIndex2);
        String d = num2.substring(subIndex2);
        String x0 = getResultByKaratsuba(a, c);
        String x1 = getResultByKaratsuba(b, d);
        String x = getResultByKaratsuba(addString(a, b), addString(c, d));
        String x2 = minusString(minusString(x, x0), x1);
        return addString(addString(addSub0(x0, sub << 1), x1), addSub0(x2, sub));
    }

    /**
     * @Description: 用零补位
     * @Author:      alex
     * @CreateDate:  2019/10/17 11:59
     * @param
     * @return
    */
    private String addSub0(String x, int sub) {
        if (x == null || "0".equals(x)) {
            return x;
        }
        StringBuilder stringBuilder = new StringBuilder(x);
        while (sub-- > 0) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    /**
     * @Description: 减法
     * @Author:      alex
     * @CreateDate:  2019/10/17 12:00
     * @param
     * @return
    */
    private String minusString(String num1, String num2) {
        if (num1 == null || "0".equals(num1)) {
            return "0".equals(num2) ? num2 : "-" + num2;
        }
        if (num2 == null || "".equals(num2)) {
            return "0".equals(num1) ? num1 : num1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int di1 = num1.length() - 1;
        int di2 = num2.length() - 1;
        int digit = 0;
        int num;
        while (di2 >= 0 || digit > 0) {
            num = num1.charAt(di1--) - '0' - (di2 < 0 ? 0 : (num2.charAt(di2--) - '0')) - digit;
            digit = 0;
            if (num < 0) {
                num += 10;
                digit = 1;
            }
            stringBuilder.insert(0, num);
        }
        while (di1 >= 0) {
            stringBuilder.insert(0, num1.charAt(di1--));
        }
        int index = 0;
        while(stringBuilder.length() > 1 && stringBuilder.charAt(index) == '0') {
            stringBuilder.replace(0, 1,"");
        }
        return stringBuilder.toString();
    }

    private String addString(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }
        if ("0".equals(num2)) {
            return num1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int di1 = num1.length() - 1;
        int di2 = num2.length() - 1;
        int digit = 0;
        while (di1 >= 0 || di2 >= 0 || digit > 0) {
            int num = digit + (di1 < 0 ? 0 : (num1.charAt(di1--) - '0')) + (di2 < 0 ? 0 : (num2.charAt(di2--) - '0'));
            digit = num / 10;
            stringBuilder.insert(0, num % 10);
        }
        return stringBuilder.toString();
    }

    private String getString(int[] num1, int[] num2) {
        StringBuilder sb = new StringBuilder();
        int[] res = getResultByKaratsuba(num1, num2);
        for (int i: res) {
            sb.append(i);
        }
        return sb.toString();
    }
    private int[] getResultByKaratsuba(int[] num1, int[] num2) {
        if (num1 == null || num2 == null || num1.length == 0 || num2.length == 0) {
            return new int[]{0};
        }
        if (num1.length < 2) {
            return getSum(num2, num1[0]);
        } else if (num2.length < 2) {
            return getSum(num1, num2[0]);
        }
        int di1 = num1.length;
        int di2 = num2.length;
        int sub = di1 >= di2 ? di1 >> 1 : di2 >> 1;
        int subIndex1 = di1 - sub > 0 ? di1 - sub : 0;
        int[] a = new int[subIndex1];
        System.arraycopy(num1, 0, a, 0,subIndex1);
        int[] b = new int[di1 - subIndex1];
        System.arraycopy(num1, subIndex1, b, 0, b.length);
        int subIndex2 = di2 - sub > 0 ? di2 - sub : 0;
        int[] c = new int[subIndex2];
        System.arraycopy(num2, 0, c, 0, subIndex2);
        int[] d = new int[di2 - subIndex2];
        System.arraycopy(num2, subIndex2, d, 0, d.length);
        int[] x0 = getResultByKaratsuba(a, c);
        int[] x1 = getResultByKaratsuba(b, d);
        int[] x = getResultByKaratsuba(addString(a, b), addString(c, d));
        int[] x2 = minusString(minusString(x, x0), x1);
        return addString(addString(addSub0(x0, sub << 1), x1), addSub0(x2, sub));
    }

    private int[] getSum(int[] num, int mul) {
        int[] res = new int[num.length + 1];
        int digit = 0;
        int index = num.length - 1;
        while(index >= 0 || digit > 0) {
            int nu = (index < 0 ? 0 :num[index]) * mul + digit;
            res[index-- + 1] = nu % 10;
            digit = nu / 10;
        }
        return sub0(res);
    }

    /**
     * @Description: 用零补位
     * @Author:      alex
     * @CreateDate:  2019/10/17 11:59
     * @param
     * @return
     */
    private int[] addSub0(int[] x, int sub) {
        if (x.length == 0 || (x.length == 1 &&  x[0] == 0)) {
            return new int[]{0};
        }
        int[] res = new int[x.length + sub];
        System.arraycopy(x, 0, res, 0, x.length);
        return res;
    }

    /**
     * @Description: 减法
     * @Author:      alex
     * @CreateDate:  2019/10/17 12:00
     * @param
     * @return
     */
    private int[] minusString(int[] num1, int[] num2) {
        int di1 = num1.length - 1;
        int di2 = num2.length - 1;
        int[] res = new int[num1.length];
        int digit = 0;
        int num;
        int index = res.length - 1;
        while (di1 >= 0 || di2 >= 0 || digit > 0) {
            num = num1[di1--] - (di2 < 0 ? 0 : (num2[di2--])) - digit;
            digit = 0;
            if (num < 0) {
                num += 10;
                digit = 1;
            }
            res[index--] = num;
        }
       return sub0(res);
    }

    private int[] sub0(int[] res) {
        int zeroNum = 0;
        while (zeroNum < res.length - 1 && res[zeroNum] == 0) {
            zeroNum++;
        }
        int[] lastRes = new int[res.length - zeroNum];
        System.arraycopy(res, zeroNum, lastRes, 0, lastRes.length);
        return lastRes;
    }

    private int[] addString(int[] num1, int[] num2) {
        int di1 = num1.length - 1;
        int di2 = num2.length - 1;
        int[] res = new int[num1.length >= num2.length ? (num1.length + 1) : (num2.length + 1)];
        int digit = 0;
        int index = res.length - 1;
        while (di1 >= 0 || di2 >= 0 || digit > 0) {
            int num = digit + (di1 < 0 ? 0 : (num1[di1--])) + (di2 < 0 ? 0 : (num2[di2--]));
            digit = num / 10;
            res[index--] = num % 10;
        }
        return sub0(res);
    }
}
