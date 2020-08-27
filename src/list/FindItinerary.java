package list;

import java.util.*;

/**
 * @description:
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * @author:      alex
 * @createTime:  2020/8/27 15:41
 * @version:     1.0
 */
public class FindItinerary {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> list : tickets) {
            String from = list.get(0);
            String to = list.get(1);
            if (!map.containsKey(from)) {
                PriorityQueue<String> priorityQueue = new PriorityQueue<>();
                map.put(from, priorityQueue);
            }
            map.get(from).add(to);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String from) {
        while(map.get(from) != null && map.get(from).size() > 0) {
            String to = map.get(from).poll();
            dfs(to);
        }
        res.add(from);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        String[] arr1 = {"JFK","KUL"};
        String[] arr2 = {"JFK","NRT"};
        String[] arr3 = {"NRT","JFK"};
        tickets.add(Arrays.asList(arr1));
        tickets.add(Arrays.asList(arr2));
        tickets.add(Arrays.asList(arr3));
        /*String[] arr1 = {"JFK","SFO"};
        String[] arr2 = {"JFK","ATL"};
        String[] arr3 = {"SFO","ATL"};
        String[] arr4 = {"ATL","JFK"};
        String[] arr5 = {"ATL","SFO"};
        tickets.add(Arrays.asList(arr1));
        tickets.add(Arrays.asList(arr2));
        tickets.add(Arrays.asList(arr3));
        tickets.add(Arrays.asList(arr4));
        tickets.add(Arrays.asList(arr5));*/
        FindItinerary findItinerary = new FindItinerary();
        System.out.println(findItinerary.findItinerary(tickets));
    }
}
