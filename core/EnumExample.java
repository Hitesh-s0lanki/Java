enum Laptop {
    MACBOOK(1500), HP, THINKPAD(500);

    private int price;

    private Laptop() {
        this.price = 200;
    }

    private Laptop(int price) {
        this.price = price;
    }

    void printPrice() {
        System.out.println("The Price of the " + this + " is " + this.price);
    }
}

enum Status {
    RUNNING,
    FAILED,
    PENDING,
    SUCCESS
}

public class EnumExample {
    public static void main(String[] args) {
        Status[] s = Status.values();

        for (Status obj : s) {
            System.out.println(obj);
        }

        for (Laptop obj : Laptop.values()) {
            obj.printPrice();
        }

    }

}
