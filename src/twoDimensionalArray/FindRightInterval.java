package twoDimensionalArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *description:
 *author:       alex
 *createDate:   2022/5/20 5:52
 *version:      1.0.0
 */
public class FindRightInterval {

    public int[] findRightInterval1(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int[] res = new int[intervals.length];
        for (int j = 0; j < intervals.length; j++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[j][1]);
            res[j] = entry == null ? -1 : entry.getValue();
        }
        return res;
    }

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] startIntervals = new int[len][2];
        for (int i = 0; i < len; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));
        int[] res = new int[len];
        for (int j = 0; j < len; j++) {
            int l = 0;
            int r = len - 1;
            int target = -1;
            while(l <= r) {
                int mid = l + (r - l >> 1);
                if (intervals[j][1] <= startIntervals[mid][0]) {
                    target = startIntervals[mid][1];
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res[j] = target;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 4}, {2, 3}, {3, 4}};//{-1, 2, -1}
        int[][] intervals = {{1, 1}, {2, 4}, {-2, 1}, {4,6}};//0, 3, 0, -1
        FindRightInterval findRightInterval = new FindRightInterval();
        int[] res = findRightInterval.findRightInterval(intervals);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
