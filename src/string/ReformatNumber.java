package string;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/10/1 6:27
 * @version: 1.0.0
 */
public class ReformatNumber {

    public String reformatNumber(String number) {
        int num = 0;
        int len = number.length();
        char[] sb = new char[len + len / 3];
        int i = -1;
        int index = 0;
        while(++i < len) {
            char cur = number.charAt(i);
            if (cur >= '0' && cur <= '9') {
                sb[index++] = cur;
                num = ++num % 3;
                if (num == 0) {
                    sb[index++] = '-';
                }
            }
        }
        if (num == 0) {
            index--;
        } else if (num == 1) {
            char c = sb[index - 3];
            sb[index - 3] = sb[index - 2];
            sb[index - 2] = c;
        }
        return new String(sb, 0 , index);
    }
}
