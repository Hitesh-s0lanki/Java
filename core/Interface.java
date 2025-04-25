interface A {

    // only final and static variable can be define
    final int area = 12;

    public void show();

    public void config();
}

class Demo implements A {
    public void show() {
        System.out.println("Hello world Show" + area);
    }

    public void config() {
        System.out.println("Hello World Config");
    }
}

public class Interface {
    public static void main(String[] args) {

    }
}
