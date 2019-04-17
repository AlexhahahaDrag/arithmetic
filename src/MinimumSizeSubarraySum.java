public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums={1,4,4};
        System.out.println(minSubArrayLen(4,nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        long sum=0;
        int left=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(left<nums.length&&sum>=s){
                ans=Math.min(ans,i-left+1);
                sum-=nums[left++];
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
