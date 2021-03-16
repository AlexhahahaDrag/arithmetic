package array;

/**
 * Description:
 *5297. 跳跃游戏 III
 *
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/30 17:44
 * Version:     1.0
 *
*/
public class CanReach {

    public boolean canReach(int[] arr, int start) {
        boolean[] map = new boolean[arr.length];
        return reach(arr, start, map);
    }

    private boolean reach(int[] arr, int start, boolean[] map) {
        if (start < 0 || start >= arr.length || map[start]) {
            return false;
        }
        map[start] = true;
        if (arr[start] == 0) {
            return true;
        } else {
            return reach(arr, start + arr[start], map) || reach(arr, start - arr[start], map);
        }
    }

    public static void main(String[] args) {
        CanReach canReach = new CanReach();
        int[] arr = {4,2,3,0,3,1,2};
        System.out.println(canReach.canReach(arr, 0));
    }
}
