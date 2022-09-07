package array;

public class ValidPartition {

    public boolean validPartition(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        int i = 0;
        while(++i < len) {
            boolean b = dp[i - 1] && nums[i] == nums[i - 1];
            boolean c = i > 1 && dp[i - 2] &&
                    (( nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) ||
                            (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1));
            if (b || c) {
                dp[i + 1] = true;
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3};
        ValidPartition validPartition = new ValidPartition();
        System.out.println(validPartition.validPartition(nums));
    }
}
