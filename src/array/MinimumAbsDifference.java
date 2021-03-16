package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *description:
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 *
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *author:       alex
 *createDate:  2020/3/30 23:25
 *version:      1.0.0      
*/
public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length < 2) {
            return res;
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            int cur = Math.abs(arr[i + 1] - arr[i]);
            if(min > cur) {
                min = cur;
            }
        }

        for(int j = 0; j< arr.length - 1; j++) {
            if(min == Math.abs(arr[j + 1] - arr[j])) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[j]);
                list.add(arr[j + 1]);
                res.add(list);
            }
        }
        return res;
    }
}
