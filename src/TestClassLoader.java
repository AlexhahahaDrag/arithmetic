public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader cl=TestClassLoader.class.getClassLoader();
        System.out.println(cl);
        ClassLoader cl1= cl.getParent();
        System.out.println(cl1);
        ClassLoader cl2=cl1.getParent();
        System.out.println(cl2);
    }
}
