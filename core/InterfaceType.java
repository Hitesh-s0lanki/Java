@FunctionalInterface
interface A {
    void show();
}

public class InterfaceType {
    public static void main(String[] args) {
        A obj = new A() {
            public void show() {
                System.out.println("Hello world!");
            }
        };

        obj.show();
    }
}
