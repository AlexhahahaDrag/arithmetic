package array;

/**
 *description:
 * 6010. 完成旅途的最少时间
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 *
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。
 *
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：time = [1,2,3], totalTrips = 5
 * 输出：3
 * 解释：
 * - 时刻 t = 1 ，每辆公交车完成的旅途数分别为 [1,0,0] 。
 *   已完成的总旅途数为 1 + 0 + 0 = 1 。
 * - 时刻 t = 2 ，每辆公交车完成的旅途数分别为 [2,1,0] 。
 *   已完成的总旅途数为 2 + 1 + 0 = 3 。
 * - 时刻 t = 3 ，每辆公交车完成的旅途数分别为 [3,1,1] 。
 *   已完成的总旅途数为 3 + 1 + 1 = 5 。
 * 所以总共完成至少 5 趟旅途的最少时间为 3 。
 * 示例 2：
 *
 * 输入：time = [2], totalTrips = 1
 * 输出：2
 * 解释：
 * 只有一辆公交车，它将在时刻 t = 2 完成第一趟旅途。
 * 所以完成 1 趟旅途的最少时间为 2 。
 * 提示：
 *
 * 1 <= time.length <= 105
 * 1 <= time[i], totalTrips <= 107
 *author:       alex
 *createDate:   2022/2/27 13:50
 *version:      1.0.0
 */
public class MinimumTime {

    public long minimumTime(int[] time, int to) {
        if (time.length == 1) {
            return (long)time[0] * to;
        }
        long min = time[0];
        for (int i = 1; i < time.length; i++) {
            min = Math.min(min, time[i]);
        }
        long curC;
        long mid;
        long common = min * to;
        while(min < common) {
            curC = 0;
            mid = min + (common - min >> 1);
            for(int t : time) {
                curC += mid / (long)t;
            }
            if(curC >= to) {
                common = mid;
            } else {
                min = mid + 1;
            }
        }
        return common;
    }

    public static void main(String[] args) {
//        int[] time = {1, 2, 3};
//        int to = 5; //3
//        int[] time = {2};
//        int to = 1; //2
//        int[] time = {5, 10, 10};
//        int to = 9; //3
//        int[] time = {39,82,69,37,78,14,93,36,66,61,13,58,57,12,70,14,67,75,91,1,34,68,73,50,13,40,81,21,79,12,35,18,71,43,5,50,37,16,15,6,61,7,87,43,27,62,95,45,82,100,15,74,33,95,38,88,91,47,22,82,51,19,10,24,87,38,5,91,10,36,56,86,48,92,10,26,63,2,50,88,9,83,20,42,59,55,8,15,48,25};
//        int to = 4187; //858
//        int[] time = {98,26,57,84,47,4,34,54,75,25,27,72,31,44,14,32,11,95,82,28,94,83,98,45,34,12,62,37,96,29,61,46,43,96,81,8,97,96,40,81};
//        int to =5189;//3912
        int[] time = {10000};
        int to = 10000000;
        System.out.println(100000000000l);
        System.out.println(Long.MAX_VALUE);
        MinimumTime minimumTime = new MinimumTime();
        System.out.println(minimumTime.minimumTime(time, to));
    }
}
