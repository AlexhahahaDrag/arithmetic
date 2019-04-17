import java.util.ArrayList;
import java.util.List;
/**
 * @Description: Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 *
 * Input: "OE"
 * Output: "EO"
 *
 * Input: ".,"
 * Output: ".,"
 * Note:
 * The vowels does not include the letter "y".
 * @Author:      alex
 * @CreateDate:  2019/1/24 14:59
 * @param
 * @return
*/
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String s="hello";
        System.out.println(reverseVowels1(s));
    }
    public static String reverseVowels1(String s){
        List<Character> list=new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        char[] letters=s.toCharArray();
        int start=0;
        int end=letters.length-1;
        while (start<end){
            while (start<end&&!list.contains(letters[start]))
                start++;
            while (start<end&&!list.contains(letters[end]))
                end--;
            letters[start]=(char)(letters[start]^letters[end]);
            letters[end]=(char)(letters[start]^letters[end]);
            letters[start]=(char)(letters[start]^letters[end]);
            start++;
            end--;
        }
        return new String(letters);
    }public static String reverseVowels(String s){
        char[] letters=s.toCharArray();
        int start=0;
        int end=letters.length-1;
        while (start<end){
            while (start<end&&!isVowel(letters[start]))
                start++;
            while (start<end&&!isVowel(letters[end]))
                end--;
            letters[start]=(char)(letters[start]^letters[end]);
            letters[end]=(char)(letters[start]^letters[end]);
            letters[start]=(char)(letters[start]^letters[end]);
            start++;
            end--;
        }
        return new String(letters);
    }
    static boolean isVowel(char a){
        switch (a){
            case 'a':return true;
            case 'e':return true;
            case 'i':return true;
            case 'o':return true;
            case 'u':return true;
            case 'A':return true;
            case 'E':return true;
            case 'I':return true;
            case 'O':return true;
            case 'U':return true;
            default:return false;
        }
    }
}
