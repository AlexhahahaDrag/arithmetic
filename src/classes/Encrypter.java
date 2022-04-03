package classes;

import java.util.HashMap;
import java.util.Map;

public class Encrypter {

    private String[] map;
    private Map<String, Integer> root;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        root = new HashMap<>();
        map = new String[26];
        for(int i = 0; i < keys.length; i++) {
            map[keys[i] - 'a'] = values[i];
        }
        for (String dic : dictionary) {
            String encrypt = encrypt(dic);
            root.put(encrypt, root.getOrDefault(encrypt, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        char[] ch = word1.toCharArray();
        for(char c : ch) {
            String s = map[c - 'a'];
            if (s == null) {
                return "";
            }
            res.append(s);
        }
        return res.toString();
    }

    public int decrypt(String word2) {
        return root.getOrDefault(word2, 0);
    }


    public static void main(String[] args) {
//        char[] keys = {'a', 'b', 'c', 'd'};
//        String[] values = {"ei","zf","ei","am"};
//        String[] dictionary = {"abcd","acbd","adbc","badc","dacb","cadb","cbda","abad"};
//        String word1 = "abcd";//eizfeiam
//        String word2 = "eizfeiam";//2

        char[] keys = {'a', 'b', 'c', 'z'};
        String[] values = {"aa","bb","cc","zz"};
        String[] dictionary = {"aa","aaa","aaaa","aaaaa","aaaaaaa"};
        String word6 = "aefagafvabfgshdthn";//2
        Encrypter encrypter = new Encrypter(keys, values, dictionary);
        System.out.println(encrypter.decrypt(word6));
//        System.out.println(encrypter.decrypt(word2));
    }
}

