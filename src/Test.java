import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<OgnizationTree> list = new ArrayList<>();
        list.add(new OgnizationTree(1,"企业主体信用得分",0,new ArrayList()));
        list.add(new OgnizationTree(5,"基本信息",2,new ArrayList()));
        list.add(new OgnizationTree(2,"企业素质",1,new ArrayList()));
        list.add(new OgnizationTree(10,"企业主体信息识别",5,new ArrayList()));
        list.add(new OgnizationTree(11,"企业持续注册时间",5,new ArrayList()));
        list.add(new OgnizationTree(6,"管理认证",2,new ArrayList()));
        for (OgnizationTree ot : list) {
            for (OgnizationTree ot1 : list) {
                if (ot.getPid()==ot1.getId()){
                    ot1.getList().add(ot);
                    break;
                }
            }
        }
        int len=list.size();
        for (int i=1;i<len;i++) {
            if (list.get(1).getId()!=1)
                list.remove(1);
        }
        System.out.println(list);
      /* BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<>();
        System.out.println(binarySearchTree.contains(4));
       binarySearchTree.insert(4);
       binarySearchTree.insert(5);
       binarySearchTree.insert(1);
       binarySearchTree.insert(1);
       binarySearchTree.insert(3);
        System.out.println(binarySearchTree.isEmpty());
        System.out.println(binarySearchTree.contains(4));
        System.out.println("min: "+binarySearchTree.findMax());
        System.out.println("max: "+binarySearchTree.findMin());
        binarySearchTree.printTree();
        binarySearchTree.remove(3);
        binarySearchTree.remove(4);
       binarySearchTree.printTree();
       binarySearchTree.makeEmpty();
        System.out.println(binarySearchTree.isEmpty());*/
    }
}
class OgnizationTree{
    int id;
    String name;
    int pid;
    List list;

    public OgnizationTree() {

    }

    public OgnizationTree(int id, String name, int pid, List list) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
