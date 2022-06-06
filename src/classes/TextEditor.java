package classes;

public class TextEditor {

    private String str;
    private int index;
    public TextEditor() {
        str = "|";
        index = 0;
    }

    public void addText(String text) {
        str = str.substring(0, index) + text + "|" + str.substring(index + 1);
        index += text.length();
    }

    public int deleteText(int k) {
        if (index <= k) {
            int odd = index;
            str = str.substring(index);
            index = 0;
            return odd;
        }
        str = str.substring(0, index - k) + str.substring(index);
        index -= k;
        return k;
    }

    public String cursorLeft(int k) {
        if (k >= index) {
            String res = str.substring(0, index);
            str = "|" + res + str.substring(index + 1);
            index = 0;
            return str.substring(Math.max(0, index - 10), index);
        }
        String res = str.substring(index - k, index);
        str = str.substring(0, index - k) + "|" + res + str.substring(index + 1);
        index -= k;
        return str.substring(Math.max(0, index - 10), index);
    }

    public String cursorRight(int k) {
        if(str.length() <= index + k) {
            str = str.substring(0, index) + str.substring(index + 1) + "|";
            index = str.length() - 1;
            return str.substring(Math.max(0, index - 10), index);
        }
        str = str.substring(0, index) + str.substring(index + 1, index + k + 1) + "|" + str.substring(index + k + 1);
        index += k;
        return str.substring(Math.max(0 ,index - 10), index);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        System.out.println(textEditor.str);
        textEditor.deleteText(4); // 返回 4
        System.out.println(textEditor.str);
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        System.out.println(textEditor.str);
        textEditor.cursorRight(3); // 返回 "etpractice"
        System.out.println(textEditor.str);
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        textEditor.cursorLeft(8); // 返回 "leet"
        System.out.println(textEditor.str);
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        textEditor.deleteText(10); // 返回 4
        System.out.println(textEditor.str);
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        textEditor.cursorLeft(2); // 返回 ""
        System.out.println(textEditor.str);
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        textEditor.cursorRight(6); // 返回 "practi"
        System.out.println(textEditor.str);
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。

    }
}
