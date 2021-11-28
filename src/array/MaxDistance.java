package array;

import java.util.Arrays;

/**
 *description:
 * 2078. 两栋颜色不同且距离最远的房子
 * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
 *
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 *
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：colors = [1,1,1,6,1,1,1]
 * 输出：3
 * 解释：上图中，颜色 1 标识成蓝色，颜色 6 标识成红色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 3 。
 * 房子 0 的颜色是颜色 1 ，房子 3 的颜色是颜色 6 。两栋房子之间的距离是 abs(0 - 3) = 3 。
 * 注意，房子 3 和房子 6 也可以产生最佳答案。
 * 示例 2：
 *
 *
 *
 * 输入：colors = [1,8,3,8,3]
 * 输出：4
 * 解释：上图中，颜色 1 标识成蓝色，颜色 8 标识成黄色，颜色 3 标识成绿色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 4 。
 * 房子 0 的颜色是颜色 1 ，房子 4 的颜色是颜色 3 。两栋房子之间的距离是 abs(0 - 4) = 4 。
 * 示例 3：
 *
 * 输入：colors = [0,1]
 * 输出：1
 * 解释：两栋颜色不同且距离最远的房子是房子 0 和房子 1 。
 * 房子 0 的颜色是颜色 0 ，房子 1 的颜色是颜色 1 。两栋房子之间的距离是 abs(0 - 1) = 1 。
 *
 *
 * 提示：
 *
 * n == colors.length
 * 2 <= n <= 100
 * 0 <= colors[i] <= 100
 * 生成的测试数据满足 至少 存在 2 栋颜色不同的房子
 *author:       alex
 *createDate:   2021/11/23 17:11
 *version:      1.0.0
 */
public class MaxDistance {

    public int maxDistance1(int[] colors) {
        int[] e = new int[101];
        Arrays.fill(e, -1);
        int res = 0;
        for(int i = 0; i < colors.length; i++) {
            if(e[colors[i]] == -1) {
                e[colors[i]] = i;
            }
            while(i < colors.length - 1 && colors[i] == colors[i + 1]) {
                i++;
            }
            for(int j = 0; j < 101; j++) {
                if(j != colors[i] && e[j] >= 0) {
                    res = Math.max(res, i - e[j]);
                }
            }
        }
        return res;
    }

    public int maxDistance(int[] colors) {
        int c1 = colors[0];
        int c2 = colors[colors.length - 1];
        int d1 = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != c2) {
                d1 = colors.length - i - 1;
                break;
            }
        }
        int d2 = 0;
        for (int j = colors.length - 1; j >= 0; j--) {
            if (colors[j] != c1) {
                d2 = j;
                break;
            }
        }
        return Math.max(d1, d2);
    }

    public static void main(String[] args) {
        int[] colors = {1,8,3,8,3};
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.maxDistance(colors));
    }
}
