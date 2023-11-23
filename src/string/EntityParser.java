package string;

import java.util.Arrays;

/**
 *description:
 * 5382. HTML 实体解析器 显示英文描述
 * 用户通过次数70
 * 用户尝试次数76
 * 通过次数70
 * 提交次数90
 * 题目难度Medium
 * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
 *
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 *
 * 双引号：字符实体为 &quot; ，对应的字符是 " 。
 * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
 * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
 * 大于号：字符实体为 &gt; ，对应的字符是 > 。
 * 小于号：字符实体为 &lt; ，对应的字符是 < 。
 * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 * 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text = "&amp; is an HTML entity but &ambassador; is not."
 * 输出："& is an HTML entity but &ambassador; is not."
 * 解释：解析器把字符实体 &amp; 用 & 替换
 * 示例 2：
 *
 * 输入：text = "and I quote: &quot;...&quot;"
 * 输出："and I quote: \"...\""
 * 示例 3：
 *
 * 输入：text = "Stay home! Practice on Leetcode :)"
 * 输出："Stay home! Practice on Leetcode :)"
 * 示例 4：
 *
 * 输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * 输出："x > y && x < y is always false"
 * 示例 5：
 *
 * 输入：text = "leetcode.com&frasl;problemset&frasl;all"
 * 输出："leetcode.com/problemset/all"
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 10^5
 * 字符串可能包含 256 个ASCII 字符中的任意字符。
 *author:       alex
 *createDate:  2020/4/12 10:48
 *version:      1.0.0      
*/
public class EntityParser {

    public String entityParser1(String text) {
        return text.replace("&apos;", "'")
                .replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&frasl;", "/")
                .replace("&amp;", "&");
    }

    StringBuilder stringBuilder = new StringBuilder();
    public String entityParser(String text) {
        char[] ches = text.toCharArray();
        for (int i = 0; i < ches.length; i++) {
            if (ches[i] == '&') {
                i = judge(i, ches);
            }else{
                stringBuilder.append(ches[i]);
            }
        }
        return stringBuilder.toString();
    }

    private int judge(int i, char[] ches) {
        String str =  new String(Arrays.copyOfRange(ches, i, i + 6));
        if ("&quot;".equals(str)) {
            stringBuilder.append("\"");
            return i + 5;
        } else if ("&apos;".equals(str)) {
            stringBuilder.append("\'");
            return i + 5;
        }
        str =  new String(Arrays.copyOfRange(ches, i, i + 5));
        if ("&amp;".equals(str)) {
            stringBuilder.append("&");
            return i + 4;
        }
        str =  new String(Arrays.copyOfRange(ches, i, i + 4));
        if ("&gt;".equals(str)) {
            stringBuilder.append(">");
            return i + 3;
        } else if ("&lt;".equals(str)) {
            stringBuilder.append("<");
            return i + 3;
        }
        str =  new String(Arrays.copyOfRange(ches, i, i + 7));
        if ("&frasl;".equals(str)) {
            stringBuilder.append("/");
            return i + 6;
        }
        stringBuilder.append("&");
        return i;
    }

    public static void main(String[] args) {
        EntityParser entityParser = new EntityParser();
        System.out.println(entityParser.entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }
}
