package array;

/**
 *description:
 *author:       alex
 *createDate:   2021/9/20 22:44
 *version:      1.0.0
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[][] res = new int[nums.length][2];
        res[0][0] = 1;
        res[0][1] = 1;
        int nu = 0;
        int max = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    res[i][0] = Math.max(res[i][0], res[j][0]);
                    if(res[j][1] == 1) {
                        nu = i + 1;
                        break;
                    }
                    nu++;
                }
            }
            res[i][0] += 1;
            max = Math.max(max, res[i][0]);
            if(nu == i + 1) {
                res[i][1] = 1;
            }
            nu = 0;
        }
        int count = 0;
        for(int[] i : res) {
            if(i[0] == max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[]  nums = {1,3,5,4,7};
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        System.out.println(findNumberOfLIS.findNumberOfLIS(nums));
    }
}
