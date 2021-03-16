import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1,2,3,3,3,3,3};
        System.out.println(removeDuplicatesArr(arr));
    }
    public static int removeDuplicatesArr(int[] nums){
        Set set=new HashSet();
        for(int i=0;i<nums.length;i++){
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        System.out.println(set);
        return set.size();
    }
}
