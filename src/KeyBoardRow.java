import java.util.Arrays;

/**
 * @Description:Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 *
 *
 *jian pan
 *
 *
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 *
 * Note:
 *
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * @Author:      alex
 * @CreateDate:  2019/2/27 15:42
 * @param
 * @return
*/
public class KeyBoardRow {
    public static void main(String[] args) {
        String[] strings={"asdfghjkl","qwertyuiop","zxcvbnm"};
        String[] strings1=findWords(strings);
        for (String s:strings1) {
            System.out.println(s);
        }
    }
    public static String[] findWords(String[] words) {
        int[] letters=new int[26];
        letters['q'-'a']=1;
        letters['w'-'a']=1;
        letters['e'-'a']=1;
        letters['r'-'a']=1;
        letters['t'-'a']=1;
        letters['y'-'a']=1;
        letters['u'-'a']=1;
        letters['i'-'a']=1;
        letters['o'-'a']=1;
        letters['p'-'a']=1;
        letters['a'-'a']=2;
        letters['s'-'a']=2;
        letters['d'-'a']=2;
        letters['f'-'a']=2;
        letters['g'-'a']=2;
        letters['h'-'a']=2;
        letters['j'-'a']=2;
        letters['k'-'a']=2;
        letters['l'-'a']=2;
        letters['z'-'a']=3;
        letters['x'-'a']=3;
        letters['c'-'a']=3;
        letters['v'-'a']=3;
        letters['b'-'a']=3;
        letters['n'-'a']=3;
        letters['m'-'a']=3;
        int count=0;
        String[] strs=new String[words.length];
        for(String str:words){
            if(str.length()<2) {
                strs[count++]=str;
            } else{
                int index=0;
                String str1=str.toLowerCase();
                while(index<str.length()-1&&letters[str1.charAt(index)-'a']==letters[str1.charAt(index+1)-'a']) {
                    index++;
                }
                if(index==str.length()-1) {
                    strs[count++]=str;
                }
            }
        }
        return Arrays.copyOf(strs,count);
    }
}
