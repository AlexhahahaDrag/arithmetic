public class MyHashSet {
    static int[] arr;
    public static int size=0;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr=new int[10];
    }
    public void add(int key) {
        if(!contains(key)){
            if(size>=arr.length) {
                int[] newArr = arr;
                arr = new int[arr.length * 2];
                for (int i = 0; i < newArr.length; i++) {
                    arr[i] = newArr[i];
                }
            }
            arr[size++]=key;
        }
    }
    public void remove(int key) {
        if(contains(key)){
            int index=0;
            for(int i=0;i<size;i++) {
                if(arr[i]==key) {
                    index = i;
                }
            }
            for(int i=index;i<size;i++){
                arr[i]=arr[i+1];
            }
            size--;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for(int i=0;i<size;i++) {
            if(arr[i]==key) {
                return true;
            }
        }
        return false;
    }
}
class Solutin{
    public static void main(String[] args) {
        MyHashSet myHashSet=new MyHashSet();
        myHashSet.add(1);
        myHashSet.remove(1);
        myHashSet.remove(2);

        System.out.println(myHashSet.size);
        System.out.println(myHashSet.contains(2));
    }
}

