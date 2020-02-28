package array;

/**
 *description:
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *author:       alex
 *createDate:  2020/2/27 16:09
 *version:      1.0.0
*/
public class Trap {

    public int trap1(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int left = 0;
        while(left < height.length - 1 && height[left] < height[left + 1])
            left++;
        int right = height.length - 1;
        while(right > 0 && height[right] < height[right - 1])
            right--;
        int res = 0;
        int index = left;
        int sum = 0;
        while(index < right) {
            if (height[left] <= height[index]) {
                left = index;
                res += sum;
                sum = 0;
            } else
                sum += height[left] - height[index];
            index++;
        }
        index = right;
        sum = 0;
        while(index > left) {
            if (height[right] <= height[index]) {
                right = index;
                res += sum;
                sum = 0;
            } else
                sum += height[right] - height[index];
            index--;
        }
        int less = Math.min(height[left], height[right]);
        for (int i = left + 1; i < right; i++)
            res += less - height[i];
        return res;
    }

    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int leftMax = height[i];
        int rightMax = height[j];
        int res = 0;
        while(i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (height[i] < height[j])
                res += leftMax - height[i++];
            else
                res += rightMax - height[j--];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        Trap trap = new Trap();
        System.out.println(trap.trap(heights));
    }
}
