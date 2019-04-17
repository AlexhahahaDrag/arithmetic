/**
 * @Description:A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 * @Author:      alex
 * @CreateDate:  2019/2/13 14:20
 * @param
 * @return
*/
public class GoatLatin {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
    public static String toGoatLatin(String S) {
        String[] strings=S.split(" ");
        char[] chars={'a','e','i','o','u','A','E','I','O','U'};
        boolean[] charBoolean=new boolean[123];
        for (int i = 0; i < chars.length; i++)
            charBoolean[chars[i]-'A']=true;
        StringBuilder stringBuilder=new StringBuilder();
        StringBuilder stringBuilder1=new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder1.append("a");
            if (!charBoolean[strings[i].charAt(0)-'A']){
                stringBuilder.append(strings[i].substring(1));
                stringBuilder.append(strings[i].charAt(0));
            }else
                stringBuilder.append(strings[i]);
            stringBuilder.append("ma");
            stringBuilder.append(stringBuilder1);
            if (strings.length-1==i)
                break;
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
