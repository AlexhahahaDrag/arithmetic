package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * 面试题 17.08. 马戏团人塔
 * 难度
 * 中等
 *
 * 39
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * 示例：
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * 提示：
 * height.length == weight.length <= 10000
 * @author:      alex
 * @createTime:  2020/7/24 12:38
 * @version:     1.0
 */
public class BestSeqAtIndex {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i)
            person[i] = new int[]{height[i], weight[i]};
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; ++i) {
            int max_val = 0, base_weight = person[i][1];
            for (int j = i - 1; j >= 0 && j >= max_val; --j)
                if (base_weight > person[j][1])
                    max_val = Math.max(max_val, dp[j]);
            dp[i] = max_val + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {2868,5485,1356,1306,6017,8941,7535,4941,6331,6181};
        int[] weight = {5042,3995,7985,1651,5991,7036,9391,428,7561,8594};
//        int[] height = {65,70,56,75,60,68};
//        int[] weight = {100,150,90,190,95,110};
        BestSeqAtIndex bestSeqAtIndex = new BestSeqAtIndex();
        System.out.println(bestSeqAtIndex.bestSeqAtIndex(height, weight));
    }
}
