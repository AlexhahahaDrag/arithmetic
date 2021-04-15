package array;

/**
 *description:  
 *author:       alex
 *createDate:   2021/4/15 21:41
 *version:      1.0.0
 */
public class Rob {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        int[] nf = new int[nums.length];
        f[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            f[i] = Math.max((i - 2 < 0 ? 0 : f[i - 2]) + (i == nums.length - 1 ? 0 : nums[i]), f[i - 1]);
            nf[i] = Math.max((i - 2 < 0 ? 0 : nf[i - 2]) + nums[i], nf[i - 1]);
        }
        return Math.max(f[nums.length - 1], nf[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Rob rob = new Rob();
        System.out.println(rob.rob(nums));
    }
}
