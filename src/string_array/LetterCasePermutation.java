package string_array;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 *
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 *
 * 提示：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *author:       alex
 *createDate:   2021/11/18 21:17
 *version:      1.0.0
 */
public class LetterCasePermutation {

    private List<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        char[] ch = s.toCharArray();
        dfs(ch, 0);
        return res;
    }

    private void dfs(char[] ch, int i) {
        for(; i < ch.length; i++) {
            if (Character.isLetter(ch[i])) {
                ch[i] = (char)(ch[i] - 'a' >= 0 ? ch[i] - 32 : ch[i] + 32);
                dfs(ch, i + 1);
                ch[i] = (char)(ch[i] - 'a' >= 0 ? ch[i] - 32 : ch[i] + 32);
            }
        }
        if(i ==  ch.length) {
            res.add(new String(ch));
        }
    }

    private void dfs1(char[] ch, int i) {
        for(; i < ch.length; i++) {
            if(ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] = (char)(ch[i] - 'a' + 'A');
            } else if(ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] - 'A' + 'a');
            } else {
                continue;
            }
            dfs(ch, i + 1);
            if(ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] = (char)(ch[i] - 'a' + 'A');
            } else if(ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] - 'A' + 'a');
            }
        }
        if(i ==  ch.length) {
            res.add(new String(ch));
        }
    }

    public static void main(String[] args) {
//        String s = "123";
        String s = "a1b2";
        System.out.println((int)'a' + "_" + (int)'A');
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation(s));
    }
}
