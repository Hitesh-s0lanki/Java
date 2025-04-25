class A extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is from A Class");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {

            System.out.println("This is from B Class");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Z implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {

            System.out.println("This is from Z Class");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadHandling {
    public static void main(String[] args) {

        A objA = new A();
        B objB = new B();
        Runnable objZ = new Z();

        Runnable objRunnable = () -> {
            for (int i = 0; i < 5; i++) {

                System.out.println("This is from Runnable Class");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(objZ);
        Thread t2 = new Thread(objRunnable);
        objB.setPriority(Thread.MAX_PRIORITY);

        objA.start();
        objB.start();
        t1.start();
        t2.start();
    }
}
