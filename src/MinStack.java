public class MinStack {
    protected static int size=0;
    protected static int[] arr;
    /** initialize your data structure here. */
    public MinStack() {
        arr=new int[10];
    }
    public void push(int x) {
        if(arr.length<=size){
            int[] arrNew=new int[size*2];
            for(int i=0;i<arr.length;i++) {
                arrNew[i]=arr[i];
            }
            arr=arrNew;
        }
        arr[size++]=x;
    }
    public void pop() {
        size--;
    }

    public int top() {
        return arr[size-1];
    }

    public int getMin() {
        int minNum=arr[0];
        for(int i=0;i<size;i++){
            if(arr[i]<minNum) {
                minNum=arr[i];
            }
        }
        return minNum;
    }
}
