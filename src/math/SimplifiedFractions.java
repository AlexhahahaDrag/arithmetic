package math;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *description:
 * 1447. 最简分数
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 *
 * 输入：n = 1
 * 输出：[]
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 *author:       alex
 *createDate:   2022/2/10 14:42
 *version:      1.0.0
 */
public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        if (n <= 1) {
            return new ArrayList<>();
        }
        boolean[] map;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            map = new boolean[n + 1];
            for (int j = i + 1; j <= n; j++) {
                if (!map[j] && gcd(i, j) == 1) {
                    list.add(i + "/" + j);
                }
                for (int k = 1; k * j * i <= n; k++) {
                    map[k * j * i] = true;
                }
            }
        }
        return list;
    }

    public List<String> simplifiedFractions1(int n) {
        if (n <= 1) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    list.add(i + "/" + j);
                }
            }
        }
        return list;
    }

    private int gcd(int i, int j) {
        return j % i == 0 ? i : gcd(j % i, i);
    }

    public static void main(String[] args) {
        int n = 5000;
        SimplifiedFractions simplifiedFractions = new SimplifiedFractions();
        System.out.println(LocalDateTime.now());
        simplifiedFractions.simplifiedFractions(n);
        System.out.println(LocalDateTime.now());
        simplifiedFractions.simplifiedFractions1(n);
        System.out.println(LocalDateTime.now());
    }
}
