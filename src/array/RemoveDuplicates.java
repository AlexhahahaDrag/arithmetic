package array;

public class RemoveDuplicates {

    public int removeDuplicates1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ) {
            nums[index++] = nums[i];
            int start = i;
            while(i < nums.length && nums[start] == nums[i]) {
                i++;
            }
            if (i == start) {
                i++;
            }
        }
        return index;
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[index] != nums[i]) {
               nums[++index] = nums[i];
           }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }
}
