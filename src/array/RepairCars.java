package array;

/**
 * @description: 2594. 修车的最少时间
 * 提示
 * 中等
 * 74
 * 相关企业
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 * <p>
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 * <p>
 * 请你返回修理所有汽车 最少 需要多少时间。
 * <p>
 * 注意：所有机械工可以同时修理汽车。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 * 示例 2：
 * <p>
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranks.length <= 105
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 106
 * @author: majf
 * @createDate: 2023/9/7 9:51
 * @version: 1.0.0
 */
public class RepairCars {

    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        int max = 0;
        for (int i : ranks) {
            max = Math.max(max, i);
        }
        int[] seq = new int[max + 1];
        for (int i : ranks) {
            seq[i]++;
        }
        long r = (long) max * cars * cars;
        while (l < r) {
            long mid = l + (r - l >> 1);
            if (check(mid, cars, seq)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(long mid, int cars, int[] seq) {
        long num = 0;
        for (int i = 1; i < seq.length; i++) {
            if (seq[i] == 0) {
                continue;
            }
            num += seq[i] * (long) Math.sqrt(mid / i);
            if (num >= cars) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ranks = {5, 1, 8};
        int cars = 6;
        RepairCars repairCars = new RepairCars();
        System.out.println(repairCars.repairCars(ranks, cars));
    }
}
