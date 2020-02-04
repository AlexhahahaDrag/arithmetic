package string_array;

import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = {"This", "is", "an", "example", "of", "text", "justification."}
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2020/2/4 10:27
 *version:      1.0.0      
*/
public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int num = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            sum += words[i].length();
            if(sum > maxWidth - num) {
                sum -= words[i].length();
                add(sb, i - 1, maxWidth, num - 1, sum, words);
                list.add(sb.toString());
                sb = new StringBuilder();
                sb.append(words[i]);
                sum = words[i].length();
                num = 1;
            }else{
                num++;
                sb.append(words[i]);
            }
        }
        add(sb, words.length - 1, maxWidth, num - 1, sum, words);
        list.add(sb.toString());
        return list;
    }

    private void add(StringBuilder sb, int index, int maxWidth,int num, int sum, String[] words) {
        if (index == words.length - 1) {
            addSpace(sb, sum, maxWidth - sum - num);
            while(num-- > 0)
                addSpace(sb, sum = sum - words[index--].length(), 1);
        } else {
            int sub = maxWidth - sum;
            if (num == 0){
                addSpace(sb, sum, sub);
                return;
            }
            int a = sub / num;
            int b = sub % num;
            while(num > 0) {
                if (num-- > b)
                    addSpace(sb, sum = sum - words[index--].length(), a);
                else
                    addSpace(sb, sum = sum - words[index--].length(), a + 1);
            }
        }
    }

    private void addSpace(StringBuilder sb, int index, int len) {
        while(len-- > 0)
            sb.insert(index, " ");
    }
    public static void main(String[] args) {
        FullJustify fullJustify = new FullJustify();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        System.out.println(fullJustify.fullJustify(words, maxWidth));
    }
}
