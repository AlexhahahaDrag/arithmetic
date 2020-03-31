/*快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。事实上，快速排序通常明显比其他Ο(n log n) 算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
        快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
        算法步骤：
        1 从数列中挑出一个元素，称为 "基准"（pivot），
        2 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
        3 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
        递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。*/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        getQuickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] getQuickSort(int[] arr,int start,int end){
        if (start<end){
            int a=divideArr(arr,start,end);
            if(start!=a-1){
                getQuickSort(arr,start,a-1);
            }
            if (end!=a+1){
                getQuickSort(arr,a+1,end);
            }
        }
        return arr;
    }
    public static int divideArr(int[] arr,int start,int end){
        int mid = start;
        while(start<end){
            while(start<end && arr[start]<= arr[mid])
                start++;
            while(start<end && arr[end]>arr[mid])
                end--;
            int c=arr[start];
            arr[start]=arr[end];
            arr[end]=c;
        }
        int d=arr[start - 1];
        arr[start - 1]=arr[mid];
        arr[mid]=d;
        return start - 1;
    }
}
