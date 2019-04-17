public class Test3 {
    public static void main(String[] args) {
        String str="This is a story about Alice and Bob.Alice wants to send a private message to Bob.";
        System.out.println(gerCounts(str,20));
    }
    public static int gerCounts(String str,int K){
        int count=0;
        int start=-1;
        int indexA=returnIndex(start,"Alice",str);
        int indexB=returnIndex(start,"Bob",str);
        while(indexA!=-1&&indexB!=-1){
            if (Math.abs(indexA-indexB)<=K)
                count++;
            start=indexA>indexB?indexB+1:indexA+1;
            indexA=returnIndex(start,"Alice",str);
            indexB=returnIndex(start,"Bob",str);
        }
        return count;
    }
    public static int returnIndex(int start,String str,String strs){
        int index=strs.indexOf(str,start+1);
        if (index==-1)
            return -1;
        while(index!=-1){
            while(index!=0&&Character.isLetter(strs.charAt(index-1))&&Character.isLetter(strs.charAt(index+5))) {
                start = index;
                index = strs.indexOf("Alice", start + 1);
            }
            break;
        }
        return index;
    }
}
