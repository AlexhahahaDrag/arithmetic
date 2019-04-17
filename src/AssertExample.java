public class AssertExample {
    public AssertExample() {
    }

    public static void main(String[] args) {
        int x=10;
        System.out.println("test assert");
        assert x==100:"Out assertion failed";
        System.out.println("test assert passed");
    }
}
