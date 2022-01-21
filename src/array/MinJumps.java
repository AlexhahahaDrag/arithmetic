package array;

import java.util.*;

/**
 *description:
 * 1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标：
 *
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 *
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 *
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 示例 4：
 *
 * 输入：arr = [6,1,9]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 *author:       alex
 *createDate:   2022/1/21 14:09
 *version:      1.0.0
 */
public class MinJumps {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        for (int i = 0; i < arr.length; i++) {
            list = map.get(arr[i]);
            if (list == null) {
                list = new LinkedList<>();
                map.put(arr[i], list);
            }
            list.add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 0;
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int size;
        Integer cur;
        while(!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur == arr.length - 1) {
                    return step;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    queue.add(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < arr.length && !visited[cur + 1]) {
                    queue.add(cur + 1);
                    visited[cur + 1] = true;
                }
                if (map.get(arr[cur])  != null) {
                    queue.addAll(map.get(arr[cur]));
                    map.remove(arr[cur]);
                }
            }
            step++;
        }
        return -1;
    }
    public int minJumps1(int[] arr) {
        // Store a number and all positions
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            // For continuous numbers, only store its starting pos and end pos
            if (i > 0 && i < arr.length - 1 && arr[i] == arr[i - 1] && arr[i] == arr[i + 1]) {
                continue;
            }
            map.get(arr[i]).add(i);
        }

        // BFS
        Queue<Integer> queue = new LinkedList(){{add(0);}};

        int step = 0;
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                if (pos == arr.length - 1) {
                    return step;
                }
                // Add all next possible positions to queue
                if (pos - 1 >= 0 && !visited[pos - 1]) {
                    queue.add(pos - 1);
                    visited[pos - 1] = true;
                }

                if (pos + 1 < arr.length && !visited[pos + 1]) {
                    if (pos + 1 == arr.length - 1) {
                        return step + 1;
                    }
                    queue.add(pos + 1);
                    visited[pos + 1] = true;
                }

                ArrayList<Integer> posWithSameValue = map.get(arr[pos]);
                for (int length = posWithSameValue.size(), j = length - 1; j >= 0; j--) {
                    if (posWithSameValue.get(j) == arr.length - 1) {
                        return step + 1;
                    }
                    if (!visited[posWithSameValue.get(j)]) {
                        queue.add(posWithSameValue.get(j));
                        visited[posWithSameValue.get(j)] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};//3
//        int[] arr = {6,1,9};//2
//        int[] arr = {11,22,7,7,7,7,7,7,7,22,13};//3
//        int[] arr = {-76,3,66,-32,64,2,-19,-8,-5,-93,80,-5,-76,-78,64,2,16};//5
//        int[] arr = {68,-94,-44,-18,-1,18,-87,29,-6,-87,-27,37,-57,7,18,68,-59,29,7,53,-27,-59,18,-1,18,-18,-59,-1,-18,-84,-20,7,7,-87,-18,-84,-20,-27};//5
        int arr[] = {51,64,-15,58,98,31,48,72,78,-63,92,-5,64,-64,51,-48,64,48,-76,-86,-5,-64,-86,-47,92,-41,58,72,31,78,-15,-76,72,-5,-97,98,78,-97,-41,-47,
                -86,-97,78,-97,58,-41,72,-41,72,-25,-76,51,-86,-65,78,-63,72,-15,48,-15,-63,-65,31,-41,95,51,-47,51,-41,-76,58,-81,-41,88,58,-81,88,88,-47,-48,
                72,-25,-86,-41,-86,-64,-15,-63};//4
//        int[] arr = {7};
        MinJumps minJumps = new MinJumps();
        System.out.println(minJumps.minJumps(arr));
    }
}
