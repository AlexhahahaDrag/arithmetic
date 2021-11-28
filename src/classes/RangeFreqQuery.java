package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *description:
 * 2080. 区间内查询数字的频率
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 *
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 *
 * 请你实现 RangeFreqQuery 类：
 *
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["RangeFreqQuery", "query", "query"]
 * [[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
 * 输出：
 * [null, 1, 2]
 *
 * 解释：
 * RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
 * rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
 * rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 105
 * 1 <= arr[i], value <= 104
 * 0 <= left <= right < arr.length
 * 调用 query 不超过 105 次。
 *author:       alex
 *createDate:   2021/11/23 17:33
 *version:      1.0.0
 */
public class RangeFreqQuery {

    Map<Integer, List<Integer>> map;
    List<Integer> list;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) == null) {
                list = new ArrayList<>();
                map.put(arr[i], list);
            } else {
                list = map.get(arr[i]);
            }
            list.add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> cur = map.get(value);
        if(cur == null) {
            return 0;
        }
        if(left > cur.get(cur.size() - 1) || right < cur.get(0)) {
            return 0;
        }
        int l = find(left, cur);
        int r = find(right, cur);
        if (cur.get(r) > right) {
            r--;
        }
        return r - l + 1;
    }

    public int find(int v, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while(l < r) {
            int mid = l + r >> 1;
            if(list.get(mid) >= v) { // 满足条件
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        System.out.println(rangeFreqQuery.query(0,1,2));
        System.out.println(rangeFreqQuery.query(0,2,1));
        System.out.println(rangeFreqQuery.query(3,3,2));
        System.out.println(rangeFreqQuery.query(2,2,1));
//        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
//        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
//        System.out.println(rangeFreqQuery.query(1, 2, 4));
//        System.out.println(rangeFreqQuery.query(0, 7, 33));
    }
}
