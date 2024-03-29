package array;

/**
 * description:
 * 2491. 划分技能点相等的团队
 * 中等
 * 2
 * 相关企业
 * 给你一个正整数数组 skill ，数组长度为 偶数 n ，其中 skill[i] 表示第 i 个玩家的技能点。将所有玩家分成 n / 2 个 2 人团队，使每一个团队的技能点之和 相等 。
 * <p>
 * 团队的 化学反应 等于团队中玩家的技能点 乘积 。
 * <p>
 * 返回所有团队的 化学反应 之和，如果无法使每个团队的技能点之和相等，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：skill = [3,2,5,1,3,4]
 * 输出：22
 * 解释：
 * 将玩家分成 3 个团队 (1, 5), (2, 4), (3, 3) ，每个团队的技能点之和都是 6 。
 * 所有团队的化学反应之和是 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22 。
 * 示例 2：
 * <p>
 * 输入：skill = [3,4]
 * 输出：12
 * 解释：
 * 两个玩家形成一个团队，技能点之和是 7 。
 * 团队的化学反应是 3 * 4 = 12 。
 * 示例 3：
 * <p>
 * 输入：skill = [1,1,2,3]
 * 输出：-1
 * 解释：
 * 无法将玩家分成每个团队技能点都相等的若干个 2 人团队。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= skill.length <= 105
 * skill.length 是偶数
 * 1 <= skill[i] <= 1000
 * author:       majf
 * createDate:   2022/12/6 18:20
 * version:      1.0.0
 */
public class DividePlayers {

    public long dividePlayers(int[] skill) {
        int sum = 0;
        int n = skill.length;
        int[] map = new int[1001];
        int max = 0;
        for (int i : skill) {
            map[i]++;
            sum += i;
            max = Math.max(max, i);
        }
        if (sum * 2 % n != 0) {
            return -1;
        }
        int av = sum * 2 / n;
        long mul = 0;
        for (int i = max; i > 0; i--) {
            if (map[i] == 0) {
                continue;
            }
            if (map[i] != map[av - i]) {
                return -1;
            }
            mul += (long)i * (av - i) * map[av - i];
        }
        return mul >> 1;
    }

    public static void main(String[] args) {
        int[] skill = {3, 2, 5, 1, 3, 4};
        DividePlayers dividePlayers = new DividePlayers();
        System.out.println(dividePlayers.dividePlayers(skill));
    }
}
