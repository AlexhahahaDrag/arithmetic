import java.io.File;

public class DocumentTraverse {
    public static void main(String[] args) {
        File file=new File("f:\\project-upload\\bas_files\\nontempnontemp\\1562223218879_3.jpg");
        System.out.println(file.getName() +" 111111111111" + file.getPath());
       traverse(file);
    }
    public static void traverse(File file){
        if (file.isDirectory()){
            File[] file1=file.listFiles();
            for (File filei: file1) {
                traverse(filei);
            }
        }else {
            System.out.println(file.getParent()+"/"+file.getName()+"("+file.getUsableSpace()/1024/1024/1024+"G)");
        }
    }
}
