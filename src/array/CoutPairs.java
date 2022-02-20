package array;

public class CoutPairs {

    public long coutPairs(int[] nums, int k) {
        int sum = 0;
        int re = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] % k == 0) {
                re++;
                sum += len - re;
            }
        }
        return sum;
    }

    public long coutPairs1(int[] nums, int k) {
        long sum = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] * nums[j] % k == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        int nums = {};
        int k = ;
        CoutPairs coutPairs = new CoutPairs();
        System.out.println(coutPairs.coutPairs(nums, k));
    }
}
