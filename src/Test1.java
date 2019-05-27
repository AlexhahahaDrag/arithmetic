import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1=new Test1();
        int[] arr={2,3,6,7};
        System.out.println(test1.combinationSum(arr,7));
        /*System.out.println(test1.removeElement(arr,3));
        System.out.println(getDigits(20190324));*/
    }
    public static int getDigits(int num){
        if (num<=3)
            return 1;
        int a=1;
        int b=1;
        int c=1;
        int sum=0;
        while(num>3){
           /* sum=a+b+c;*/
           sum=(a+b+c)%10000;
            a=b;
            b=c;
            c=sum;
            num--;
        }
       return sum;
    }
    public int removeElement(int[] nums, int val) {
        int index=0;
        int end=nums.length-1;
        while(true){
            while(index<=end&&nums[index]!=val)
                index++;
            while(index<end&&nums[end]==val)
                end--;
            if (index<end){
                nums[index]=nums[index]^nums[end];
                nums[end]=nums[index]^nums[end];
                nums[index]=nums[index]^nums[end];
            }else
                break;
        }
        return index;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =new ArrayList<>();
        get(list,candidates,new LinkedList<>(),target,0);
        return list;
    }
    public void get(List<List<Integer>> list,int[] candidates,LinkedList<Integer> list1,int target,int start) {
        if (target<0)
            return;
        if (target==0){
            list.add(new ArrayList<>(list1));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target<candidates[i])
                break;
            if (i>start&&candidates[i]==candidates[start])
                continue;
            list1.add(candidates[i]);
            get(list,candidates,list1,target-candidates[i],i);
            list1.remove(list1.size()-1);
        }
    }
}
