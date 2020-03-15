package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *description:
 * 853. 车队 显示英文描述
 * 用户通过次数49
 * 用户尝试次数94
 * 通过次数49
 * 提交次数274
 * 题目难度Medium
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 *
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 *
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 *
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 *
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 *
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 *
 *
 *
 * 会有多少车队到达目的地?
 *
 *
 *
 * 示例：
 *
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * 输出：3
 * 解释：
 * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
 * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
 * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
 * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
 *
 * 提示：
 *
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * 所有车的初始位置各不相同。
 *author:       alex
 *createDate:  2020/3/14 21:08
 *version:      1.0.0      
*/
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        double[][] map = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            map[i][0] = position[i];
            double len = target - position[i];
            map[i][1] = len / speed[i];
        }
        Arrays.sort(map, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int)(o1[0] - o2[0]);
            }
        });
        int cur = position.length - 1;
        int count = 1;
        for (int i = position.length - 2; i >= 0; i--) {
            if (map[cur][1] < map[i][1]) {
                count++;
                cur = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int target = 10;
        int position[] = {2,4};
        int speed[] = {3,2};
        CarFleet carFleet = new CarFleet();
        System.out.println(carFleet.carFleet(target, position, speed));
    }
}
