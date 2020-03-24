package array;

/**
 *description:
 *1390. 四因数
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 *
 * 如果数组中不存在满足题意的整数，则返回 0 。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 *author:       alex
 *createDate:  2020/3/22 10:45
 *version:      1.0.0      
*/
public class SumFourDivisors {

    int res = 0;
    public int sumFourDivisors(int[] nums) {
        if(nums == null || nums.length == 0)
            return res;
        for(int i : nums)
            getD(i);
        return res;
    }

    private void getD(int num) {
        int count = 0;
        int size = (int)Math.sqrt(num);
        int sum = 0;
        for(int i = 1; i <= size; i++) {
            if(num % i == 0 ) {
                sum += num / i;
                if (i != num / i) {
                    sum += i;
                    count++;
                }
                count++;
                if(count > 4)
                    break;
            }
        }
        if(count == 4)
            res += sum;
    }

    public static void main(String[] args) {
        int[] nums = {21, 4, 7};
        SumFourDivisors sumFourDivisors = new SumFourDivisors();
        System.out.println(sumFourDivisors.sumFourDivisors(nums));
    }
}
