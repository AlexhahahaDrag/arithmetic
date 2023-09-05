package list;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 539. 最小时间差
 * 中等
 * 247
 * 相关企业
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 * 通过次数
 * 64.8K
 * 提交次数
 * 98.4K
 * 通过率
 * 65.9%
 * @author:       majf
 * @createDate:   2023/9/5 17:52
 * @version:      1.0.0
 */
public class FindMinDifference {

    public int findMinDifference1(List<String> timePoints) {
        int len = timePoints.size();
        int[] cur = new int[len + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            String[] s = timePoints.get(i).split(":");
            cur[i] = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            min = Math.min(min, cur[i]);
        }
        cur[len] = min + 24 * 60;
        Arrays.sort(cur);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, cur[i + 1] - cur[i]);
        }
        return res;
    }

    public int findMinDifference(List<String> timePoints) {
        int len = 24 * 60;
        if (len < timePoints.size()) {
            return 0;
        }
        boolean[] map = new boolean[len];
        for (String time : timePoints) {
            int c = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            if (map[c]) {
                return 0;
            }
            map[c] = true;
        }
        int start = -1;
        int end = -1;
        int res = len;
        for (int i = 0; i < len; i++) {
            if (!map[i]) {
                continue;
            }
            if (start == -1) {
                start = i;
            } else {
                res = Math.min(res, i - end);
            }
            end = i;
        }
        return Math.min(res, start + len - end);
    }

    public static void main(String[] args) {
        String[] arr = {"00:05","23:59","00:00"};
        List<String> timPoints = Arrays.asList(arr);
        FindMinDifference findMinDifference = new FindMinDifference();
        System.out.println(findMinDifference.findMinDifference(timPoints));
    }
}
