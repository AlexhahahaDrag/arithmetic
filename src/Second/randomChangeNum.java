package Second;

import java.util.Random;

public class randomChangeNum {
    public static void main(String[] args) {
        int[] arr=getRandomChangeNum1(10);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] getRandomChangeNum(int n){
        int count=0;
        int[] arr=new int[n];
        Random random= new Random();
        int index=0;
        while(index<n){
            int num=random.nextInt(20);
            boolean flag=false;
            for (int i = 0; i < index; i++) {
                if (num==arr[i]){
                    flag=true;
                    count++;
                    break;
                }
            }
            if (!flag){
                count++;
                arr[index]=num;
                index++;
            }
        }
        System.out.println(count);
       return arr;
    }
    public static int[] getRandomChangeNum1(int n){
        int[] arr=new int[n];
        boolean[] arr1=new boolean[20];
        int index=0;
        Random random=new Random();
        while (index<n){
            int num=random.nextInt(20);
            if (!arr1[num]){
              arr[index++]=num;
              arr1[num]=true;
            }
        }
        return arr;
    }
}
