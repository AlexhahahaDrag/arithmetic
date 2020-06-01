import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(get(-0.005));
        System.out.println(get(0.005));
        System.out.println(get(-0.006));
        System.out.println(get(0.006));
        System.out.println(get(-0.004));
        System.out.println(get(0.004));
    }


    public static String get(double value) {
        double nu = value;
        boolean negative = false;
        if (nu < 0) {
            nu = -nu;
            negative = true;
        }
        long res = Math.round(nu * 100);
        double num= (double)res / 100;
        if (negative)
            num = -num;
        String str = num + " ";
        Integer rs = str.indexOf('.');
        if (rs < 0) {
            rs = str.length();
            str += '.';
        }
        while (str.length() <= rs + 2) {
            str += '0';
        }
        return str;
    }
}
