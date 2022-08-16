package array;

import java.util.HashMap;
import java.util.Map;

public class ClosestMeetingNode {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int cur = node1;
        while(cur != -1 && map.get(cur) == null) {
            if (cur == node2) {
                int cl = 0;
                while(cur != node1) {
                    if (cur == -1) {
                        return node2;
                    }
                    cur = edges[cur];
                    cl++;
                }
                if (cl > len) {
                    return node2;
                } else if (cl < len) {
                    return node1;
                } else {
                    return node1 > node2 ? node2 : node1;
                }
            }
            map.put(cur, len++);
            cur = edges[cur];
        }
        len = 0;
        cur = node2;
        int res = -1;
        int l = Integer.MAX_VALUE;
        Map<Integer, Integer> map1 = new HashMap<>();
        while(cur != -1 && map1.get(cur) == null) {
            if (map.get(cur) != null) {
                int cl = Math.max(map.get(cur), len);
                if (l > cl) {
                    l = cl;
                    res = cur;
                } else if (l == cl) {
                    res = Math.min(res, cur);
                }
            }
            map1.put(cur, len++);
            cur = edges[cur];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] edges = {1,2,-1};
//        int node1 = 0;
//        int node2 = 2;//2
//        int[] edges = {2, 2, 3, -1};
//        int node1 = 0;
//        int node2 = 1;//2

        int[] edges = {5, 3, 1, 0, 2, 4, 5};
        int node1 = 3;
        int node2 = 2;//3;
//        int[] edges = {2, 0, 0};
//        int node1 = 2;
//        int node2 = 0;//0
//        int[] edges = {4,4,8,-1,9,8,4,4,1,1};
//        int node1 = 5;
//        int node2 = 6;//1
        ClosestMeetingNode closestMeetingNode = new ClosestMeetingNode();
        System.out.println(closestMeetingNode.closestMeetingNode(edges, node1, node2));
    }
}
