package array;

/**
 * @description:
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 *
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 * @author:      alex
 * @createTime:  2020/9/30 13:59
 * @version:     1.0
 */
public class NumPairsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        for(int i = 0; i < time.length; i++)
            map[time[i] % 60]++;
        int count =  map[0] * (map[0] - 1) / 2 + map[30] * (map[30] - 1) / 2;
        for(int i = 1; i < 30; i++)
            count += map[i] * map[60 - i];
        return count;
    }

    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};
        NumPairsDivisibleBy60 numPairsDivisibleBy60 = new NumPairsDivisibleBy60();
        System.out.println(numPairsDivisibleBy60.numPairsDivisibleBy60(time));
    }
}
