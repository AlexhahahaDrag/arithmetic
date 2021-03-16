/**
 * @Description: Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * *canConstruct("", "") -> true
 * @Author:      alex
 * @CreateDate:  2019/2/26 10:01
 * @param
 * @return
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a","b"));
    }
    public static boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character,Integer> mapRansomNote=new HashMap<>();
        Map<Character,Integer> mapMagazine=new HashMap<>();
        for(char ch:ransomNote.toCharArray()) {
            mapRansomNote.put(ch,mapRansomNote.getOrDefault(ch,0)+1);
        }
        for(char ch1:magazine.toCharArray()) {
            mapMagazine.put(ch1,mapMagazine.getOrDefault(ch1,0)+1);
        }
        Iterator<Map.Entry<Character,Integer>> it=mapRansomNote.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character,Integer> entry=it.next();
            if(!(mapMagazine.containsKey(entry.getKey())&&entry.getValue()<=mapMagazine.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int ransomNoteLen=ransomNote.length();
        if(ransomNoteLen==0) {
            return true;
        }
        int[] indexs=new int[26];
        for(int i=0;i<ransomNoteLen;i++) {
            indexs[ransomNote.charAt(i)-'a']++;
        }
        for(int j=0;j<magazine.length();j++){
            if(indexs[magazine.charAt(j)-'a']>0){
                indexs[magazine.charAt(j)-'a']--;
                ransomNoteLen--;
                if(ransomNoteLen==0) {
                    return true;
                }
            }
        }
        return false;
    }
}
