import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 * @Author:      alex
 * @CreateDate:  2019/2/19 11:43
 * @param
 * @return
*/
public class PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if (j==0||j==i) {
                    list.add(1);
                } else {
                    list.add(lists.get(i-1).get(j)+lists.get(i-1).get(j-1));
                }
            }
            lists.add(list);
        }
        return lists.get(rowIndex);
    }
}
