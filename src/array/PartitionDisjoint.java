package array;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/10/24 8:04
 * @version: 1.0.0
 */
public class PartitionDisjoint {

    public int partitionDisjoint1(int[] nums) {
        int i = 0;
        int len = nums.length;
        int start = 0;
        while(++i < len) {
            while(i < len && nums[start] > nums[i]) {
                i++;
            }
            if (judge(nums, start, i)) {
                return i;
            }
            start = i;
        }
        return start + 1;
    }

    private boolean judge(int[] nums, int start, int i) {
        for(int j = i; j < nums.length; j++) {
            if(nums[j] < nums[start]) {
                return false;
            }
        }
        return true;
    }

    public int partitionDisjoint(int[] nums) {
        int i = -1;
        int leftMax = nums[0];
        int next = nums[0];
        int index = 0;
        while(++i < nums.length) {
            if (nums[i] < leftMax) {
                leftMax = next;
                index = i;
            } else {
                next = Math.max(next, nums[i]);
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 6, 12};
        PartitionDisjoint partitionDisjoint = new PartitionDisjoint();
        System.out.println(partitionDisjoint.partitionDisjoint(nums));
        System.out.println(partitionDisjoint.partitionDisjoint1(nums));
    }
}
