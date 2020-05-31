package string;

import java.util.Stack;

/**
 *description:
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *author:       alex
 *createDate:   2020/5/28 21:13
 *version:      1.0.0
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        int obInd = 0;
        int len = s.length();
        StringBuilder stringBUilder = new StringBuilder();
        int index = 0;
        while(index < len) {
            char ch = s.charAt(index);
            if (ch >= '0' && ch <= '9' || ch == '[') {
                stack.add(obInd);
            }
        }
        return "";
    }

    private String getString(Integer count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("a"));
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
