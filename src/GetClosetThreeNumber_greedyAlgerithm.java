//任意数分三组，使得每组的和尽量相等
public class GetClosetThreeNumber_greedyAlgerithm {
    public static void main(String[] args) {
        int[] arr={3, 8, 20, 15, 60, 1, 32};
        int[] arr1=getThreeClosestNumber(arr);
        for (int i = 0; i <arr1.length ; i++) {
            System.out.println(arr1[i]);
        }

    }
    public static int[] getThreeClosestNumber(int[] arr){
        if(arr.length>3){
            int[] arr1=new int[arr.length-1];
            arr1[0]=arr[0];
            arr1[1]=arr[1];
            arr1[2]=arr[2]+arr[3];
            for (int j = 3; j < arr1.length; j++) {
                arr1[j]=arr[j+1];
            }
            getSort(arr1);
            return getThreeClosestNumber(arr1);
        }else {
            return arr;
        }
    }
    public static int[] getSort(int[] arr){
        int a=0;
        int b;
        for (int i = 0; i < arr.length-1; i++) {
            b=a;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]<arr[j+1]){
                    arr[j]=arr[j]+arr[j+1];
                    arr[j+1]=arr[j]-arr[j+1];
                    arr[j]=arr[j]-arr[j+1];
                    a++;
                }
            }
            if (b==a){
                break;
            }
        }
        return arr;
    }
}
