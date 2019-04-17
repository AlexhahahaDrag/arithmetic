
public class TheClosestNumber {
    public static void main(String[] args) {
        int num=1;
        System.out.println(getTheClosestNumber(num));
    }
    static long getTheClosestNumber(int num){
        int num1=num;
        int i=0;
        while(num>0){
            num=num/10;
            i++;
        }
        int[] arr1=new int[i+1];
        int num2=num1;
        int j=0;
        while(num2>0){
            arr1[j]=num2%10;
            num2=num2/10;
            j++;
        }
        int a=zero(arr1);
       if(a==0){
           int b=nine(arr1,1);
           if(b==0){
               arr1[0]=arr1[0]-1;
               arr1[1]=arr1[1]+1;
           }else{
               int c=arr1[b];
               arr1[b]=arr1[0]-1;
               arr1[0]=c;
               arr1[b+1]=arr1[b+1]+1;
           }
       }else{
           int b=nine(arr1,a);
           if(b==0){
               int c=arr1[0];
               arr1[0]=arr1[a]-1;
               arr1[a]=c;
               arr1[a+1]=arr1[a+1]+1;
           }else{
               int d=0;
               for(int l=0;l<a&&l<b;l++){
                   int c=arr1[l];
                   arr1[l]=arr1[a+b-l-1];
                   arr1[a+b-l-1]=c;
                   d++;
               }
               arr1[d-1]=arr1[d-1]-1;
               arr1[a+b]=arr1[a+b]+1;
           }
       }
        num=arrToNumber(arr1);
        return num;
    }
    //将数组转化为数字
    static int arrToNumber(int[] arr){
        int num=0;
        for (int i = 0; i < arr.length; i++) {
            num+=arr[i]*Math.pow(10,i);
        }
        return num;
    }
    //判断0的个数
    static int zero(int[] arr){
        int i=0;
        for (int k=0;k<arr.length;k++){
            if(arr[k]==0){
             i++;
            }
            if(i!=(k+1)){
                break;
            }
        }
        return i;
    }
    //判断九的个数
    static int nine(int[] arr,int j){
        int i=0;
        for (int k=j;k<arr.length;k++){
            if(arr[k]==9){
                i++;
            }
            if(i!=(k+1-j)){
                break;
            }
        }
        return i;
    }
}
