package array;

import java.util.LinkedList;
import java.util.Queue;

public class TotalSteps {

    public int totalSteps(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for(int n : nums) {
            queue.add(n);
        }
        if (queue.size() < 2) {
            return 0;
        }
        int step = 0;
        int pre;
        do {
            pre = queue.size() ;
            int len = queue.size() ;
            int cur = queue.poll();
            int next = queue.poll();
            int i = 1;
            while(i < len) {
                queue.add(cur);
                if(cur > next) {
                    cur = queue.poll();
                    i += 2;
                    if(i <= len) {
                        next = queue.poll();
                    } else {
                        queue.add(cur);
                    }
                } else {
                    cur = next;
                    i++;
                    if(i < len) {
                        next = queue.poll();
                    } else {
                        queue.add(cur);
                    }
                }
            }
            if(pre > queue.size()) {
                step++;
            }
        } while(pre > queue.size() && queue.size() > 1);
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,3,4,5,6,1,2,3};//6
//        int[] nums = {5,3,4,4,7,3,6,11,8,5,11};//3
        TotalSteps totalSteps = new TotalSteps();
        System.out.println(totalSteps.totalSteps(nums));
    }
}
