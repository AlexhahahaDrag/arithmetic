package classes;

import java.util.Random;

/**
 *description:
 * 提交记录
 * 398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 示例:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 *
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 *author:       alex
 *createDate:   2022/4/25 6:49
 *version:      1.0.0
 */
public class Pick {

    private int[] res;
    Random random;
    public Pick(int[] nums) {
        res = nums;
        random = new Random();
    }

    public int pick(int target) {
        int index = 0;
        int cnt = 0;
        //水塘抽样法
        for(int i = 0; i < res.length; i++) {
            if (target == res[i]) {
                cnt++;
                if(random.nextInt(cnt) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3};
        Pick pick = new Pick(nums);
        System.out.println(pick.pick(3));
    }
}
