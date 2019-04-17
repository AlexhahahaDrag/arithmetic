//求最大子序列
public class maxSubSum1 {
    public static void main(String[] args) {
        int[] arr={2,11,-4,13,-2,-5,2,7};
        System.out.println(getMinSubNum(arr));
    }
    public static int getMinSubNum(int arr[]){
        int minSum=arr[0];
        int thisSum=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>0){
                thisSum+=arr[i];
                if (thisSum<minSum)
                    minSum=thisSum;
                else if (thisSum>0)
                    thisSum=0;
            }
        }
        return minSum;
    }
    public static int getMaxSubSum4(int arr[]){
        int maxSum=arr[0];
        int thisSum=0;
        for (int i = 0; i < arr.length; i++) {
            thisSum+=arr[i];
            if (thisSum>maxSum){
                maxSum=thisSum;
            }else if (thisSum<0){
                thisSum=0;
            }
        }
        return maxSum;
    }
    //divide and conquer algorithm
    public static int getMaxSubSum3(int[] arr){
        return getMaxSunRec(arr,0,arr.length-1);
    }
    public static int max(int num1,int num2,int num3){
        if (num1>num2){
            if (num1>num3){
                return num1;
            }else {
                return num3;
            }
        }else if (num2>num3){
            return num2;
        }else{
            return num3;
        }
    }
    public static int getMaxSunRec(int[] arr,int left,int right){
        if (left==right){
            if (arr[left]>0)
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                return arr[left];
            else
                return 0;
        }
        int center =(left+right)/2;
        int maxLeftSum=getMaxSunRec(arr,left,center);
        int maxRightSum=getMaxSunRec(arr,center+1,right);
        int maxLeftBorderSum=0;
        int maxRightBorderSum=0;
        int leftBorder=0;
        int mightBorder=0;
        for (int i = center; i >=left; i--) {
            leftBorder+=arr[i];
            if (maxLeftBorderSum<leftBorder){
                maxLeftBorderSum=leftBorder;
            }
        }
        for (int i = center+1; i<=right; i++) {
            mightBorder+=arr[i];
            if (maxRightBorderSum<mightBorder){
                maxRightBorderSum=mightBorder;
            }
        }
    return max(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);
    }
    //穷举法
    public static int getMaxSubSum2(int[] arr){
        int count=0;
        int maxSum=0;
        for (int i = 0; i < arr.length; i++) {
            int thisSum=0;
            for (int j = i; j < arr.length; j++) {
                thisSum+=arr[j];
                if (thisSum>maxSum){
                    maxSum=thisSum;
                }
            }
        }
        System.out.println(count);
        return maxSum;
    }
    //穷举法
    public static int getMaxSubSum(int[] arr){
        int count=0;
        int maxSum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int thisSum=0;
                for (int k = i; k < j; k++) {
                    count++;
                    thisSum+=arr[k];
                    if (thisSum>maxSum){
                        maxSum=thisSum;
                    }
                }
            }
        }
        System.out.println(count);
        return maxSum;
    }
}
