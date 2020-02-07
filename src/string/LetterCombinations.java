package string;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/7 11:13
 *version:      1.0.0      
*/
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || "".equals(digits))
            return list;
        char[] str = new char[digits.length()];
        getList(digits, 0, list, str);
        return list;
    }

    private void getList(String digits, int index, List<String> list, char[] str) {
        if (index == digits.length()) {
            list.add(new String(str));
            return;
        }
        char num = digits.charAt(index);
        for (int i = findStart(num); i <= findEnd(num); i++) {
            str[index] = (char)i;
            getList(digits, index + 1, list, str);
        }
    }

    private char findStart(char ch) {
        switch (ch) {
            case '2' :
                return 'a';
            case '3':
                return 'd';
            case '4':
                return 'g';
            case '5':
                return 'j';
            case '6':
                return 'm';
            case '7':
                return 'p';
            case '8':
                return 't';
            case '9':
                return 'w';
            default:
                return ' ';
        }
    }

    private char findEnd(char ch) {
        switch (ch) {
            case '2' :
                return 'c';
            case '3':
                return 'f';
            case '4':
                return 'i';
            case '5':
                return 'l';
            case '6':
                return 'o';
            case '7':
                return 's';
            case '8':
                return 'v';
            case '9':
                return 'z';
            default:
                return ' ';
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String str = "";
        System.out.println(letterCombinations.letterCombinations(str));
    }
}
