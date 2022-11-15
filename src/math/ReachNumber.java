package math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/11/4 7:19
 * @version: 1.0.0
 */
public class ReachNumber {

    public int reachNumber1(int target) {
        if(target == 0) {
            return 0;
        }
        int cur = 0;
        int mv = 1;
        int step = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                cur = queue.poll();
                if (cur + mv == target || cur -mv == target) {
                    return step;
                }
                queue.add(cur + mv);
                queue.add(cur - mv);
            }
            mv++;
            step++;
        }
        return -1;
    }

    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while(target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static void main(String[] args) {
        int target = 2;
        ReachNumber reachNumber = new ReachNumber();
        System.out.println(reachNumber.reachNumber(target));
        System.out.println(reachNumber.reachNumber1(target));
    }
}
