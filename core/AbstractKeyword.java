abstract class Car {

    public abstract void drive();

    public abstract void fly();

    public void playMusic() {
        System.out.println("play Music");
    }
}

class GWagon extends Car {
    public void drive() {
        System.out.println("Driving....");
    }

    public void fly() {
        System.out.println("Flying....");
    }
}

public class AbstractKeyword {
    public static void main(String[] args) {

        GWagon obj = new GWagon();
        obj.drive();
        obj.playMusic();

    }
}
