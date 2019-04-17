/**
 * @Description: Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * @Author:      alex
 * @CreateDate:  2019/1/23 14:53
 * @param
 * @return
*/
public class LargestNumber {
    public static void main(String[] args) {
        int nums[]={0,9,8,7,6,5,44,44};
        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums){
        if (nums.length==0)
            return "";
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            for (int j = 0; j < nums.length-1-i; j++) {
                if (getMin(nums[j],nums[j+1])){
                    int a=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=a;
                    count++;
                }
            }
            if (count==0)
                break;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int k = 0; k < nums.length; k++) {
            if (nums[0]==0){
                return "0";
            }
            stringBuilder.append(nums[k]);
        }
        return stringBuilder.toString();
    }
    //开销大
    public static boolean getMin(int x,int y){
        String xString=x+""+y;
        String yString=y+""+x;
        return Long.valueOf(xString)>Long.valueOf(yString)?false:true;
    }
    //开销小
    public static boolean getMin1(int x,int y){
        int a=x;
        int b=y;
        int countX=0;
        int countY=0;
        while(a>0){
            countX++;
            a/=10;
        }
        while(b>0){
            countY++;
            b/=10;
        }
        if (x==0)
            countX=1;
        if (y==0)
            countY=1;
        return x+y*Math.pow(10,countX)>y+x*Math.pow(10,countY)?true:false;
    }
}
