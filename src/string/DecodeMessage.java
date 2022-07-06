package string;

import java.util.Arrays;

public class DecodeMessage {

    public String decodeMessage(String key, String message) {
        int[] map = new int[26];
        int space = 0;
        int more = 0;
        Arrays.fill(map, - 1);
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ') {
                space++;
                continue;
            }
            if (map[c - 'a'] == -1) {
                map[c - 'a'] = i - space - more;
            } else {
                more++;
            }
        }

        char[] ch = message.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == ' ') {
                continue;
            }
            ch[i] = (char)(map[ch[i] - 'a'] + 'a');
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        DecodeMessage decodeMessage = new DecodeMessage();
        System.out.println(decodeMessage.decodeMessage(key, message));
    }
}
