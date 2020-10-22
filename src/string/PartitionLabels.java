package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * @author:      alex
 * @createTime:  2020/10/22 10:55
 * @version:     1.0
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        //获取每个字母在字符串中的最后位置
        for (char i = 'a'; i <= 'z'; i++)
            map[i - 'a'] = S.lastIndexOf(i);
        List<Integer> res = new ArrayList<>();
        int index = 0;
        int len = S.length();
        while(index < len) {
            //记录当前位置
            int start = index;
            //获取字符在字符串的最后位置
            int cur = map[S.charAt(index) - 'a'];
            //从start到cur位置，查看其中的字符是否都在这个区间内，如果不在，则更新cur的位置，保证每一个片段上的字符都是唯一的
            while (++index <= cur && index < len) {
                if (map[S.charAt(index) - 'a'] > cur)
                    cur = map[S.charAt(index) - 'a'];
            }
            //计算片段的长度
            res.add(index - start);
        }
        return res;
    }

    public static void main(String[] args) {
        //String S = "ababcbacadefegdehijhklij";
        String S = "";
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels(S));
    }
}
