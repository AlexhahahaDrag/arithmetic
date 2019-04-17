

/**
 * @Description: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 * @Author:      alex
 * @CreateDate:  2019/4/2 16:42
 * @param
 * @return
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome4("0P"));
    }
    public static boolean isPalindrome(String s) {
        int len=s.length();
        if(len==0||len==1)
            return true;
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(i<len){
            char c=s.charAt(i);
            if(Character.isDigit(c)||Character.isLetter(c))
                sb.append(Character.toLowerCase(c));
            i++;
        }
        return sb.toString().equals(sb.reverse().toString());
    }
    public static boolean isPalindrome1(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<end){
            char c='a';
            char cEnd;
            while(start<end){
                c= s.charAt(start);
                if(Character.isDigit(c)||Character.isLetter(c))
                    break;
                start++;
            }
            while(start<end){
                cEnd=s.charAt(end);
                if(Character.isDigit(cEnd)||Character.isLetter(cEnd)){
                    if(Character.toLowerCase(cEnd)==Character.toLowerCase(c))
                        break;
                    else
                        return false;
                }
                end--;
            }
            start++;
            end--;
        }
        return true;
    }
/*    private static final char[]charMap = new char[256];*/
    /*public static boolean isPalindrome2(String s) {
        for(int i=0;i<26;i++){
            if(i<10)
                charMap[i+'0'] = (char)(1+i);  // numeric
            charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
        }
        char[]pChars = s.toCharArray();
        int start = 0,end=pChars.length-1;
        char cS,cE;
        while(start<end){
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if(cS!=0 && cE!=0){
                if(cS!=cE)return false;
                start++;
                end--;
            }else{
                if(cS==0)start++;
                if(cE==0)end--;
            }
        }
        return true;
    }*/
    public static boolean isPalindrome3(String s) {
        char[]pChars = s.toCharArray();
        int start = 0,end=pChars.length-1;
        while(start<end){
            while (start<end&&!Character.isDigit(pChars[start])&&!Character.isLetter(pChars[start]))
                start++;
            while (start<end&&!Character.isDigit(pChars[end])&&!Character.isLetter(pChars[end]))
                end--;
            if (start<end){
                if (Character.toLowerCase(pChars[start])!=Character.toLowerCase(pChars[end]))
                    return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindrome4(String s) {
        char[] charMap1=new char[256];
        for(int i=0;i<26;i++){
            if(i<10)
                charMap1[i+'0']=(char)(i+1);
            charMap1[i+'a']=charMap1[i+'A']=(char)(11+i);
        }
        char[] sToArray=s.toCharArray();
        int start=0;
        int end=sToArray.length-1;
        while(start<end){
            char cS=charMap1[sToArray[start]];
            char cE=charMap1[sToArray[end]];
            if(cS==0) start++;
            else if(cE==0) end--;
            else if(cS!=cE)
                return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
