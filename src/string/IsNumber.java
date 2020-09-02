package string;

/**
 * @description: 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 *
 *
 * 通过次数25,920提交次数116,870
 * @author:      alex
 * @createTime:  2020/9/2 14:05
 * @version:     1.0
 */
public class IsNumber {

    public boolean isNumber(String s) {
        s = s.replace(" ", "");
        if (s == null || s.length() == 0)
            return false;
        char[] ch = s.toCharArray();
        int eNum = 0;
        int pointNum = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9')
                continue;
            else if (ch[i] == 'e' || ch[i] == 'E') {
                if (i == 0 || eNum == 1 || i == ch.length - 1)
                    return false;
                eNum++;
            } else if (ch[i] == '.') {
                if (pointNum == 1 || 1 == ch.length)
                    return false;
                pointNum++;
            } else if (i > 0 && ch[i] == '+')
                return false;
            else if (ch[i] == '-') {
                if (i != 0 && (ch[i - 1] != 'e' && ch[i - 1] != 'E'))
                    return false;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = ".1";
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber(s));
    }
}
