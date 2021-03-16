package math;

/**
 *description:
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *author:       alex
 *createDate:  2019/12/23 21:23
 *version:      1.0.0      
*/
public class TotalHammingDistance {
    public int totalHammingDistance1(int[] nums) {
        int sum = 0;
        for(int i = 0; i <nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                sum += hamming(nums[i], nums[j]);
            }
        }
        return sum;
    }

    private int hamming(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while(num > 0) {
            if((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    public int totalHammingDistance(int[] nums) {
        int[] map = new int[32];
        int len = nums.length;
        for (int num : nums) {
            int i = 0;
            while(num > 0) {
                map[i] += num & 0x1;
                i++;
                num >>= 1;
            }
        }
        int sum = 0;
        for(int i : map) {
            sum += i * (len - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        TotalHammingDistance totalHammingDistance = new TotalHammingDistance();
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance.totalHammingDistance(nums));
    }
}
