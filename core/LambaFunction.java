@FunctionalInterface
interface A {
    void show(int i);
}

@FunctionalInterface
interface B {
    int sum(int a, int b);
}

public class LambaFunction {
    public static void main(String[] args) {

        A obj = i -> System.out.println("Hello world! " + i);
        obj.show(10);

        B obj1 = (a, b) -> a + b;
        System.out.println(obj1.sum(10, 60));
    }
}
