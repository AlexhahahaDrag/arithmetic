/**
 * 给出一个正整数数组，求组成的最小的数；
 * 例如{1,42,34}，组成最小的数是13442
 */
public class TheCombineMinNum {
    public static void main(String[] args) {
        int[] arr={1,4354,2,1,4,56,65,7,10,100};
        //冒泡排序
        for (int i = 0; i < arr.length-1; i++) {
            int b=0;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (compareNum(arr[j],arr[j+1])){
                    int a=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=a;
                    b++;
                }
            }
            if (b==0){
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    //比较两个数组成的数
    public static boolean compareNum(int num1,int num2){
        int num3=num1+num2*(int)Math.pow(10,getDigit(num1));
        int num4=num2+num1*(int)Math.pow(10,getDigit(num2));
        return num3<num4?true:false;
    }
    //求整数的位数
    public static int getDigit(int num){
        int i=0;
        while(num>0){
            num=num/10;
            i++;
        }
        return i;
    }
}
