import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @Author:      alex
 * @CreateDate:  2019/2/19 11:01
 * @param
 * @return
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
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
        return lists;
    }public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> lists=new ArrayList<>();
        if (numRows<=0) {
            return lists;
        } else if (numRows==1){
            List<Integer> list=new ArrayList<>();
            list.add(1);
            lists.add(list);
        }else {
            List<Integer> list=new ArrayList<>();
            list.add(1);
            lists.add(list);
            List<Integer> list1=new ArrayList<>();
            list1.add(1);
            list1.add(1);
            lists.add(list1);
            for (int i = 3; i <= numRows; i++) {
                List<Integer> list2=new ArrayList<>();
                int start=0;
                list2.add(1);
                List<Integer> list12=lists.get(i-2);
                while (start<i-2){
                    list2.add(list12.get(start)+list12.get(start+1));
                }
                list2.add(1);
                lists.add(list2);
            }
        }
        return lists;
    }
}
