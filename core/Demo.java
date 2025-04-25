class Calculate {
    public int sum(int a, int b) {
        return a + b;
    }
}

public class Demo {
    public static void main(String[] args) {
        Calculate cal = new Calculate();
        System.out.println(cal.sum(10, 100));
    }
}
