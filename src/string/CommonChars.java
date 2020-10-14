package string;

import array.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * @author:      alex
 * @createTime:  2020/10/14 9:18
 * @version:     1.0
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[][] map = new int[A.length][];
        if (A == null || A.length == 0)
            return res;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null || A[i].length() == 0)
                return null;
            map[i] = getCount(A[i]);
        }
        int[] common = map[0];
        for (int i = 1; i < map.length; i++)
            for (int j = 0; j < common.length; j++)
                if (common[j] > 0)
                    common[j] = Math.min(common[j], map[i][j]);
        for (int i = 0; i < common.length; i++)
            if (common[i] > 0) {
                String temp = String.valueOf((char)(i + 'a'));
                while (common[i]-- > 0)
                    res.add(temp);
            }
        return res;
    }

    private int[] getCount(String str) {
        int[] res = new int[26];
        for (char c : str.toCharArray())
            res[c - 'a']++;
        return res;
    }

    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        CommonChars commonChars = new CommonChars();
        System.out.println(commonChars.commonChars(A));
    }
}
