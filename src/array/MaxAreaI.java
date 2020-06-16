package array;

/**
 * Description:
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * Author:      alex
 * CreateDate:  2020/6/16 18:48
 * Version:     1.0
 *
*/
public class MaxAreaI {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int left_max = height[0];
        int right_max = height[right];
        int max = 0;
        int cur;
        while(left < right) {
            if (height[left] < height[right]) {
                cur = height[left] * (right - left);
                max = Math.max(max, cur);
                while(left < right && height[left] <= left_max)
                    left++;
                left_max = height[left];
            } else {
                cur = height[right] * (right - left);
                max = Math.max(max, cur);
                while(left < right && height[right] <= right_max)
                    right--;
                right_max = height[right];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,8,3,7};
        MaxAreaI maxAreaI = new MaxAreaI();
        System.out.println(maxAreaI.maxArea(height));
    }
}
