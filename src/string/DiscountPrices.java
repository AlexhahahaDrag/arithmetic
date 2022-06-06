package string;

import java.text.DecimalFormat;

public class DiscountPrices {
    public String discountPrices(String sen, int discount) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##################0.00");
        String[] s = sen.split(" ");
        out:for(String ss : s) {
            if (ss.startsWith("$")) {
                int i = 0;
                if(ss.charAt(i) == '0') {
                    sb.append(ss).append(" ");
                    continue;
                }
                int len = ss.length();
                long price = 0L;
                while(++i < len) {
                    char ch = ss.charAt(i);
                    if(ch >= '0' && ch <= '9') {
                        price = price * 10 + ch - '0';
                    } else {
                        sb.append(ss).append(" ");
                        continue out;
                    }
                }
                sb.append('$').append(df.format((double)price * (100 - discount) / 100)).append(" ");
            } else {
                sb.append(ss).append(" ");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();
    }

    public static void main(String[] args) {
        String sen = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        int discount = 100;
        DiscountPrices discountPrices = new DiscountPrices();
        System.out.println(discountPrices.discountPrices(sen, discount));
    }
}
