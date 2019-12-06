package array;

/**
 * @Description:
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @Author:     alex
 * @CreateDate: 2019/12/6 10:28
 * @Version:    1.0
 *
*/
public class ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int min = nums[0];
        int max = nums[0];
        for(int i : nums) {
            if (min > i)
                min = i;
            if(max < i)
                max = i;
        }
        int[] map = new int[max - min + 1];
        for(int i : nums) {
            if (map[i - min] != 0)
                return true;
            map[i - min]++;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate containDuplicate = new ContainDuplicate();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containDuplicate.containsDuplicate(nums));
    }
}
