package math;

/**
 * @Description: Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 * @Author:     alex
 * @CreateDate: 2019/7/19 11:25
 * @Version:    1.0
 *
*/
public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        ConvertANumberToHexadecimal convertANumberToHexadecimal = new ConvertANumberToHexadecimal();
        System.out.println(0b1111);
        System.out.println(0b11);
        System.out.println(031);
        System.out.println(0xa7);
        System.out.println(convertANumberToHexadecimal.toHex1(-1));
    }
    public String toHex2(int num) {
        StringBuffer res = new StringBuffer();
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i=0; i<8; i++) {
            int number = num & (0b1111);
            num = num >>> 4;
            res.insert(0, ch[number]);
        }
        while (res.charAt(0)=='0' && res.length()>1) res.deleteCharAt(0);
        return res.toString();
    }
    public String toHex1(int num) {
        StringBuffer res = new StringBuffer();
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
       while(num != 0) {
            int number = num & (0b1111);
            num = num >>> 4;
            res.insert(0, ch[number]);
        }
        while (res.charAt(0)=='0' && res.length()>1) res.deleteCharAt(0);
        return res.toString();
    }
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        final int MASK_LAST_FOUR_BITS = 0x00_00_00_0f; // = 0b1111
        final StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int lastFourBits = num & MASK_LAST_FOUR_BITS;
            sb.append(ch[lastFourBits]);
            num = num >>> 4; // I don't know whether It can be written like num >>>= 4; ? ..emm
        }
        return sb.reverse().toString();
    }
}
