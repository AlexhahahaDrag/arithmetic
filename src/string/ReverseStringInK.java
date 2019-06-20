package string;

/**
 * 一直一个字符串在一直一个位置反转字符串
 */
public class ReverseStringInK {
    public static void main(String[] args) {
        ReverseStringInK reverseStringInK = new ReverseStringInK();
        System.out.println(reverseStringInK.reverseStringInKDigit("abcdef",2));
    }
    public String reverseStringInKDigit(String str, int k) {
        char[] chars = str.toCharArray();
        k %= chars.length;
        for (int i = 0; i < (k >> 1); i++) {
            char ch = chars[i];
            chars[i] = chars[k - 1 - i];
            chars[k - 1 - i] = ch;
        }
        int j = 0;
        for (int i = k; i < k + ((chars.length - k) >> 1); i++) {
            char ch = chars[i];
            chars[i] = chars[chars.length - 1 - j];
            chars[chars.length - 1 - j] = ch;
            j++;
        }
        for (int i = 0; i < (chars.length >> 1); i++) {
            char ch = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = ch;
        }
        return new String(chars);
    }
}
