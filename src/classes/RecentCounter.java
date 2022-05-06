package classes;

/**
 *description:
 * 933. 最近的请求次数
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 *
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 *
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 *
 *
 * 提示：
 *
 * 1 <= t <= 109
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 104
 *author:       alex
 *createDate:   2022/5/6 23:11
 *version:      1.0.0
 */
public class RecentCounter {

//    private Queue<Integer> quene;
//    private int limit = 3000;
//    public RecentCounter() {
//        quene = new LinkedList<>();
//    }
//
//    public int ping(int t) {
//        quene.add(t);
//        while(t - quene.peek() > limit) {
//            quene.poll();
//        }
//        return quene.size();
//    }


    private int start = 0;
    private int end = 0;
    private int len = 3003;
    private int[] map;
    public RecentCounter() {
        map = new int[len];
    }

    public int ping(int t) {
        map[end] = t;
        end = (end + 1) % len;
        while(t - map[start] > 3000) {
            start++;
            start %= len;
        }
        return (end - start + len) % len;
    }
}
