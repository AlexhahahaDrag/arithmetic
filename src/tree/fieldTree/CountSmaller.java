package tree.fieldTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：[5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 通过次数32,919提交次数79,970
 * @author:      alex
 * @createTime:  2020/8/5 14:13
 * @version:     1.0
 */
public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int min = nums[0];
        int max = nums[0];
        for(int i : nums) {
            if (min > i)
                min = i;
            if (max < i)
                max = i;
        }
        int[] map = new int[max - min + 1 << 1];
        for(int j : nums) {
            build(j - min, map);
        }
        return res;
    }

    private void build(int j, int[] map) {
        while(j >= 0) {
            map[j]++;
            j = j - 1 >> 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        CountSmaller countSmaller = new CountSmaller();
        System.out.println(countSmaller.countSmaller(nums));
    }
}
