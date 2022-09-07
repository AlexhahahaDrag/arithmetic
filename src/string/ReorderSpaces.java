package string;

public class ReorderSpaces {

    public String reorderSpaces(String text) {
        String[] strs = text.split(" ");
        int space = 0;
        int i = 0;
        int len = text.length();
        int start = 0;
        while (i < len && text.charAt(i) == ' ') {
            i++;
            space++;
        }
        start = i;
        int t = 0;
        boolean tf = true;
        while (i < len) {
            if (text.charAt(i) == ' ') {
                tf = true;
                space++;
            } else {
                if (tf) {
                    t++;
                }
                tf = false;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int eachSpace = t == 1 ? 0 : space / (t - 1);
        int endSpaceNum = t == 1 ? space : space % (t - 1);
        String es = "";
        while (--eachSpace >= 0) {
            es += " ";
        }
        tf = true;
        while (start < len) {
            if (text.charAt(start) == ' ') {
                if (tf && t > 1) {
                    t--;
                    sb.append(es);
                }
                tf = false;
            } else {
                tf = true;
                sb.append(text.charAt(start));
            }
            start++;
        }
        while (--endSpaceNum >= 0) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "  this   ";
        ReorderSpaces reorderSpaces = new ReorderSpaces();
        System.out.println(reorderSpaces.reorderSpaces(text));
    }
}
