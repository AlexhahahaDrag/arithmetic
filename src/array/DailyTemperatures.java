package array;

/**
 * Description:
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * Author:      alex
 * CreateDate:  2020/6/11 12:40
 * Version:     1.0
 *
*/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] map = new int[T.length];
        int size = 0;
        for(int i = 1; i < T.length; i++) {
            while(size >= 0 && T[map[size]] < T[i]) {
                T[map[size]] = i - map[size];
                size--;
            }
            map[++size] = i;
        }
        while(size >= 0)
            T[map[size--]] = 0;
        return T;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] res = dailyTemperatures.dailyTemperatures(T);
        for(int i : res)
            System.out.print(i + "  ");
    }
}
