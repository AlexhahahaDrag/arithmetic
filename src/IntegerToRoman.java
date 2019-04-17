import java.util.Map;

/**
 * @Description: Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * @Author:      alex
 * @CreateDate:  2019/2/14 11:37
 * @param
 * @return
*/
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman1(1994));
    }
    public static String intToRoman(int num) {
        StringBuilder stringBuilder=new StringBuilder();
        int digit=(num+"").length()-1;
        while(digit>=0){
            int a=num/(int)(Math.pow(10,digit));
            num-=a*(int)(Math.pow(10,digit));
            if (a==9){
                a=0;
                stringBuilder.append(map((int)(Math.pow(10,digit))));
                stringBuilder.append(map((int)(Math.pow(10,digit+1))));
            }else if (a==4){
                a=0;
                stringBuilder.append(map((int)(Math.pow(10,digit))));
                stringBuilder.append(map((int)(5* Math.pow(10,digit))));
            }else if (a>=5){
                a-=5;
                stringBuilder.append(map((int)(5*Math.pow(10,digit))));
            }
            while(a>0){
                stringBuilder.append(map((int)(Math.pow(10,digit))));
                a--;
            }
            digit--;
        }
        return stringBuilder.toString();
    }
    private static String map(int c) {
        switch(c) {
            case 1: return "I";
            case 5: return "V";
            case 10: return "X";
            case 50: return "L";
            case 100: return "C";
            case 500: return "D";
            case 1000: return "M";
            default: return "";
        }
    }
    public static String intToRoman1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num -=values[i];
                sb.append(strs[i]);
            }


        }

        return sb.toString();
    }
}
