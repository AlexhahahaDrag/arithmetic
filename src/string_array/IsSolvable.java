package string_array;

/**
 * Description:
 * 1307. 口算难题
 *
 * 给你一个方程，左边用 words 表示，右边用 result 表示。
 *
 * 你需要根据以下规则检查方程是否可解：
 *
 * 每个字符都会被解码成一位数字（0 - 9）。
 * 每对不同的字符必须映射到不同的数字。
 * 每个 words[i] 和 result 都会被解码成一个没有前导零的数字。
 * 左侧数字之和（words）等于右侧数字（result）。 
 * 如果方程可解，返回 True，否则返回 False。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["SEND","MORE"], result = "MONEY"
 * 输出：true
 * 解释：映射 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
 * 所以 "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
 * 示例 2：
 *
 * 输入：words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
 * 输出：true
 * 解释：映射 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->4
 * 所以 "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
 * 示例 3：
 *
 * 输入：words = ["THIS","IS","TOO"], result = "FUNNY"
 * 输出：true
 * 示例 4：
 *
 * 输入：words = ["LEET","CODE"], result = "POINT"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 2 <= words.length <= 5
 * 1 <= words[i].length, results.length <= 7
 * words[i], result 只含有大写英文字母
 * 表达式中使用的不同字符数最大为 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verbal-arithmetic-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/30 17:57
 * Version:     1.0
 *
*/
public class IsSolvable {

    int[] noZeroChar;

    int[] charToNum;

    int[] numToChar;

    public boolean isSolvable(String[] words, String result) {
        noZeroChar = new int[10];
        int maxLen = 0;
        for(String word : words) {
            if (word.length() > maxLen) {
                maxLen = word.length();
            }
            noZeroChar[word.charAt(0) - 'A'] = 1;
        }
        if (maxLen > result.length()) {
            return false;
        }
        charToNum = new int[26];
        for(int i = 0; i < charToNum.length; i++) {
            charToNum[i] = -1;
        }
        numToChar = new int[result.length()];
        return dfs(words, result, 0, 0, 0);
    }

    private boolean dfs(String[] words, String result, int index, int postInd, int digit) {
        if (postInd >= words[index].length()) {
            dfs(words, result, ++index, postInd, digit);
        }
        char ch = words[index].charAt(postInd);
        if (charToNum[ch - 'A'] != -1) {
            int sum = digit + numToChar[postInd] + charToNum[ch - 'A'];
            dfs(words, result, index, ++postInd, sum / 10);
        }else {

        }
        return false;
    }

    public static void main(String[] args) {
        IsSolvable isSolvable = new IsSolvable();
        String[] str = {"SEND","MORE"};
        String result = "MONEY";
        System.out.println(isSolvable.isSolvable(str, result));
    }
}
