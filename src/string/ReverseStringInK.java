package string;

/**
 * 一直一个字符串在一直一个位置反转字符串
 */
public class ReverseStringInK {

    public static void main(String[] args) {
        ReverseStringInK reverseStringInK = new ReverseStringInK();
        System.out.println(reverseStringInK.reverseStringInKDigit("lrloseumgh",6));
    }

    public String reverseStringInKDigit1(String str, int k) {
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

    public String reverseStringInKDigit(String str, int k) {
        char[] strs = str.toCharArray();
        k %= strs.length;
        reverse(strs, 0, strs.length - 1, k);
        return new String(strs);
    }

    private void reverse(char[] strs, int l, int r, int same) {
        int lpart = same;
        int rpart = r - same + 1;
        int diff = lpart - rpart;
        same = Math.min(lpart, rpart);
        exchange(strs, l, r, same);
        while(diff != 0) {
            if (diff < 0) {
                r -= same;
                rpart = -diff;
            } else {
                l += same;
                lpart = diff;
            }
            same = Math.min(lpart, rpart);
            diff = lpart - rpart;
            exchange(strs, l, r, same);
        }
    }

    private void exchange(char[] strs, int l, int r, int same) {
        int rc = r - same + 1;
        char temp;
        int index = -1;
        while (++index < same) {
            temp = strs[l + index];
            strs[l + index] = strs[rc + index];
            strs[rc + index] = temp;
        }
    }
}
