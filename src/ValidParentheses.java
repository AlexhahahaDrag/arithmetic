public class ValidParentheses {
    public static void main(String[] args) {
        String s="()[[]]{}";
        System.out.println(isValid(s));
    }
    /**
     * @Description:
     * @Author:      alex
     * @CreateDate:  2019/1/9 14:45
     * @param
     * @return
     */
    public static boolean isValid(String s){
        byte[] bytesNew=new byte[s.length()];
        int head=0;
        for (byte b:
                s.getBytes()) {
            switch (b){
                case '{':
                case '[':
                case '(':
                    bytesNew[head++]=b;
                    break;
                case ']':
                    if (head==0||bytesNew[--head]!='[')
                        return false;
                    break;
                case ')':
                    if (head==0||bytesNew[--head]!='(')
                        return false;
                    break;
                case '}':
                    if (head==0||bytesNew[--head]!='{')
                        return false;
                    break;
            }
        }
        return head==0;
    }
}
