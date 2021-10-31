package string_array;

import java.util.Arrays;

public class FindWords {

    public String[] findWords(String[] words) {
        int row;
        int size = 0;
        int index;
        int len;
        for(String word : words) {
            index = -1;
            len = word.length();
            row = -1;
            while(++index < len) {
                int c = charRow(word.charAt(index));
                if(row != -1 && row != c) {
                    break;
                }
                row = c;
            }
            if(index == len) {
                words[size++] = word;
            }
        }
        return Arrays.copyOfRange(words, 0, size);
    }

    private int charRow(char c) {
        switch(c) {
            case 'q':
            case 'w':
            case 'e':
            case 'r':
            case 't':
            case 'y':
            case 'u':
            case 'i':
            case 'o':
            case 'p':
            case 'Q':
            case 'W':
            case 'E':
            case 'R':
            case 'T':
            case 'Y':
            case 'U':
            case 'I':
            case 'O':
            case 'P':
                return 1;
            case 'a':
            case 's':
            case 'd':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
            case 'A':
            case 'S':
            case 'D':
            case 'F':
            case 'G':
            case 'H':
            case 'J':
            case 'K':
            case 'L':
                return 2;
            case 'z':
            case 'x':
            case 'c':
            case 'v':
            case 'b':
            case 'n':
            case 'm':
            case 'Z':
            case 'X':
            case 'C':
            case 'V':
            case 'B':
            case 'N':
            case 'M':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"asdfghjkl","qwertyuiop","zxcvbnm"};
        FindWords findWords = new FindWords();
        String[] res = findWords.findWords(words);
        for(String word : res) {
            System.out.print(word + ",");
        }
    }
}
