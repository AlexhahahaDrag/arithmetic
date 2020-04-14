package array;

/**
 *description:
 * 5381. 查询带键的排列 显示英文描述
 * 用户通过次数630
 * 用户尝试次数664
 * 通过次数630
 * 提交次数698
 * 题目难度Medium
 * 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
 *
 * 一开始，排列 P=[1,2,3,...,m]。
 * 对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。
 * 请你以数组形式返回待查数组  queries 的查询结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = [3,1,2,1], m = 5
 * 输出：[2,1,2,1]
 * 解释：待查数组 queries 处理如下：
 * 对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，接着我们把 3 移动到 P 的起始位置，得到 P=[3,1,2,4,5] 。
 * 对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,3,2,4,5] 。
 * 对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，接着我们把 2 移动到 P 的起始位置，得到 P=[2,1,3,4,5] 。
 * 对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,2,3,4,5] 。
 * 因此，返回的结果数组为 [2,1,2,1] 。
 * 示例 2：
 *
 * 输入：queries = [4,1,2,2], m = 4
 * 输出：[3,1,2,0]
 * 示例 3：
 *
 * 输入：queries = [7,5,5,8,3], m = 8
 * 输出：[6,5,0,7,5]
 *
 *
 * 提示：
 *
 * 1 <= m <= 10^3
 * 1 <= queries.length <= m
 * 1 <= queries[i] <= m
 *author:       alex
 *createDate:  2020/4/12 11:03
 *version:      1.0.0
*/
public class ProcessQueries {

    public int[] processQueries(int[] queries, int m) {
        int[] map = new int[m + 1];
        for(int i = 1; i <= m; i++)
            map[i] = i;
        int[] res = new int[queries.length];
        int start = 0;
        for(int index : queries) {
            res[start++] = map[index] - 1;
            update(map, map[index]);
            map[index] = 1;
        }
        return res;
    }

    private void update(int[] map, int index) {
        for(int i = 1; i < map.length; i++) {
            if(map[i] < index)
                map[i]++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,2};
        ProcessQueries processQueries = new ProcessQueries();
        int[] res = processQueries.processQueries(arr, 4);
        for(int i : res)
            System.out.print(i + "   ");;
    }
}
