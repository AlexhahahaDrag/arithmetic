/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary1("11","1"));
    }
    public static String addBinary(String a,String b){
        byte[] byteaNew=a.getBytes();
        byte[] bytebNew=b.getBytes();
        byte[] bytea=new byte[byteaNew.length];
        byte[] byteb=new byte[bytebNew.length];
        for (int i = 0; i < byteaNew.length; i++)
            bytea[i]=byteaNew[byteaNew.length-1-i];
        for (int i = 0; i < bytebNew.length; i++)
            byteb[i]=bytebNew[bytebNew.length-1-i];
        int i=0;
        StringBuilder newString=new StringBuilder();
        int count=0;
        while(i<bytea.length&&i<byteb.length){
            if (bytea[i]==byteb[i]){
                newString.append(count);
                if (bytea[i]==49)
                    count=1;
                else
                    count=0;
            }else if (count==1){
                newString.append(0);
            }else {
                count=0;
                newString.append(1);
            }
            i++;
        }
        while(i<bytea.length){
            if (count+48==bytea[i])
                newString.append(0);
            else {
                count=0;
                newString.append(1);
            }
            i++;
        }
        while(i<byteb.length){
            if (count+48==(int)byteb[i])
                newString.append(0);
            else {
                count=0;
                newString.append(1);
            }
            i++;
        }
        if (count==1)
            newString.append(1);
        return newString.reverse().toString();
    }
    public static String addBinary1(String a,String b){
        byte[] bytea=a.getBytes();
        byte[] byteb=b.getBytes();
        int starta=bytea.length-1;
        int startb=byteb.length-1;
        StringBuilder newString=new StringBuilder();
        int count=0;
        while(starta>=0&&startb>=0){
            int sum=bytea[starta]+byteb[startb]+count;
            switch (sum){
                case 99:
                    newString.append(1);
                    count=1;
                    break;
                case 98:
                    newString.append(0);
                    count=1;
                    break;
                case 97:
                    newString.append(1);
                    count=0;
                    break;
                case 96:
                    newString.append(0);
                    count=0;
            }
            starta--;
            startb--;
        }
        while(starta>=0){
            switch (bytea[starta]+count){
                case 50:
                    newString.append(0);
                    count=1;
                    break;
                case 49:
                    newString.append(1);
                    count=0;
                    break;
                case 48:
                    newString.append(0);
                    count=0;
            }
            starta--;
        }
        while(startb>=0){
            switch (byteb[startb]+count){
                case 50:
                    newString.append(0);
                    count=1;
                    break;
                case 49:
                    newString.append(1);
                    count=0;
                    break;
                case 48:
                    newString.append(0);
                    count=0;
            }
            startb--;
        }
        if (count==1)
            newString.append(1);
        return newString.reverse().toString();
    }
}
