class A {
    int age;

    public void show() {
        System.out.println("in Show");
    }

    static class B {
        public void config() {
            System.out.println("From Config B class...");
        }
    }

}

public class InnerClass {
    public static void main(String[] args) {

        A obj = new A() {
            public void show() {
                System.out.println("Inner Show implemented");
            }
        };
        obj.show();

        // A.B obj1 = obj.new B();
        // obj1.config();

        A.B obj1 = new A.B();
        obj1.config();
    }
}
