public class RemoveKDigit {
    public static void main(String[] args) {
        System.out.println(removeKdigits("212222243332219",3));
    }
    public static String removeKdigits1(String num, int k) {
        if(k>=num.length())
            return "0";
        int len=num.length();
        StringBuilder sb=new StringBuilder(num);
        for(int i=1;i<sb.length();i++)
            while(i>0&&sb.charAt(i)<sb.charAt(i-1)&&k-->0){
                sb.delete(i-1,i);
                i--;
            }
        while(k-->0)
            sb.delete(sb.length()-1,sb.length());
        while(sb.length()>1&&sb.charAt(0)=='0')
            sb.delete(0,1);
        return sb.toString();
    }
    public static String removeKdigits(String num, int k) {
        int remain = num.length() - k;
        char[] arr = num.toCharArray();
        char[] res = new char[remain];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while ((arr.length - i > remain - index) && (index > 0 && arr[i] < res[index - 1]))
                index--;
            if (index < remain)
                res[index++] = arr[i];
        }
        // check leading zeroes
        index = -1;
        while (++index < remain) {
            if (res[index] != '0') break;
        }
        String s = new String(res).substring(index);
        return s.length() == 0 ? "0" : s;
    }
}
