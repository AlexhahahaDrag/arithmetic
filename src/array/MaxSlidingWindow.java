package array;

import java.util.LinkedList;

/**
 * @description:
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xatgye/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author:      alex
 * @createTime:  2020/8/18 17:20
 * @version:     1.0
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow1(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] map = new int[nums.length - k + 1];
        for(int i = 0; i < k && i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.add(i);
        }
        for(int i = 0; i < map.length; i++) {
            while(queue.getFirst() < i) {
                queue.removeFirst();
            }
            map[i] = nums[queue.getFirst()];
            if (i + k < nums.length) {
                while(!queue.isEmpty() && nums[queue.getLast()] < nums[i + k]) {
                    queue.removeLast();
                }
                queue.add(i + k);
            }
        }
        return map;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int[] path = new int[nums.length];
        int index = -1;
        int start = -1;
        for(int i = 0; i < k; i++) {
            while(index > start && nums[i] >= nums[path[index]]) {
                index--;
            }
            path[++index] = i;
        }
        for(int i = k - 1; i < nums.length; i++) {
            while(index > start && nums[i] >= nums[path[index]]) {
                index--;
            }
            path[++index] = i;
            if (i - k >= path[start + 1]) {
                start++;
            }
            res[i - k + 1] = nums[path[start + 1]];
        }
        return res;
    }

    public static void main(String[] args) {
//       int[] nums = {7, 2, 4};
//        int k = 2;
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
       /* int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;*/
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] res = maxSlidingWindow.maxSlidingWindow(nums, k);;
        for(int i : res) {
            System.out.print(i + "      ");
        }
    }
}
