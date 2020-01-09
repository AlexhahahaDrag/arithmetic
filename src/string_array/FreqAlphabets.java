package string_array;

/**
 * Description:
 *
 * 1309. 解码字母到整数映射
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 *
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 *
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 *
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  1/9/2020 9:55 AM
 * Version:     1.0
 *
*/
public class FreqAlphabets {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int index = len - 1;
        while(index >= 0) {
            if (s.charAt(index) == '#') {
                sb.insert(0, map(s.substring(index - 2, index)));
                index -= 3;
            } else {
                sb.insert(0, map(s.substring(index, index + 1)));
                index -= 1;
            }
        }
        return sb.toString();
    }

    private String map(String map) {
        switch (map) {
            case "1" :
                return "a";
            case "2" :
                return "b";
            case "3" :
                return "c";
            case "4" :
                return "d";
            case "5" :
                return "e";
            case "6" :
                return "f";
            case "7" :
                return "g";
            case "8" :
                return "h";
            case "9" :
                return "i";
            case "10" :
                return "j";
            case "11" :
                return "k";
            case "12" :
                return "l";
            case "13" :
                return "m";
            case "14" :
                return "n";
            case "15" :
                return "o";
            case "16" :
                return "p";
            case "17" :
                return "q";
            case "18" :
                return "r";
            case "19" :
                return "s";
            case "20" :
                return "t";
            case "21" :
                return "u";
            case "22" :
                return "v";
            case "23" :
                return "w";
            case "24" :
                return "x";
            case "25" :
                return "y";
            case "26" :
                return "z";
        }
        return "";
    }

    public static void main(String[] args) {
        FreqAlphabets freqAlphabets = new FreqAlphabets();
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.println(freqAlphabets.freqAlphabets(s));
        System.out.println(freqAlphabets.freqAlphabets(s).equals("abcdefghijklmnopqrstuvwxyz"));
    }
}
