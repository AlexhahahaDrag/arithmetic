import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 *
 * Note:  1 <= S.length <= 1000
 * @Author:      alex
 * @CreateDate:  2019/5/13 14:05
 * @param
 * @return
*/
public class PositionOfLargeGroups {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aaa"));
    }
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list=new ArrayList<>();
        int start=0;
        int end=0;
        char[] ch=S.toCharArray();
        while(start<ch.length){
            while(end<ch.length&&ch[start]==ch[end])
                end++;
            if (end-start>=3){
                list.add(Arrays.asList(new Integer[]{start,end-1}));
            }
            start=end;
        }
        return list;
    }
}
