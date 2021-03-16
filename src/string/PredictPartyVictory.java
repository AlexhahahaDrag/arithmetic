package string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 
 * @author:      alex
 * @createTime:  2020/12/11 9:21
 * @version:     1.0
 */
public class PredictPartyVictory {

    public String predictPartyVictory(String senate) {
        int len = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (senate.charAt(i) == 'D') {
                d.offer(i);
            } else {
                r.offer(i);
            }
        }
        while(!r.isEmpty() && !d.isEmpty()) {
            int rl = r.poll();
            int dl = d.poll();
            if (rl < dl) {
                r.offer(rl + len);
            } else {
                d.offer(dl + len);
            }
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String senate = "RDDRD";
        PredictPartyVictory predictPartyVictory = new PredictPartyVictory();
        System.out.println(predictPartyVictory.predictPartyVictory(senate));
    }
}
