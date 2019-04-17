public class CrossRiver {
    public static void main(String[] args) {
        int[] arr={1,3,6,8,12,18};
      getCrossRiverMethod(0,arr);
    }
    static void getCrossRiverMethod(int sum,int[] arr){
        if(arr.length>1){
            sum=getSum(sum,arr);
            int[] arr1=new int[arr.length-2];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i]=arr[i];
            }
            getCrossRiverMethod(sum,arr1);
        }
        if(arr.length<=1){
            System.out.println(sum);
        }
    }
    static int getSum(int sum,int[] arr){
        sum=sum+arr[0]+arr[1]+arr[arr.length-1];
        return sum;
    }
}
