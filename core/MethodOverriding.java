class A {
    public void show() {
        System.out.println("Hello From A");
    }
}

class B extends A {

    @Override
    public void show() {
        System.out.println("Hello From B");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        new B().show();
    }
}
