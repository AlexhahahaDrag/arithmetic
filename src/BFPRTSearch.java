import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*BFPRT 算法解决的问题十分经典，即从某n个元素的序列中选出第k大（第k小）的元素，通过巧妙的分析，
        BFPRT 可以保证在最坏情况下仍为线性时间复杂度。
        该算法的思想与快速排序思想相似，当然，为使得算法在最坏情况下，依然能达到o(n)的时间复杂度，五位算法作者做了精妙的处理。*/
public class BFPRTSearch {
    public static void main(String[] args) {
        int[] arr={7,8,5,2,4};
        double a=0;
        System.out.println(1 << 4);
        System.out.println(1/a);
        System.out.println(getBFPRTSearch(arr,4));
    }
    public static int getBFPRTSearch(int[] arr,int k){
        int[] arr1=divideBFPRTInt(arr);
        int[] liftList=null;
        int[] rightList=null;
        int same=0;
        int x=getCenterNum(arr1,0,arr1.length);
        for (int i = 0; i < arr.length; i++) {
            if (x>arr[i]){
               liftList=add(liftList,arr[i]);
            }else {
                if (x==arr[i]){
                    same++;
                }
                rightList=add(rightList,arr[i]);
            }
        }
        if(rightList.length==k){
            return x;
        }else if (rightList.length>k){
            if (rightList.length-same<k){
                return x;
            }else{
                return getBFPRTSearch(rightList,k);
            }
        }else if(rightList.length<k){
            return getBFPRTSearch(liftList,k-rightList.length);
        }
        return 0;
    }
    //分组取中位数
    public static int[] divideBFPRTInt(int[] arr){
        int num=0;
        if (arr.length/5==0){
            num=arr.length/5;
        }else {
            num=arr.length/5-1;
        }
        int[] centerNumArr=new int[num+1];
        for (int i = 0; i < num+1; i++) {
            centerNumArr[i]=getCenterNum(arr,5*i,arr.length>5*(1+i)?5*(1+i):arr.length);
        }
        return centerNumArr;
    }
    //插入排序
    public static int getCenterNum(int[] arr,int start,int end){
       if (end-start==2){
            return arr[start]>arr[end-1]?arr[start]:arr[end-1];
        }
        for (int i = start; i < end; i++) {
            int j=i;
            while (j>start&&arr[j]<arr[j-1]){
                int a=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=a;
                j--;
            }
        }
        return arr[end-(end-start)/2-1];
    }
    //添加元素
    public static int[] add(int[] arr,int a){
        int[] liftList1;
        if (arr==null){
            liftList1=new int[1];
        }else{
            liftList1=new int[arr.length+1];
        }
        int j = 0;
        while(j < liftList1.length-1){
            liftList1[j]=arr[j];
            j++;
        }
        liftList1[j]=a;
        arr=liftList1;
        return arr;
    }
}
