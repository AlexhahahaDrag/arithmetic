package array;

/**
 *description:
 * 506. 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 *
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 *
 * 提示：
 *
 * n == score.length
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * score 中的所有值 互不相同
 *author:       alex
 *createDate:   2021/12/2 11:03
 *version:      1.0.0
 */
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : score) {
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }
        int[] map = new int[max - min + 1];
        for (int i = 0; i < score.length; i++) {
            map[score[i] - min] = i + 1;
        }
        String[] res = new String[score.length];
        int count = 1;
        for (int j = map.length - 1; j >= 0; j--) {
            if (map[j] != 0) {
                switch (count) {
                    case 1:
                        res[map[j] - 1] = "Gold Medal";
                        break;
                    case 2:
                        res[map[j] - 1] = "Silver Medal";
                        break;
                    case 3:
                        res[map[j] - 1] = "Bronze Medal";
                        break;
                    default:
                        res[map[j] - 1] = count + "";
                }
                count++;
            }
        }
        return res;
    }

    public String[] findRelativeRanks2(int[] score) {
        int len=score.length;
        String [] rank = new String[len];
        int max=0;
        for(int i=0;i<len;++i)
        {
            max=Math.max(max,score[i]);
        }
        int[] a=new int[max+1];
        for(int i=0;i<len;++i)
        {
            a[score[i]]=i+1;
        }
        int count=1;
        for(int i=max;i>=0;--i)
        {
            if(a[i]!=0)
            {
                switch(count)
                {
                    case 1:
                        rank[a[i]-1]="Gold Medal";
                        break;
                    case 2:
                        rank[a[i]-1]="Silver Medal";
                        break;
                    case 3:
                        rank[a[i]-1]="Bronze Medal";
                        break;
                    default:
                        rank[a[i]-1]=Integer.toString(count);
                        break;
                }
                count++;
            }
        }
        return rank;
    }

    public static void main(String[] args) {
//        int[] score = {10,3,8,9,4};
        int[] score = {5, 4, 3, 2, 1};
        FindRelativeRanks findRelativeRanks = new FindRelativeRanks();
        String[] res = findRelativeRanks.findRelativeRanks(score);
        for(String s : res) {
            System.out.print(s + ",");
        }
    }
}
