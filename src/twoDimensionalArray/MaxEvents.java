package twoDimensionalArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 *description:
 * 5342. 最多可以参加的会议数目 显示英文描述
 * 用户通过次数226
 * 用户尝试次数937
 * 通过次数227
 * 提交次数2823
 * 题目难度Medium
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 *
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 *
 * 请你返回你可以参加的 最大 会议数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 *
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * 示例 3：
 *
 * 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：events = [[1,100000]]
 * 输出：1
 * 示例 5：
 *
 * 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 * 输出：7
 *
 *
 * 提示：
 *
 * 1 <= events.length <= 10^5
 * events[i].length == 2
 * 1 <= events[i][0] <= events[i][1] <= 10^5
 *author:       alex
 *createDate:  2020/2/16 11:25
 *version:      1.0.0
*/
public class MaxEvents {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int min = 0;
        int max = 0;
        for(int i = 0; i < events.length; i++) {
            if(min > events[i][0]) {
                min = events[i][0];
            }
            if(max < events[i][1]) {
                max = events[i][1];
            }
        }
        boolean[] map = new boolean[max - min + 1];
        for (int i = 0; i < events.length; i++) {
            for(int j = events[i][0]; j <= events[i][1]; j++) {
                if(!map[j - min]) {
                    map[j - min]  = true;
                    break;
                }
            }
        }
        int sum = 0;
        for(boolean bo : map) {
            if(bo) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxEvents maxEvents = new MaxEvents();
        int[][] events = {{1,1},{1,3},{1,2},{1,4},{1,5},{1,6},{1,7}};
        System.out.println(maxEvents.maxEvents(events));
    }
}
