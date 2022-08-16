package twoDimensionalArray;

import java.util.*;

public class ReachableNodes {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] visited = new boolean[n];
        for (int i : restricted) {
            visited[i] = true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] j : edges) {
            if (visited[j[0]] || visited[j[1]]) {
                continue;
            }
            List<Integer> cur = map.get(j[1]);
            if (cur == null) {
                cur = new ArrayList<>();
                map.put(j[1], cur);
            }
            cur.add(j[0]);
            List<Integer> cur1 = map.get(j[0]);
            if (cur1 == null) {
                cur1 = new ArrayList<>();
                map.put(j[0], cur1);
            }
            cur1.add(j[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int res = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) {
                continue;
            }
            List<Integer> cl = map.get(cur);
            if (cl != null) {
                queue.addAll(cl);
                res++;
                visited[cur] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}};
        int[] restricted = {2, 7};
        ReachableNodes reachableNodes = new ReachableNodes();
        System.out.println(reachableNodes.reachableNodes(n, edges, restricted));
    }
}
