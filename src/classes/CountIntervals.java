package classes;

/**
 *description:  6066. 统计区间中的整数数目
 * 给你区间的 空 集，请你设计并实现满足要求的数据结构：
 *
 * 新增：添加一个区间到这个区间集合中。
 * 统计：计算出现在 至少一个 区间中的整数个数。
 * 实现 CountIntervals 类：
 *
 * CountIntervals() 使用区间的空集初始化对象
 * void add(int left, int right) 添加区间 [left, right] 到区间集合之中。
 * int count() 返回出现在 至少一个 区间中的整数个数。
 * 注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。
 *
 *
 *
 * 示例 1：
 *
 * 输入
 * ["CountIntervals", "add", "add", "count", "add", "count"]
 * [[], [2, 3], [7, 10], [], [5, 8], []]
 * 输出
 * [null, null, null, 6, null, 8]
 *
 * 解释
 * CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
 * countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
 * countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
 * countIntervals.count();    // 返回 6
 *                            // 整数 2 和 3 出现在区间 [2, 3] 中
 *                            // 整数 7、8、9、10 出现在区间 [7, 10] 中
 * countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
 * countIntervals.count();    // 返回 8
 *                            // 整数 2 和 3 出现在区间 [2, 3] 中
 *                            // 整数 5 和 6 出现在区间 [5, 8] 中
 *                            // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
 *                            // 整数 9 和 10 出现在区间 [7, 10] 中
 *
 *
 * 提示：
 *
 * 1 <= left <= right <= 109
 * 最多调用  add 和 count 方法 总计 105 次
 * 调用 count 方法至少一次
 *author:       alex
 *createDate:   2022/5/15 15:15
 *version:      1.0.0
 */
public class CountIntervals {

    private boolean[] map;
    public CountIntervals() {
        map = new boolean[(int)Math.pow(10, 5) * 4];
    }

    public void add(int left, int right) {
        build(1, left, right);
    }

    public int count() {
        return dfs(1, 1, (int)Math.pow(10, 5));
    }

    private int dfs(int k, int left, int right) {
        if(map[k]) {
            return right - left + 1;
        }
        int mid = left + (right - left >> 1);
        return dfs(k * 2, left, mid) +dfs(k * 2 + 1, mid + 1, right);
    }

    private boolean build(int k, int left, int right) {
        if (map[k]) {
            return true;
        }
        if (left == right) {
            map[k] = true;
            return true;
        }
        int mid = left + (right - left >> 1);
        boolean l = build(k * 2, left, mid);
        boolean r = build(k * 2 + 1, mid + 1, right);
        map[k] = l && r;
        return l && r;
    }


    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();
        countIntervals.add(2, 3);
        countIntervals.add(7, 10);
        System.out.println(countIntervals.count());
        countIntervals.add(5, 8);
        System.out.println(countIntervals.count());
    }
}
