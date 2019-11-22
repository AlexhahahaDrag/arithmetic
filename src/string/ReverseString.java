package string;

/**
 * @Description:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @Author:     alex
 * @CreateDate: 2019/11/22 16:53
 * @Version:    1.0
 *
*/
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString.reverseString(s);
        for (char ch : s)
            System.out.print(ch);
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end)
            swap(s, start++, end--);
    }
    private void swap(char[] s, int start, int end) {
        s[start] = (char)(s[start] + s[end]);
        s[end] = (char)(s[start] - s[end]);
        s[start] = (char)(s[start] - s[end]);
    }
}
