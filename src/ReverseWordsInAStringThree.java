/**
 * @Description: Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * @Author:      alex
 * @CreateDate:  2019/1/24 14:13
 * @param
 * @return
*/
public class ReverseWordsInAStringThree {
    public static void main(String[] args) {
        String s="Let's";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s){
        String[] words=s.split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(new StringBuilder(words[i]).reverse().append(" ").toString());
        }
        return stringBuilder.toString().trim();
    }
    public String reverseWords1(String s) {

        if (s.length() == 0) {
            return s;
        }
        int left = 0;
        char[] str = s.toCharArray();
        while (s.indexOf(' ', left) != -1) {
            int right = s.indexOf(' ', left + 1);
            reverse(left, right - 1, str);
            left = right + 1;
        }
        reverse(left, s.length() - 1, str);
        return new String(str);
    }
    void reverse(int left, int right, char[] s) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            ++ left;
            -- right;
        }
    }
}
