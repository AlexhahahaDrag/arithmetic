package string;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWords {

    public String reverseWords(String s) {
        int start;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            while(ch[i] == ' ') {
                i++;
            }
            start = i;
            while(i < ch.length && ch[i] != ' ') {
                i++;
            }
            swap(ch, start, i - 1);
        }
        return new String(ch);
    }

    private void swap(char[] ch, int start, int end) {
        char temp;
        while(start < end) {
            temp = ch[end];
            ch[end--] = ch[start];
            ch[start++] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
    }
}
