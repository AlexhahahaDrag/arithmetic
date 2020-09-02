import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("\n其他\n\n");
        System.out.println("-====================");
        System.out.println("\n其他\n\n".replace("\n", ""));
        System.out.println("===================--");
        System.out.println((int)'\n');
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
