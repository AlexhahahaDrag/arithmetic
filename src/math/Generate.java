package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @Author:     alex
 * @CreateDate: 2019/11/26 13:52
 * @Version:    1.0
 *
*/
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 1;
        while(start <= numRows) {
            getGenerate(list, start++);
        }
        return list;
    }
    private void getGenerate(List<List<Integer>> result, int n) {
        List<Integer> list = new ArrayList<>();
        if(n == 1) {
            list.add(1);
        } else if (n == 2) {
            list.add(1);
            list.add(1);
        }else {
            list.add(1);
            List<Integer> pre = result.get(n - 2);
            int index = 0;
            int size = pre.size();
            while(index < size - 1) {
                list.add(pre.get(index) + pre.get(index + 1));
                index++;
            }
            list.add(1);
        }
        result.add(list);
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        List<List<Integer>> list = generate.generate(10);
        int index = 1;
        for (List<Integer> l : list) {
            System.out.println(index++ + ":" + l);
        }
    }
}
